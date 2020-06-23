package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxPractice {

    @Test
    public void test1() throws InterruptedException {
        //
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        // navigate to the Amazon.com
        driver.get("https://www.amazon.com/");
        // send the key for search box
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");

        WebElement searchButton=driver.findElement(By.xpath("//div/input[@type='submit']"));
        searchButton.submit();
        Thread.sleep(2000);
        WebElement apple=driver.findElement(By.xpath("//li[@id='p_89/Apple']//i"));
        apple.click();
        Thread.sleep(2000);
        apple=driver.findElement(By.xpath("//li[@id='p_89/Apple']//input"));
        // we can use isSelected() method for only checkbox and radiobutton
        Assert.assertTrue(apple.isSelected());

    }
}
