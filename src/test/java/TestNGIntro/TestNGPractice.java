package TestNGIntro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {

    @Test
    public void test1(){
        System.out.println("First Test");
        // Assert equals method take two parameter, if these two parameters are equals to each other
        // your test will pass
        Assert.assertEquals("Mothers Day","Mothers Day");
        // In hard assertion, once assert failed next line will not be executed.
        // it will throw the exception right away
        System.out.println("After assertion");
    }

    @Test
    public void test2(){
        System.out.println("Second Test");
        // it will take boolean condition. If boolean condition is true test will pass
        // otherwise test will fail.
        Assert.assertTrue("Mother Day".startsWith("Mother"));
        // since it is returning true, I will be able to see the sout output
        System.out.println("After second assertion");
    }


}
