package TestNGPractice;

import org.testng.annotations.*;

public class PracticeTestNG {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite Annotation");
    }
// If you have more than one same annotation, they will run according their name with ascending order.
    @BeforeSuite
    public void beforeSuite1() {
        System.out.println("Before Suite Annotation-1");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test Annotation");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class Annotation");
    }

    @BeforeMethod
    public void beforeMethod() {
        //it will run before every test annotation
        System.out.println("Before Method Annotation");
    }

    @Test(priority = 2)
    public void test1() {
        System.out.println("Test - 1");
    }

    @Test(priority = 1, enabled = false)
    public void test2() {
        System.out.println("Test - 2");
    }
//since there is no priority for test3, it will run first
    @Test(alwaysRun = true)
    public void test3() {
        System.out.println("Test - 3");
    }

    @AfterMethod
    public void afterMethod() {
        //it will run after every test annotation
        System.out.println("After Method Annotation");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class Annotation");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test Annotation");

    }

    @AfterSuite
    public void AfterSuite() {
        System.out.println("After Suite Annotation");
    }


}