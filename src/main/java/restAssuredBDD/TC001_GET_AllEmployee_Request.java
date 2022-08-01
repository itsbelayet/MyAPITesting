package restAssuredBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TC001_GET_AllEmployee_Request {

    @Test(enabled = true)
    void getAllEmployee() {
        given()
                .when()
                .get("https://dummy.restapiexample.com/api/v1/employees")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                //.body("RestResponse.resultl.employee_name",equalsTo("Airi Satou"))
                //.body("RestResponse.resultl.employee_name", hasItems("Tiger Nixon", "Garrett Winters", "Airi Satou"))
                //.assertThat().body(contains("Airi Satou"))
                .log().all();
    }
    @Test(enabled = true)
    void getSingleEmployee() {
        given()
                .when()
                .get("https://dummy.restapiexample.com/api/v1/employee/12")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .log().all();
    }
}
