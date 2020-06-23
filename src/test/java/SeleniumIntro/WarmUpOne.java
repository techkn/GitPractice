package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WarmUpOne {
    //    TASK:
//    Go to google and search the selenium keyword
//    Validate all the results related with Selenium.
//    Find the titles and validate titles has Selenium keyword
    // To adjust the structure of your code you can use option+command+L
    public static void main(String[] args) {

        // WebdriverManager to get the chromedriver
      //  System.setProperty("webdriver.chrome.driver","pathOfChromeDriver"); NO NEED ANYMORE
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com/");

        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");


        WebElement googleSearch=driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@class='gNO89b']"));
        googleSearch.click();

        // if you have more than one matching webelement, use findElements method and store as List<WebElement>.
        List<WebElement> headers=driver.findElements(By.xpath("//h3[@class='LC20lb DKV0Md']"));

        for(WebElement head: headers){
            String hd=head.getText();
            if(!hd.equals("")){
                if(hd.contains("Selenium") || hd.contains("selenium")){
                    System.out.println("Include Selenium");
                }else{
                    System.out.println("Does't include Selenium");
                }
            }
        }

    }

}
