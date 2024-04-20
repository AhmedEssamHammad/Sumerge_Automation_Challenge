package tests;

import driver.Driver;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
public class BaseTestClass {

    public WebDriver driver;
    public SoftAssert softAssert;

    @BeforeClass()
    void beforeClass(@Optional("chrome") String browser) throws Exception {
        Driver testInit = new Driver();
        driver = testInit.SeleniumDriverSetup(browser);
    }

    @BeforeMethod(groups = {"setup"})
    void beforeMethod() {
        softAssert = new SoftAssert();
    }


    @AfterClass(groups = {"setup"})
    void afterClass() {
        driver.quit();
    }


    @Step("check that value : {0} equal to : {1} ")
    boolean doAssertEqual(Object Actual, Object Expected, String message) {
        softAssert.assertEquals(Actual, Expected, message);
        if (String.valueOf(Expected) != String.valueOf(Actual)) {
            return false;
        }

        return true;
    }
}
