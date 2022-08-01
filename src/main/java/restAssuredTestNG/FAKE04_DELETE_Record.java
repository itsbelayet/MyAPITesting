package restAssuredTestNG;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
//import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FAKE04_DELETE_Record extends TestBase {
    @BeforeClass
    void deleteUser() throws InterruptedException {
        RestAssured.baseURI = "http://localhost:3000";
        httpRequest = RestAssured.given();

//        // Delete 1st record all time
//        response = httpRequest.request(Method.GET, "/users");
//        JsonPath jsonPath=response.jsonPath();
//        String uID=jsonPath.get("x[0].id");

        response = httpRequest.request(Method.DELETE, "/users/" + uID);
        Thread.sleep(3000);
    }

//    @Test
//    void checkResponseBody() {
//        String responseBody = response.getBody().asString();
//        Assert.assertEquals(responseBody.contains("successfully! deleted Records"), true);
//    }

    @Test
    void checkStatusCode() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void checkStatusLine() {
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
    }
}
