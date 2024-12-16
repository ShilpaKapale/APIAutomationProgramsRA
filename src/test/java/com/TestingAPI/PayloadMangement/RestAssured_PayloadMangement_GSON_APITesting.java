package com.TestingAPI.PayloadMangement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class RestAssured_PayloadMangement_GSON_APITesting {

    RequestSpecification rs;
    ValidatableResponse vr;
    Response r;
    String token;
    Integer bookingid;
@Test
    public void test_POST(){
//        String payloadPUT = "{\n" +
//                "    \"firstname\" : \"James\",\n" +
//                "    \"lastname\" : \"Brown\",\n" +
//                "    \"totalprice\" : 222,\n" +
//                "    \"depositpaid\" : false,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2024-01-01\",\n" +
//                "        \"checkout\" : \"2024-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";

        Map<String,Object> jsonBodyusingMap = new LinkedHashMap<>();
        jsonBodyusingMap.put("firstname","James");
        jsonBodyusingMap.put("lastname","Brown");
        jsonBodyusingMap.put("totalprice",654);
        jsonBodyusingMap.put("depositpaid",false);

        Map<String,Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2024-01-01");
        bookingDatesMap.put("checkout","2024-01-01");

        jsonBodyusingMap.put("bookingdates",bookingDatesMap);
        jsonBodyusingMap.put("additionalneeds","Breakfast");

    System.out.println(jsonBodyusingMap);
    //Output
    //{firstname=Jim, lastname=Dutta, totalprice=654, depositpaid=true, bookingdates={checkin=2024-01-01, checkout=2024-01-01}, additionalneeds=Breakfast}


        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(jsonBodyusingMap).log().all();

        Response r = rs.when().post();

        //Get Validatable response to perform validation
        vr = r.then().log().all();
        vr.statusCode(200);
        vr.body("bookingid",Matchers.notNullValue());
        vr.body("booking.firstname",Matchers.equalTo("James"));
        vr.body("booking.depositpaid",Matchers.equalTo(false));
        vr.body("bookingid",Matchers.notNullValue());

//Extraction part
        bookingid =r.then().extract().path("bookingid");
        String firstname = r.then().extract().path("booking.firstname");
        String lastname = r.then().extract().path("booking.lastname");
//TestNG Assertion
    Assert.assertNotNull(bookingid);
    Assert.assertEquals(firstname,"James");
    Assert.assertEquals(lastname,"Brown");

    //AssertJ(3rd - Lib to Assertions)

    assertThat(bookingid).isNotNull().isNotZero().isPositive();
    assertThat(firstname).isEqualTo("James").isNotEmpty().isNotNull().isAlphanumeric().isNotBlank();

    String s = "";//Empty
    String s1 = " ";//Blank

    }
}
