package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends Page{

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private By hotelName = By.xpath("//h1[contains(text(),'Tolip Hotel Alexandria')]");

    @Step("Check hotel name is displayed")
    public boolean isHotelNameDisplayed() {
        return checkElementIsDisplayed(hotelName);
    }
}
