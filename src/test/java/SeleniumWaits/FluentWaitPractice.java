package SeleniumWaits;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitPractice {

    WebDriver driver;

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();
   // withTimeout(Duration.ofSeconds(20)); --> total number of sec which we are going to wait
   // pollingEvery(Duration.ofSeconds(2)) --> it will try to interact with Webelement every 2 sec.

        Wait<WebDriver> wait=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(RuntimeException.class);

        WebElement message=wait.until(
                driver -> driver.findElement(By.id("message"))
              //  new Function<WebDriver, WebElement>() {
                //    @Override
                  //  public WebElement apply(WebDriver driver) {
                    //    return driver.findElement(By.id("message"));
                 //   }
            //    }
        );

        String  actualMessage=message.getText();
        String expectedMessage="It's gone!";
        Assert.assertEquals(actualMessage,expectedMessage);

        WebElement addButton=driver.findElement(By.xpath("//button[.='Add']"));
        addButton.click();

        message=wait.until(
                driver ->driver.findElement(By.id("message"))
        );
        String  actualBackMessage=message.getText();
        String expectedBackMessage="It's back!";
        Assert.assertEquals(actualBackMessage,expectedBackMessage);
    }
    @Test
    public void test2(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton=driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();


        // if there is a frequency the webelement on the page,
        // it will be better to use the fluentwait and try to interact with webelement in specified time period
        // By mess=By.id("message");                                                 mess
        WebElement message= BrowserUtils.fluentWait(driver,20,2,By.id("message"));

        System.out.println(message.getText());
    }
}
