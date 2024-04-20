package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BookingHomePage;
import pages.ConfirmationPage;
import pages.DetailsPage;
import pages.SearchResultsPage;
import util.ReadExcelDate;

public class HotelReservationTest extends BaseTestClass {
    private BookingHomePage bookingHome;
    private SearchResultsPage searchResults;
    private DetailsPage details;
    private ConfirmationPage confirmation;

    @BeforeMethod()
    public void setup() {
        bookingHome = new BookingHomePage(driver);
        searchResults = new SearchResultsPage(driver);
        details = new DetailsPage(driver);
        confirmation = new ConfirmationPage(driver);
    }

    @Test(priority = 1, description = "check that chosen dates are displayed correctly", dataProviderClass = ReadExcelDate.class, dataProvider = "testData")
    public void checkThatChosenDatesAreDisplayedCorrectly(String hotelName, String checkInDate, String checkOutDate, String checkInDateChoice, String checkOutDateChoice) {

        bookingHome.openHomePage()
                .sendTextToSearchInput(hotelName)
                .scrollDownByPixel(1);
        bookingHome.clickChooseDateBtn()
                .clickElementByDate(checkInDateChoice)
                .clickElementByDate(checkOutDateChoice)
                .clickSearchBtn();
        searchResults.clickSeeAvailabilityBtn();
        driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
        details.scrollDownByPixel(2);
        doAssertEqual(details.getCheckInDate(), checkInDate, "Check in date is not displayed correctly");
        doAssertEqual(details.getCheckOutDate(), checkOutDate, "check out date is not displayed correctly");
        softAssert.assertAll();

    }

    @Test(priority = 2, description = "check that hotel name is shown in the box")
    public void checkThatHotelNameIsShownInTheBox() {

        details.scrollDownByPixel(2);
        details.clickBedsRadioBtn()
                .clickAmountMenu()
                .clickAmountMenuChoice()
                .scrollDownByPixel(1);
        details.clickReserveBtn();
        doAssertEqual(confirmation.isHotelNameDisplayed(), true, "Hotel name is not displayed correctly");
        softAssert.assertAll();

    }
}
