package com.TestingAPI.RestAssuredBasics.DELETE;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_DELETE_NONBDDStyle_TestNG {

    RequestSpecification rs;
    Response response;
    ValidatableResponse vr;
    @Description("Verify the DELETE Req Positive")
    @Test
    public void test_DELETE_Positive() {

        String token = "fe8f1c3f83c9c25";
        String bookingid = "4256";
        rs = RestAssured
                .given();


        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);

        rs.log().all();


        response = rs.when().log().all().delete();
        vr = response.then();
        vr.log().all().statusCode(201);
    }

}
