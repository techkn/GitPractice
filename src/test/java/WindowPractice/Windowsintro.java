package WindowPractice;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Windowsintro {

    WebDriver driver;
        @BeforeClass
    public void setUp(){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/windows");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        @Test
    public void test1(){

            WebElement clickHereButton=driver.findElement(By.xpath("//a[.='Click Here']"));
            clickHereButton.click();
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            String parentPageId=driver.getWindowHandle();
            System.out.println(parentPageId);
            Set<String> pageIds=driver.getWindowHandles();
            for(String id: pageIds){
               if(!id.equals(parentPageId)){
                   driver.switchTo().window(id);
               }
            }
            System.out.println("After switching title: "+driver.getTitle());
            System.out.println("After switching url: "+driver.getCurrentUrl());
            driver.switchTo().window(parentPageId);
            clickHereButton.click();
        }

        @Test
    public void test2() {
            driver.get("http://www.popuptest.com/popuptest12.html");
            String currentPageId = driver.getWindowHandle();
            Set<String> ids = driver.getWindowHandles();
            System.out.println(ids);

            for (String id : ids) {
                if (!id.equals(currentPageId)) {
                    driver.switchTo().window(id);
                    driver.close();
                }
            }
            driver.switchTo().window(currentPageId);
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());

        }

        @Test
    public void test3(){
            driver.get("http://www.popuptest.com/popuptest1.html");
            String parentId=driver.getWindowHandle();
            BrowserUtils.closeWindows(driver, parentId);
    }


    }

