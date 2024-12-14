package com.TestingAPI.RestAssuredBasics.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;



public class APITesting_PUT_NONBDDStyle_TestNG {

    RequestSpecification rs;
    Response response;
    ValidatableResponse vr;
    @Description("Verify the PUT Req Positive")
    @Test
    public void test_put_NONBDD() {

            String payloadPUT = "{\n" +
                    "    \"firstname\" : \"James1\",\n" +
                    "    \"lastname\" : \"Brown1\",\n" +
                    "    \"totalprice\" : 222,\n" +
                    "    \"depositpaid\" : false,\n" +
                    "    \"bookingdates\" : {\n" +
                    "        \"checkin\" : \"2024-01-01\",\n" +
                    "        \"checkout\" : \"2024-01-01\"\n" +
                     "    },\n" +
                    "    \"additionalneeds\" : \"Breakfast\"\n" +
                    "}";

        String token = "34b7b03a2ecf071";
        String bookingid = "3925";
        rs = RestAssured
                .given();


        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking/"+bookingid);
        rs.contentType(ContentType.JSON);
        rs.cookie("token",token);

        rs.body(payloadPUT).log().all();


        response = rs.when().log().all().put();
        vr = response.then();
        vr.log().all().statusCode(200);

      }
}
