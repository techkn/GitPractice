package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DragAndDropPr {

    WebDriver driver;

    // It will run after everything in this class
    @AfterClass
    public void tearDown(){
        System.out.println("This is after Class annotation");
       // driver.quit();

    }

    @Test
    public void test1(){
        System.out.println("Test 1 is running");
        WebElement circle=driver.findElement(By.id("draggable"));
        WebElement blueBox=driver.findElement(By.className("test1"));
        WebElement orangeBox=driver.findElement(By.className("test2"));

        // drag and drop only with Actions class
        String expected="Drag the small circle here ...";
        String actual=blueBox.getText();
        Assert.assertEquals(actual,expected,"Default text for blue box is failed");
        String expectedOrangeText="... Or here."; // expected is coming from busines Req.
        String actualOrangeText=orangeBox.getText();
        Assert.assertEquals(actualOrangeText,expectedOrangeText,"Default text for orange box is failed");

    }

    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Test 2 is running");
        WebElement circle=driver.findElement(By.id("draggable"));
        WebElement blueBox=driver.findElement(By.className("test1"));
        WebElement orangeBox;

        Actions actions=new Actions(driver);
        actions.dragAndDrop(circle,blueBox).perform();

        String expectedBlueBoxText="You did great!";
        blueBox=driver.findElement(By.className("test1"));
        String actualBlueBoxText=blueBox.getText();
        Assert.assertEquals(actualBlueBoxText,expectedBlueBoxText,"After dropping blue box message is failed");

        String expectedOrangeBoxText="(Drop here)";
        orangeBox=driver.findElement(By.className("test2"));
        String actualOrangeBoxText=orangeBox.getText();
        Assert.assertEquals(actualOrangeBoxText,expectedOrangeBoxText,"After dropping blue box, Orange box message is failed");

    }

    @Test
    public void test3() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Test 3 is running");
        WebElement circle=driver.findElement(By.id("draggable"));
        WebElement blueBox=driver.findElement(By.className("test1"));
        WebElement orangeBox=driver.findElement(By.className("test2"));
        Actions actions=new Actions(driver);

        // this process for moving circle inside the orange box
        actions.clickAndHold(circle).moveToElement(orangeBox).release().perform();
        String expectedOrangeBox="You did great!";
        orangeBox=driver.findElement(By.className("test2"));
        String actualOrangeBox=orangeBox.getText();
        // StaleElementException--> if the element is not available in your DOM, selenium will throw StaleElementException
        Assert.assertEquals(actualOrangeBox,expectedOrangeBox);
        String expectedBlueBox="(Drop here)";
        blueBox=driver.findElement(By.className("test1"));
        String actualBlueBox=blueBox.getText();
        Assert.assertEquals(actualBlueBox,expectedBlueBox);

    }


     // it will run before everything in this class
    // location is not important
    @BeforeClass
    public void setUp(){
        System.out.println("This is before class annotation");
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/dragdrop/area");
        // How we can use implicitly wait. It takes two parameter (int Value, TimeUnits)
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        // It will wait 5 sec until the elements are loaded in the page.
        // If you are not able to find the element after 5 sec. Selenium will throw NoSuchElementException.
        driver.findElement(By.xpath("//button[.='Accept Cookies']")).click();
    }
}
