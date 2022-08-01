package restAssuredTestNG;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_POST_Request {
    @Test
    void postRequest() {
        //Specify base URI
        RestAssured.baseURI = "http://dummy.restapiexample.com/api";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Request payload sending along with post request
        JSONObject requestParams = new JSONObject();

        requestParams.put("name", "Belayet");
        requestParams.put("salary", "5050");
        requestParams.put("age", "58");

        httpRequest.header("Content-Type","application/json");
        httpRequest.body(requestParams.toString());

        //Response object
        Response response=httpRequest.request(Method.POST,"/v1/create");

        //Print response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body : "+responseBody);

        //Validation
        int statusCode=response.getStatusCode();
        System.out.println("Status Code : "+statusCode);
        Assert.assertEquals(statusCode,201);

    }
}
