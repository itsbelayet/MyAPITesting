package restAssuredBDD;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TC001_DELETE_Request {

    @Test(enabled = false)
    void deleteRequest() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = "/delete/15";

        given()
                .when()
                .delete()
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .log().all();
    }

    @Test(enabled = true)
    void deleteRequest1() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
        RestAssured.basePath = "/delete/16";

        Response response =

                given()
                        .when()
                        .delete()
                        .then()
                        .statusCode(200)
                        .statusLine("HTTP/1.1 200 OK")
                        .log().all()

                        .extract().response();

        String jsonString = response.asString();
        Assert.assertEquals(jsonString.contains("Successfully! Record has been deleted"), true);
    }

}
