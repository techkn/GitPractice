package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class ActionIntro {

    @Test
    public void rightClick() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement hotSpot=driver.findElement(By.id("hot-spot"));
        // inside this Actions constructor we need provide the driver
        Actions actions=new Actions(driver);
        // ContextClick will perform right click action in mouse
        Thread.sleep(2000);
        // In actions class we need to use the perform() method to see the mouse action.
        actions.contextClick(hotSpot).perform();
    }

    @Test
    public void rightClick1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement hotSpot=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        // Using Action interface
        Action action=actions.contextClick(hotSpot).build();
        action.perform();

    }


    @Test
    public void hoverOver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        List<WebElement> avatarText=driver.findElements(By.xpath("//h5"));
        for (WebElement a :avatarText){
            System.out.println(a.getText());
        }

        List<WebElement> avatars=driver.findElements(By.xpath("//img[@alt='User Avatar']"));

        Actions actions=new Actions(driver);
        int count=0;
        for(WebElement avatar : avatars){
            actions.moveToElement(avatar).perform();
            System.out.println(avatarText.get(count++).getText());
            Thread.sleep(1000);
        }

    }

}
