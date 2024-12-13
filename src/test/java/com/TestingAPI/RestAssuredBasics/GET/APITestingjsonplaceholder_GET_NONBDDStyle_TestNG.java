package com.TestingAPI.RestAssuredBasics.GET;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITestingjsonplaceholder_GET_NONBDDStyle_TestNG {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("Verify the GET Req Positive")
    @Test
    public void test_GET_Positive() {
        String id = "1";

        r = RestAssured
                .given();
        r.baseUri("https://jsonplaceholder.typicode.com/posts/");
        r.basePath("/" + id);

        response = r.when().log().all().get();

        vr = response.then();
        vr.log().all().statusCode(200);
    }

    @Description("Verify the GET Req Negative -1 input")
    @Test
    public void test_GET_Negative0() {

        String id = "1.45";

        r = RestAssured
                .given();
        r.baseUri("https://jsonplaceholder.typicode.com/posts/");
        r.basePath("/" + id);

        response = r.when().log().all().get();

        vr = response.then();
        vr.log().all().statusCode(200);
    }

    @Description("Verify the GET Req Negative 100000000000000000000000000000 input")
    @Test
    public void test_GET_Negative1() {
        String id = "100000000000000000000000000000";

        r = RestAssured
                .given();
        r.baseUri("https://jsonplaceholder.typicode.com/posts/");
        r.basePath("/" + id);

        response = r.when().log().all().get();

        vr = response.then();
        vr.log().all().statusCode(200);
    }


}

