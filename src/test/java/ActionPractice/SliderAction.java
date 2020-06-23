package ActionPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SliderAction {

    @Test
    public void test1(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        // moveByOffset()--> it will move the mouse from current location to provided location
        WebElement slider=driver.findElement(By.xpath("//input[@type='range']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(slider)
                .moveByOffset(-55,0)
                .release()
                .perform();

        // TASK --> keep moving to the slider with 0.5 if the value is not equals to 5

    }


    @Test
    public void test2(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider=driver.findElement(By.xpath("//input[@type='range']"));
        WebElement number=driver.findElement(By.id("range"));

        Actions actions=new Actions(driver);
        int xOffset=-55;
        // - ----------- - =5
        // -55 ...........55
        // TASK --> keep moving to the slider with 0.5 if the value is not equals to 5
        while(!number.getText().equals("5")){
            actions.clickAndHold(slider)
                    .moveByOffset(xOffset,0)
                    .release()
                    .perform();

            xOffset+=10; // compound assignment in Java
        }
    }

    // how can I slide the slider left to right without using moveByOffset

    @Test
    public void test3() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        WebElement slider=driver.findElement(By.xpath("//input[@type='range']"));
        WebElement number=driver.findElement(By.id("range"));

        Actions actions=new Actions(driver);
        actions.clickAndHold(slider).perform();
        while(!number.getText().equals("1")){
            actions.sendKeys(Keys.ARROW_LEFT).perform();
            Thread.sleep(1000);
        }
    }


    @Test
    public void test4(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/slider/keyboard-navigation");
        WebElement first=driver.findElement(By.xpath("//a[contains(@style,'left: -8px')]"));
        WebElement second=driver.findElement(By.xpath("//a[contains(@style,'left: 190px')]"));
        Point point = first.getLocation();
        int xcord = point.getX();
        int ycord = point.getY();
        System.out.println(xcord);
        System.out.println(ycord);
        Point point2 = second.getLocation();
        System.out.println(point2.getX());
        System.out.println(point2.getY());
        // 740-542== 198
        Actions actions=new Actions(driver);
        // first element left to right
        actions.clickAndHold(first).moveByOffset(200,0).release().perform();
        // second element right to left
        actions.clickAndHold(second).moveByOffset(-200,0).release().perform();
    }

    @Test
    public void test5(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://demos.telerik.com/kendo-ui/slider/angular");
        WebElement vertical=driver.findElement(By.xpath("//a[@style='bottom: -8px;']"));

        WebElement ten=driver.findElement(By.xpath("//div[contains(@class,'k-slider-vertical')]//li[@title='10']"));
        WebElement zero=driver.findElement(By.xpath("//div[contains(@class,'k-slider-vertical')]//li[@title='0']"));
        
        Point tenY=ten.getLocation();
        System.out.println(tenY.getY());
        Point zeroY=zero.getLocation();
        System.out.println(zeroY.getY());
        System.out.println(tenY.getY()-zeroY.getY());
        // 454-542=-88

        Actions actions=new Actions(driver);
        actions.clickAndHold(vertical).moveByOffset(0,-95).release().perform();

        actions.clickAndHold(vertical).moveByOffset(0,44).release().perform();
    }

}
