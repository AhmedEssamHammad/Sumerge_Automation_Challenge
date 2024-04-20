package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected void openURL(String url) {
        driver.navigate().to(url);
        System.out.println("Navigating to " + url);
    }

    public void visibilityWait(By element) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void clickElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }


    @Step("-Scroll down")
    public void scrollDownByPixel(int count) {
        for (int x = 0; x < count; x++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,450)", "");
        }

    }


    @Step("-Find Element")
    public WebElement findElement(By element) {
        return driver.findElement(element);
    }

    @Step("-Send Text")
    protected void sendText(By element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
        findElement(element).sendKeys(text);
    }


    @Step("-get Element Text")
    public String getElementText(By element) {
        return driver.findElement(element).getText();
    }


    @Step("-check Element is displayed")
    public boolean checkElementIsDisplayed(By element) {
        try {
            visibilityWait(element);
            driver.findElement(element).isDisplayed();
        } catch (Exception e) {
            System.out.println("Couldn't find element" + element);
            return false;
        }
        return true;
    }


}
