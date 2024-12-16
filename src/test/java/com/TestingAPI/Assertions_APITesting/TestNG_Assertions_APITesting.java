package com.TestingAPI.Assertions_APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_Assertions_APITesting {

    @Test
    public void test_hardAssertexample(){
        System.out.println("Start of program");
        Boolean is_male = false;
        Assert.assertTrue(is_male);
        System.out.println("End of program");
        Assert.assertEquals("priya","priya");
        Assert.assertEquals("priya","Priya");
        }

        @Test
    public void test_softAssertexample(){
            SoftAssert sa = new SoftAssert();//Create a instance of softassert
            sa.assertTrue(false);
            System.out.println("Lines are executed");
            sa.assertAll();//Will report all collected errors
        }
}
