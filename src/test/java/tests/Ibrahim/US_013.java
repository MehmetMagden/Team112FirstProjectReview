package tests.Ibrahim;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DestinationsPage;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_013 extends TestBaseRapor {

    BasePage homeBase = new BasePage();
    DestinationsPage destinationsPage = new DestinationsPage();

    @Test
    public void TC_13_01() {

        //1) User opens browser
        //2) User navigates the main page
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));

        //3) User clicks the accept cookies button
        homeBase.acceptCookiesButton.click();

        //4) Url Should be same with the test data
        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = ConfigReader.getProperty("tripAndWayUrl");
        Assert.assertEquals(actualUrl, expectedUrl);

        //5)User should see "Destination" button in the header section
        Assert.assertTrue(homeBase.homePageDestinationsButton.isEnabled());

        //6)User clicks the "Destination" button
        homeBase.homePageDestinationsButton.click();

        //7) User should see "Destinations" page
        actualUrl = Driver.getDriver().getCurrentUrl();
        expectedUrl = ConfigReader.getProperty("destinationsUrl");

        //8) Url Should be same with the test data
        Assert.assertEquals(actualUrl, expectedUrl);

        //9) User should see "Destinations" header
        Assert.assertTrue(destinationsPage.destinationsImageWebElement.isDisplayed());

        //10) User closes the browser
    }
}
