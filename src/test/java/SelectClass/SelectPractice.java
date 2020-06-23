package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectPractice {

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("file:///Users/techotrialadmin/Desktop/Techtorial%20(2).html?submitbutton=SUBMIT");
        // Select the Mexico
        // After finding the element of Select, then you can sendKey to select Mexico
        WebElement dropDown=driver.findElement(By.name("country"));
        dropDown.sendKeys("MEXICO");
    }

    @Test
    public void test2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("file:///Users/techotrialadmin/Desktop/Techtorial%20(2).html?submitbutton=SUBMIT");
        WebElement dropDown=driver.findElement(By.name("country"));// select element
        // Select constructor requires one parameter as webelement of Select tag
        Select select=new Select(dropDown);
        // selectByIndex will select the option matching with index number
        // index number starts from 0 in dropdown.
        select.selectByIndex(2);
        // selectByVisibleText --> it will take one parameter as
        // String which is value of country, it will select giving parameter
        Thread.sleep(2000);
        select.selectByVisibleText("BOLIVIA ");
        // selectByValue --> it will select the option according their values.
        // * Selecting with value only possible, if Option has value attribute
        Thread.sleep(2000);
        select.selectByValue("239");// --> value of option

    }


    @Test
    public void test3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("file:///Users/techotrialadmin/Desktop/Techtorial%20(2).html?submitbutton=SUBMIT");
        WebElement dropDown=driver.findElement(By.name("country"));// select element
        Select select=new Select(dropDown);

        // getFirstSelectedOption() method will return webElement of default selected option from dropdown
       WebElement defaultOption=select.getFirstSelectedOption();
        String actualResult=defaultOption.getText().trim();
        String expectedResult="UNITED STATES";
        // assertEquals will compare two parameter
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void test4(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("file:///Users/techotrialadmin/Desktop/Techtorial%20(2).html?submitbutton=SUBMIT");
        WebElement dropDown=driver.findElement(By.name("country"));// select element
        Select select=new Select(dropDown);

        // getOptions() method will return list of webelement for all option under the select tag
        List<WebElement> options=select.getOptions();
        for(WebElement option:options){
            System.out.println(option.getText());
        }

        int countryNumber=options.size();
        int expectedCountryNum=264; // business

        Assert.assertTrue(countryNumber==expectedCountryNum);

    }





}
