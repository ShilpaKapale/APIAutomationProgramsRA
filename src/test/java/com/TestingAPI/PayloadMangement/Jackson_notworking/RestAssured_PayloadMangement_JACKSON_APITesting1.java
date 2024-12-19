//package com.TestingAPI.PayloadMangement.Jackson;
//
//import com.TestingAPI.PayloadMangement.GSON.Booking;
//import com.TestingAPI.PayloadMangement.GSON.BookingResponse;
//import com.TestingAPI.PayloadMangement.GSON.Bookingdates;
//import com.google.gson.Gson;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.mapper.ObjectMapper;
//import io.restassured.mapper.ObjectMapperDeserializationContext;
//import io.restassured.mapper.ObjectMapperSerializationContext;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.response.ValidatableResponse;
//import io.restassured.specification.RequestSpecification;
//import org.testng.annotations.Test;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class RestAssured_PayloadMangement_JACKSON_APITesting1 {
//
//    RequestSpecification rs;
//    ValidatableResponse vr;
////    Response r;
////    String token;
////    Integer bookingid;
//@Test
//    public void test_Create_Booking_Postive(){
//        //Gson gson = new Gson();
//    Booking booking = new Booking();
//    booking.setFirstname("James");
//    booking.setLastname("Brown");
//    booking.setTotalprice(112);
//    booking.setDepositpaid(true);
//
//    Bookingdates bookingdate = new Bookingdates();
//    bookingdate.setCheckin("2024-01-01");
//    bookingdate.setCheckout("2024-01-01");
//    booking.setBookingdates(bookingdate);
//    booking.setAdditionalneeds("Breakfast");
//
//    System.out.println(booking);
//
//    //Java Object -> JSON
//
////    Gson gson = new Gson();
////    String jsonStringBooking = gson.toJson(booking);
////    System.out.println(jsonStringBooking);
//
//
//    ObjectMapper objectMapper;
//    objectMapper = new ObjectMapper();
//    String jsonStringBooking;
//    jsonStringBooking = objectMapper.writerWithDefaultPrettyPrinter().writerValueAsString(booking);
//
//
//    rs = RestAssured.given();
//    rs.baseUri("https://restful-booker.herokuapp.com/");
//    rs.basePath("/booking");
//    rs.contentType(ContentType.JSON);
//    rs.body(jsonStringBooking).log().all();
//
//    Response r = rs.when().post();
//    String jsonStringResponse = r.asString();
//
//    //Get Validatable response to perform validation
//    vr = r.then().log().all();
//    vr.statusCode(200);
//
//    //Types of extraction way
//    //Case1 extract() Direct extraction
//    System.out.println("** Direct extract method **");
//    Integer bookingID =r.then().extract().path("bookingid");
//    System.out.println(bookingID);
//    String firstname1= r.then().extract().path("booking.firstname");
//    System.out.println(firstname1);
//
//
//    //Case2 jsonpath.getString() - jsonpath extraction
//    System.out.println("** Json extract method **");
//    JsonPath jsonPath = new JsonPath(r.asString());
//    String bookingId = jsonPath.getString("bookingid");
//    String firstname = jsonPath.getString("booking.firstname");
//    System.out.println(bookingId);
//    System.out.println(firstname);
//
//    //Case3 De Serialozation extraction
//    System.out.println("** GSON De Serialozation extract method **");
//BookingResponse bookingResponse = gson.fromJson(jsonStringResponse, BookingResponse.class);
//    System.out.println(bookingResponse.getBookingid());
//    System.out.println(bookingResponse.getBooking().getFirstname());
//    System.out.println(bookingResponse.getBooking().getLastname());
//
//
//    assertThat(bookingResponse.getBookingid()).isNotNull().isNotZero().isPositive();
//    assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("James").isNotEmpty().isNotNull().isAlphanumeric().isNotBlank();
//    }
//}
