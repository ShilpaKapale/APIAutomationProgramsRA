package com.TestingAPI.TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting_Annotations_BeforeAfter_TestNG {
    @BeforeTest()
    public void getToken(){
        System.out.println("1");
    }
    @BeforeTest()
    public void getBookingID(){
        System.out.println("2");
    }
    @Test()
    public void test_PUT(){
        System.out.println("3");
    }
    @AfterTest
    public void closeALLthings(){
        System.out.println("Close");
    }
}
