package TestNGPractice;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    // 1. Create @DataProvider annotation
    // 2. Create the method returns the two dimensional array of object
    @DataProvider(name = "fullnametest")
    public Object[][] getData(){

        return new Object[][]{
                {"Techtorial"," Academy","Techtorial Academy"},
                {"Shawn"," Achor","Shawn Achor"},
                {"Grand"," Cardone","Grand Cardone"},
                {"Gayle"," Mcdowell","Gayle Mcdowell"}
        };
    }


 //   @Test
  //  public void test1(){
  //      int a=5;
  //      int b=6;
   //     Assert.assertEquals(a+b, 11);
  //  }

    @Test(dataProvider = "fullnametest")
    public void test(String firstName, String lastName, String fullName){
        String fname=firstName;
        String lname=lastName;
        String result=fname+lname;
        Assert.assertTrue(result.equals(fullName));

    }


}
