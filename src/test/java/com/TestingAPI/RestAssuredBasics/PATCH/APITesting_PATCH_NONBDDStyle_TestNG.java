package com.TestingAPI.RestAssuredBasics.PATCH;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_PATCH_NONBDDStyle_TestNG {

    RequestSpecification rs;
    Response response;
    ValidatableResponse vr;
    @Description("Verify the PATCH Req Positive")
    @Test
    public void test_PATCH_Positive() {
        String payloadpatch = "{\n" +
                "    \"firstname\" : \"Kalli\",\n" +
                "    \"lastname\" : \"Mark\"\n" +
                "}";

        String token = "34b7b03a2ecf071";
        String bookingid = "3925";
        rs = RestAssured
                .given();


        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);

        rs.body(payloadpatch).log().all();


        response = rs.when().log().all().patch();
        vr = response.then();
        vr.log().all().statusCode(200);
    }

}
