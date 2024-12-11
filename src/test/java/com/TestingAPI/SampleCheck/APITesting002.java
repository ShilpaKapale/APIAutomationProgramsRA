package com.TestingAPI.SampleCheck;

import io.restassured.RestAssured;

public class APITesting002 {
    public static void main(String[] args) {
        RestAssured
                .given()
                     .baseUri("https://api.zippopotam.us")
                     .basePath("/IN/560016")
                .when()
                     .get()
                .then().log().all().statusCode(200);

    }
}
