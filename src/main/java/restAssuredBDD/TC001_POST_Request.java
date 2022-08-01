package restAssuredBDD;

import io.restassured.RestAssured;
import org.testng.annotations.*;
import restAssuredTestNG.RestUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.*;


public class TC001_POST_Request extends RestUtils {     // for Fake API

    HashMap map = new HashMap();

    @BeforeClass
    void postData() {
        map.put("name", empName());  // imported from RestUtils
        map.put("location", location());
        map.put("phone", phone());

        RestAssured.baseURI = "http://localhost:3000";
        RestAssured.basePath = "/users";
    }

    @Test
    void postRequest() {
        given()
                .contentType("application/json; charset=utf-8")
                .body(map)
                .when()
                .post()
                .then()
                .statusCode(201);
//                .and()
//                .assertThat().body("name", equalTo(empName()));
//                .body("name",empName());
    }
}
