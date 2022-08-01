package restAssuredTestNG;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FAKE02_POST_Single_Record extends TestBase {
    String userName = RestUtils.empName();
    String location = RestUtils.location();
    String phone = RestUtils.phone();

    @BeforeClass
    void createUser() throws InterruptedException {
        RestAssured.baseURI = "http://localhost:3000";
        httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name", userName);
        requestParams.put("location", location);
        requestParams.put("phone", phone);

        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(requestParams.toString());

        response = httpRequest.request(Method.POST, "/users");
        Thread.sleep(3000);
    }

    @Test
    void checkStatusCode() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

    @Test
    void checkResponseBody() {
        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody.contains(userName), true);
        Assert.assertEquals(responseBody.contains(location), true);
        Assert.assertEquals(responseBody.contains(phone), true);
    }

    @Test
    void checkResponseTime() {
        long responseTime = response.getTime();
        Assert.assertTrue(responseTime > 400);
        System.out.printf(String.valueOf(responseTime));
    }

    @Test
    void checkStatusLine() {
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 201 Created");
    }

    @Test
    void checkContentType() {
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=utf-8");
    }
//    @Test
//    void checkContentEncoding() {
//        String contentEncoding = response.header("Content-Encoding");
//        Assert.assertEquals(contentEncoding, "null");
//    }

}
