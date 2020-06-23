package SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitePractice {

    WebDriver driver;

    @Test
    public void test1() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // pageLoadTimeout method will take 2 param.
        // one is time as long num,second param is for timeUnit
        // it will wait page until it is loaded for 10 sec
        // pageLoadTimeout is dynamic wait, if the PAGE loaded in 3 sec
        // rest of the 7sec will be ignored
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        // implicitlyWait will wait all your WebElement which your driver is pointing
        // implicitly wait throws NoSuchElementException if the element is not available
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // It will wait for an asynchronous script in your page
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com/");
    }

    @Test
    public void test2() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // every 250 milsec it will try to find your element until 10sec
        // implicitly wait will wait all the webelements which my driver is pointing.
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();
        WebElement message=driver.findElement(By.id("message"));
        String  actualText=message.getText();
        String expectedText="It's gone!";

        Assert.assertTrue(message.isDisplayed());
        Assert.assertEquals(actualText,expectedText);

    }
}