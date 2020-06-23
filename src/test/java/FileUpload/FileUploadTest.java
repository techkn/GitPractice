package FileUpload;

import Tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {

    // when extend this class with TestBase, i need to provide the parameter
    //if i need to provide the parameter, i should use the xml file to run my class
    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/upload");
        // for file upload in Selenium, we need to send key as a path of the file
        //Which

        WebElement chooseFile=driver.findElement(By.id("file-upload"));
        chooseFile.sendKeys("C:\\Users\\aizhi\\Desktop\\FileUploadTest.png");
        WebElement uploadButton=driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement textMessage=driver.findElement(By.id("uploaded-files"));
        String actualText=textMessage.getText();
        String expectedText="FileUploadTest.png";

        softAssert.assertEquals(actualText,expectedText);
        softAssert.assertAll();
    }

    @Test
    public void test2() throws InterruptedException {
        driver.navigate().to("http://demo.guru99.com/test/upload/");
        WebElement chooseFile=driver.findElement(By.id("uploadfile_0"));
        chooseFile.sendKeys("C:\\Users\\aizhi\\Desktop\\TechtorialAcademy.png");
        WebElement sumbitButton=driver.findElement(By.id("submitbutton"));
        sumbitButton.click();

        String expectedText="1 file\n"+
                "has been successfully uploaded.";
        Thread.sleep(2000);
        String actualMessage=driver.findElement(By.id("res")).getText();

        softAssert.assertEquals(actualMessage,expectedText);
        softAssert.assertAll();
    }
}
