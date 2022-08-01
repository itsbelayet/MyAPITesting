package restAssuredTestNG;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002_GET_Request_FakeAPI {

    // To run the Fake Run the below command to make your API’s up and running
    // cmd Prompt> json-server info.json

    @Test
    void getRequest(){
        //Specify base URI
        RestAssured.baseURI="http://localhost:3000";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();

        //Response object
        Response response=httpRequest.request(Method.GET,"/users/2");

        //Print response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body : "+responseBody);

        //Print headers
//        Headers allheaders=response.headers();
//        for (Header hd:allheaders){
//            System.out.println(hd.getName()+" --> "+hd.getValue());
//        }

        //Status Code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code : "+statusCode);
        Assert.assertEquals(statusCode,200);

        //Status line varification
        String statusLine=response.statusLine();
        System.out.println("\nNStatus Line : "+statusLine);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");

    }
}
