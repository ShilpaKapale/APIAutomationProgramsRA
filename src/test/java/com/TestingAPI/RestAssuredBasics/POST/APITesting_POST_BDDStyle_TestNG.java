package com.TestingAPI.RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITesting_POST_BDDStyle_TestNG {
    @Description("Verify the POST Req Positive")
    @Test
    public void test_GET_Positive(){
String payload = "{\n" +
        "    \"username\" : \"admin\",\n" +
        "    \"password\" : \"password123\"\n" +
        "}";

    RestAssured.given()
            .baseUri("https://restful-booker.herokuapp.com")
            .basePath("/auth")
        .contentType(ContentType.JSON)
            .log().all().body(payload)
            .when().log().all().post()
            .then().log().all().statusCode(200);
    }
}
