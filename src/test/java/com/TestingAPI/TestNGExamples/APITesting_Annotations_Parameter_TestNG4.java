package com.TestingAPI.TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting_Annotations_Parameter_TestNG4 {

    @Parameters("browser")
    @Test
    public void demo1(String value){
        System.out.println("Browser is: " +value);

        if(value.equalsIgnoreCase("chrome"))
        {
            System.out.println("Chrome");
        }
        if(value.equalsIgnoreCase("firefox"))
        {
            System.out.println("Firefox");
        }

    }
}
