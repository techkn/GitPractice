package Tests.com.Sentrifugo;

import Pages.LoginPage;
import Pages.MaritalStatusPage;
import Tests.TestBase;
import Tests.com.Sentrifugo.TestData.MaritalStatusData;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MaritalStatusTest extends TestBase {

    MaritalStatusPage page;
    LoginPage loginPage;
    @BeforeClass
    public void setUpPage(){
        page=new MaritalStatusPage(driver);
        loginPage=new LoginPage(driver);
    }




    @Parameters({"username","password"})
    @Test(priority = 1)
    public void validationErrorMessage(String user, String pass){
        driver.get("http://demo.sentrifugo.com/index.php/");
        // this will login the page
        loginPage.login(user,pass);
        page.genderButton.click();
        page.maritalStatusButton.click();
        page.addButton.click();
        page.saveButton.click();
        String actualCodeError=page.errorMaritalCode.getText();
        String expectedCodeError="Please enter marital code.";
        String actualStatusError=page.errorMaritalStatusName.getText();
        String expectedStatusError="Please enter marital status.";
// Soft Assert
        softAssert.assertEquals(actualCodeError,expectedCodeError);
        softAssert.assertEquals(actualStatusError,expectedStatusError);
        // assertAll should be at the end of your annotation
        softAssert.assertAll();
        Assert.assertEquals(actualCodeError, expectedCodeError);
        Assert.assertEquals(actualStatusError, expectedStatusError);
    }

    @Test(priority = 2,dataProvider = "maritalTest", dataProviderClass = MaritalStatusData.class)
    public void validationMaritalStatusCreation(String code, String status, String description) throws InterruptedException {

        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        page.maritalCode.sendKeys(code);
        page.maritalStatus.sendKeys(status);
        page.description.sendKeys(description);
        page.saveButton.click();
        Thread.sleep(400);
        // Even though my assertion is failing i want to click the addButton
        // Instead of
        softAssert.assertTrue(page.successMessage.isDisplayed());
        page.addButton.click();
        page.addButton.click();

        softAssert.assertAll();

    }
}
