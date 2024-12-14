package com.TestingAPI.TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_Annotation_DependsONMethod_TestNG3 {
    @Test
    public void serverstartedOk(){
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }


    @Test(dependsOnMethods = "serverstartedOk")
    public void method1(){
        System.out.println("method1");
        Assert.assertTrue(true);
    }
    @Test(dependsOnMethods = "serverstartedOk")
    public void method2(){
        System.out.println("method2");
        Assert.assertTrue(true);
    }
}
