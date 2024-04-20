package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingHomePage extends Page{

    public BookingHomePage(WebDriver driver) {
        super(driver);
    }

    private By searchInput = By.xpath("//input[@id=':re:']");
    private By chooseDateBtn = By.xpath("//span[contains(text(),'Check-out Date')]");
    private By searchBtn = By.xpath("//span[contains(text(),'Search')]");

    @Step("-Open Home page")
    public BookingHomePage openHomePage() {
        openURL("https://www.booking.com/");
        return this;
    }

    @Step("-Send text to search input")
    public BookingHomePage sendTextToSearchInput(String searchTxt) {
        sendText(searchInput, searchTxt);
        return this;
    }

    @Step("-Click choose date button")
    public BookingHomePage clickChooseDateBtn() {
        clickElement(chooseDateBtn);
        return this;
    }

    @Step("-Click search button")
    public BookingHomePage clickSearchBtn() {
        clickElement(searchBtn);
        return this;
    }

    @Step
    public BookingHomePage clickElementByDate(String date) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@data-date='"+date+"']")))).click();
        return this;
    }
}
