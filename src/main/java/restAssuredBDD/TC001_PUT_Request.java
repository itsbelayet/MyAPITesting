package restAssuredBDD;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import restAssuredTestNG.RestUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class TC001_PUT_Request extends RestUtils {

    HashMap map = new HashMap();
    int emp_id = 5;

    @BeforeClass
    void putData() {
        map.put("employee_name", empName());  // imported from RestUtils
        map.put("employee_salary", phone());
        map.put("employee_age", age());

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = "/update/" + emp_id;
    }

    @Test
    public void testPUT() {
        given()
                .contentType("application/json")
                .body(map)
                .when()
                .put()
                .then()
                .statusCode(200)
                .log().all();

    }
}
