package restAssuredTestNG;

import io.restassured.http.Method;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FAKE01_GET_All_Request extends TestBase {

    @BeforeClass
    void getAllData() throws InterruptedException {
        RestAssured.baseURI = "http://localhost:3000";
        httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/users");
        Thread.sleep(3000);
    }

    @Test
    void checkResponseBody() {
        String responseBody = response.getBody().asString();
//        System.out.println("String Body : " + responseBody);
        Assert.assertTrue(responseBody != null);
    }

    @Test
    void checkStatusCode() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    void checkResponseTime() {
        long responseTime = response.getTime();
        if (responseTime > 500) {
            System.out.println("Response Time is grater then 400");
        }
//        System.out.printf(String.valueOf(responseTime));

        Assert.assertTrue(responseTime > 400);
    }

    @Test
    void checkStatus() {
        String status = response.getStatusLine();
        Assert.assertEquals(status, "HTTP/1.1 200 OK");
    }

    @Test
    void checkContentType() {
        String contentType = response.header("Content-Type");
        Assert.assertEquals(contentType, "application/json; charset=utf-8");
    }

    @Test
    void checkContentEncoding() {
        String contentEncoding = response.header("Content-Encoding");
        Assert.assertEquals(contentEncoding, "gzip");
    }
    /*
    @Test
    void checkServerType() {
        String serverType = response.header("Server");
        Assert.assertEquals(serverType, "null");
    }
    @Test
    void checkContentLength() {
        String contentLength = response.header("Content-Length");
        Assert.assertEquals(contentLength, "null");
    }

    @Test
    void checkCookies() {
        String cookie = response.getCookie("PHPSESSID");
        Assert.assertEquals(cookie, "null");
    }
    */
}
