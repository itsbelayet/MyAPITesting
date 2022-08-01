package restAssuredTestNG;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TestRestAssured {
    @Test
    void testRest() {

        RestAssured.baseURI = "https://reqres.in/api";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "/users/1");

        String responseBody = response.getBody().asString();

        System.out.println("Resbonse Body is :" + responseBody);
    }
}
