package IframePractice;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class IframeIntro {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    @Test
    public void test(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        //this line switches the frame to first frame in the DOM
        driver.switchTo().frame(0);

       // it will switch the driver from iframe to default html

        WebElement textBox=driver.findElement(By.id("tinymce"));
        System.out.println(textBox.getText());

        driver.switchTo().defaultContent();
        WebElement header=driver.findElement(By.xpath("//h3"));
        System.out.println(header.getText());
    }
    @Test
    public void test2(){
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        //want to switch my frame with the frame name
        //Nested frame: first we switch to parent frame
        driver.switchTo().frame("frame-top");
        // after parent frame
        driver.switchTo().frame("frame-middle");
        WebElement middle=driver.findElement(By.id("content"));
        System.out.println(middle.getText());

        // parentFrame switch to parent frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement right=driver.findElement(By.xpath("//body[contains(.,'RIGHT')]"));
        System.out.println(right.getText());
    }
    @Test
    public void test3(){
        driver.get("https://skpatro.github.io/demo/iframes/");
        driver.switchTo().frame("Frame1");
        WebElement category2=driver.findElement(By.xpath("//a[.='Category2']"));
        category2.click();
        BrowserUtils.switchWindowByUrl(driver, "basicjava");
        System.out.println(driver.getTitle());

        BrowserUtils.switchByTitle(driver, "iframes");
        driver.switchTo().frame(1);
        WebElement category3=driver.findElement(By.xpath("//a[.='Category3']"));
        category3.click();
    }

    @Test

    public void test4(){
        driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/");
        WebElement frameElement=driver.findElement(By.xpath("//frame[@name='packageListFrame']"));
        driver.switchTo().frame(frameElement);
        List<WebElement> packageNames=driver.findElements(By.xpath("//a[@target='packageFrame']"));
        for(WebElement packageName : packageNames){
            System.out.println(packageName.getText());
        }
    }
}
