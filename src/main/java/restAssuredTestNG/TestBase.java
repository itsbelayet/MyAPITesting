package restAssuredTestNG;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
    public static RequestSpecification httpRequest;
    public static Response response;
    public String userID="10",uID="22";

}
