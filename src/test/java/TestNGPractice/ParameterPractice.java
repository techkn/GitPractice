package TestNGPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterPractice {

    //we need to give the value to our parameter annotation from xml runner class.
    // If yoy use the Parameter annotation, you should provide the value inside your runner classes.
    // @Parameter("fname") -->
    @Parameters({"fname","lastName"})
    @Test
    public void test1(String name, String lname){
        System.out.println("Name is: "+name);
        System.out.println("Last name is: "+lname);
    }
}
