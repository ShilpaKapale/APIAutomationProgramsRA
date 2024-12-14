package com.TestingAPI.TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_Annotations_Group_TestNG2 {
    @Test(groups={"Sanity","qa"})
    public void sanityRUN(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }
    @Test(groups={"Regression"})
    public void regRUN(){
        System.out.println("Regression");

        Assert.assertTrue(true);
    }
    @Test(groups={"qa"})
    public void smokeRUN(){

        System.out.println("QA");
        Assert.assertTrue(true);
    }
}
