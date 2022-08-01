package restAssuredBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TC001_GET_SingleRequest {

    @Test(enabled = false)
    void getFakeUser() {            // for Fake API
        given()
                .when()
                .get("http://localhost:3000/users/5")
                .then()
                .statusCode(200)
                .assertThat().body("name", equalTo("Miru"))
                .header("Content-Type", "application/json; charset=utf-8");

    }
    @Test(enabled = true)
    void getSingleUser() {
        given()
                .when()
                .get(" http://dummy.restapiexample.com/api/v1/employee/5")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                //.assertThat().body(contains("Successfully! Record has been fetched."))
                .log().all();

    }

}
