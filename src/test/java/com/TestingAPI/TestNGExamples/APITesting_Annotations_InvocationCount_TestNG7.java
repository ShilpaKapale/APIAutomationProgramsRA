package com.TestingAPI.TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_Annotations_InvocationCount_TestNG7 {

    @Test(invocationCount = 5)
    public void test01(){

        Assert.assertTrue(true);
    }
}
