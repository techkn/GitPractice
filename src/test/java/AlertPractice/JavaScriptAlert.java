package AlertPractice;

import Utils.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavaScriptAlert {

    WebDriver driver;

    @BeforeClass
    public void setDriver(){
        // getDriver method returns WebDriver
        driver= Driver.getDriver("chrome");
    }
    @Test
    public void sweetAlertTest() throws InterruptedException {

        driver.navigate().to("https://sweetalert.js.org/");
        driver.findElement(By.xpath("//button[contains(@onclick,'swal')]")).click();
        Thread.sleep(1000);
        String actualMessage=driver.findElement(By.xpath("//div[@class='swal-text']")).getText();
        String expectedMessage="Something went wrong!";
        Assert.assertEquals(actualMessage,expectedMessage,"Message is validated");
        driver.findElement(By.xpath("//button[.='OK']")).click();
    }

    @Test
    public void javascriptAlertTest1() throws InterruptedException {
        driver.navigate().to("https://sweetalert.js.org/");
        driver.findElement(By.xpath("//button[contains(@onclick,'alert')]")).click();
        Thread.sleep(3000);
        // since for javascript alert we do not have the webelement, we need to switch the driver to the alert class
        Alert alert=driver.switchTo().alert();
        // We have 4 method in alert class to handle the js alerts
        //1- accept 2- dismiss-Cancel 3- sendKey 4- getText

        String actualJSMessage=alert.getText();// will return text of alert
        String expectedMessage="Oops, something went wrong!";
        Assert.assertEquals(actualJSMessage,expectedMessage);

        alert.accept();// it will click OK button in JS alert

    }

    @Test
    public void jsSendKeyTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsButton.click();

        SoftAssert softAssert = new SoftAssert();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        String actualResult = driver.findElement(By.id("result")).getText();
        String expectedResult = "You clicked: Cancel";
        softAssert.assertEquals(actualResult, expectedResult, "Cancel button is validated");

        jsButton.click();
        alert.accept(); // clicked the OK button
        String actualResult1 = driver.findElement(By.id("result")).getText();
        String expectedResult1 = "You clicked: Ok";
        softAssert.assertEquals(actualResult1, expectedResult1);

        softAssert.assertAll();
    }
    @Test
    public void test4(){
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPrompt=driver.findElement(By.xpath("//button[contains(text(),'Prompt')]"));
        jsPrompt.click();

        Alert alert=driver.switchTo().alert();
        SoftAssert softAssert=new SoftAssert();
        String actualText=alert.getText();
        String  expected="I am a JS prompt";
        softAssert.assertEquals(actualText,expected);

        String alertMessage="Techtorial Academy";
        alert.sendKeys(alertMessage); // it sent the key for alert message
        alert.accept();// OK button in alert

        String  actualMessage=driver.findElement(By.id("result")).getText();

        softAssert.assertTrue(actualMessage.endsWith(alertMessage),"Result of alert is verified");

        softAssert.assertAll();
    }
}
