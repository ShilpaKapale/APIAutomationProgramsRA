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

public class RestAssured_PayloadMangement_POJO_APITesting {

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

        Bookings booking = new Bookings();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(645);
        booking.setDepositpaid(false);

        Bookingdates dates = new Bookingdates();
    dates.setCheckin("2024-01-01");
    dates.setCheckout("2024-01-01");
    booking.setBookingdates(dates);
    booking.setAdditionalneeds("Breakfast");

    System.out.println(booking);



        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com/");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(booking).log().all();

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
