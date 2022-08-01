package restAssuredTestNG;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FAKE01_GET_Single_Request extends TestBase {

    @BeforeClass
    void getSingleData() throws InterruptedException {
        RestAssured.baseURI = "http://localhost:3000";
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/users/" + userID);
        Thread.sleep(3000);
    }

    @Test
    void checkResponseBody() {
        String responseBody = response.getBody().asString();
        Assert.assertEquals(responseBody.contains(userID), true);
    }
    @Test
    void checkStatusCode(){
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
    @Test
    void checkResponseTime(){
        long responstTime=response.getTime();
        Assert.assertTrue(responstTime<600);
    }
    @Test
    void checkStatusLine(){
        String statusLine=response.getStatusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
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
