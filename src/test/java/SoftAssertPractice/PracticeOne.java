package SoftAssertPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeOne {

    //If hard assert fails it will not go and execute th next line in test annotation
    // but it will continue to execute the another test

    @Test
    public void test2(){
        Assert.assertEquals(3,4,"The integer number verification");
        Assert.assertTrue("Techtorial".startsWith("Tech"),"Boolean condition verified");
        Assert.assertEquals("Tech","Tec","String values are verified");
    }

    @Test
    public void test3(){
        Assert.assertEquals(4,4,"The integer number verification");
    }
    @Test
    public void test1(){


        SoftAssert softAssort=new SoftAssert();
        softAssort.assertEquals(3,4,"The integer number verification");
        softAssort.assertTrue("Techtorial".startsWith("Tech"),"Boolean condition verified");
        softAssort.assertEquals("Tech","Tech","String values are verified");
        // assertAll should be at the end of your test
        // Assert All will assert previous all verifications.

        softAssort.assertAll(); // this line show the assertion error since line 28 verification is not passed
        System.out.println("Hello world!");// this line 33 will not be executed
    }
}
