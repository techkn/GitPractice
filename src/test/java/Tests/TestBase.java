package Tests;

import Utils.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class TestBase {

    public WebDriver driver;
    public SoftAssert softAssert;

    @Parameters("driverName")
    @BeforeClass(alwaysRun = true)
    public void setUp(String driverName){
        softAssert=new SoftAssert();
        driver= Driver.getDriver(driverName);
        driver.manage().window().maximize();
    }
}
