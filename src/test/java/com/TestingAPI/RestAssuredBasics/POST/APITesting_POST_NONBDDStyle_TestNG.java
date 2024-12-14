package com.TestingAPI.RestAssuredBasics.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_POST_NONBDDStyle_TestNG {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Description("Verify the POST Req Positive")
    @Test
    public void test_POST_Positive() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r = RestAssured
                .given();
        r.baseUri("https://restful-booker.herokuapp.com")
        .basePath("/auth")
        .contentType(ContentType.JSON)
                .log().all().body(payload)
                .when().log().all().post()
                .then().log().all().statusCode(200);

        response = r.when().log().all().post();

        vr = response.then();
        vr.log().all().statusCode(200);
    }

}
