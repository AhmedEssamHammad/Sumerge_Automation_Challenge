package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DetailsPage extends Page{

    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    private By checkInDate = By.xpath("//button [@data-testid='date-display-field-start' and @class='ebbedaf8ac ab26a5d2bd e33c97ff6b']");
    private By checkOutDate = By.xpath("//button [@data-testid='date-display-field-end' and @class='ebbedaf8ac ab26a5d2bd e33c97ff6b']");
    private By bedsRadioBtn = By.xpath("//div[@class='rt-bed-type-select']//input[@value='2']");
    private By amountMenu = By.xpath("//select[@id='hprt_nos_select_78883120_91939502_0_33_0_131741']");
    private By amountMenuChoice = By.xpath("//select[@id='hprt_nos_select_78883120_91939502_0_33_0_131741']//option[@value='2']");
    private By reserveBtn = By.xpath("//button[@id='b_tt_holder_1']");

    @Step("Get check in date")
    public String getCheckInDate() {
        return getElementText(checkInDate);
    }

    @Step("Get check out date")
    public String getCheckOutDate() {
        return getElementText(checkOutDate);
    }

    @Step("-Click beds radio button")
    public DetailsPage clickBedsRadioBtn() {
        clickElement(bedsRadioBtn);
        return this;
    }

    @Step("-Click amount menu")
    public DetailsPage clickAmountMenu() {
        clickElement(amountMenu);
        return this;
    }

    @Step("-Click amount menu choice")
    public DetailsPage clickAmountMenuChoice() {
        clickElement(amountMenuChoice);
        return this;
    }

    @Step("-Click reserve button")
    public DetailsPage clickReserveBtn() {
        clickElement(reserveBtn);
        return this;
    }

}
