package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends Page{

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public By seeAvailabilityBtn = By.xpath("//body/div[@id='bodyconstraint']/div[@id='bodyconstraint-inner']/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/a[1]/span[1]");

    @Step("-Click see availability button")
    public SearchResultsPage clickSeeAvailabilityBtn() {
        clickElement(seeAvailabilityBtn);
        return this;
    }
}
