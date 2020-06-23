package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropPractice {

    @Test
    public void test1(){
        // 1. user webdriver manager
        WebDriverManager.chromedriver().setup();
        // Instantiate the object
        WebDriver driver=new ChromeDriver();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        // Instantiate the Actions object
        Actions actions=new Actions(driver);

        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));
        String expectedText="Drag the small circle here.";
        String actualText=target.getText();
        // Message will display When the assertion failed
        Assert.assertEquals(actualText,expectedText,"Expected and actual is not matching");
        // 8 locator --> name, id, xpath, css selector, ClassName, TagName, linkText, PartialLinktext
        // Use dragAndDrop method
        actions.dragAndDrop(source,target).perform();
        // Assertion After Drag and Drop
        String expectedDropText="You did great!";
        String actualDropText=target.getText();
        Assert.assertTrue(expectedDropText.equals(actualDropText),"after drop text is not matching");

    }

    @Test
    public void test2(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        // fullscreen for mac
        // maximize for windows
        driver.manage().window().maximize();

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions actions=new Actions(driver);
        // clickAndHold -- moveToElement  --- release  --> perform()
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));

        actions.clickAndHold(source).moveToElement(target).perform();
        actions.release(target).perform();
        // release() ---> will release the mouse in current location of mouse
        // release(target) --> will release the  mouse in target location
    }
}
