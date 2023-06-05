package tests.Ibrahim;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DestinationsPage;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_013 extends TestBaseRapor {

    /*
    As a user, I should be able to navigate to the "Destination" page.
    I should then verify that the destinations are visible and active on the page.
     */

    BasePage basePage = new BasePage();
    DestinationsPage destinationsPage = new DestinationsPage();
    String actualPageUrl = "";
    String expectedPageUrl = "";


    @Test()
    public void TC1301userNavigatesToDestinationPage() {
        extentTest = extentReports.createTest("TC1301", "User Navigates To Destination Page");
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        extentTest.info("User navigates to main page");
        ReusableMethods.waitForClickablility(basePage.acceptCookiesButton,5);
        basePage.acceptCookiesButton.click();
        actualPageUrl = Driver.getDriver().getCurrentUrl();
        expectedPageUrl = ConfigReader.getProperty("tripAndWayUrl");
        Assert.assertEquals(actualPageUrl, expectedPageUrl);
        extentTest.pass("Verify, if user can access to main page");
        Assert.assertTrue(basePage.homePageDestinationsButton.isEnabled());
        ReusableMethods.waitForClickablility(basePage.homePageDestinationsButton,5);
        basePage.homePageDestinationsButton.click();
        extentTest.info("User navigates to Destination page");
        actualPageUrl = Driver.getDriver().getCurrentUrl();
        expectedPageUrl = ConfigReader.getProperty("destinationsUrl");
        Assert.assertEquals(actualPageUrl, expectedPageUrl);
        extentTest.pass("Verify, if user can access to Destination page");
    }

    @Test()
    public void TC1302userVerifiesDestinationPageVisibleAndActive() {
        basePage = new BasePage();
        destinationsPage =new DestinationsPage();
        extentTest = extentReports.createTest("TC1302","User Verifies Destination Page Visible And Active");
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        extentTest.info("User navigates to main page");
        ReusableMethods.waitForClickablility(basePage.acceptCookiesButton,10);
        basePage.acceptCookiesButton.click();
        ReusableMethods.waitFor(2);
        basePage.homePageDestinationsButton.click();
        extentTest.info("User navigates to Destination page");
        ReusableMethods.waitForVisibility(destinationsPage.destinationsImageWebElement,5);
        Assert.assertTrue(destinationsPage.destinationsImageWebElement.isDisplayed());
        extentTest.pass("Verify, if Destination page is visible");
        Assert.assertTrue(destinationsPage.destinationsFirstPackageWebElement.isEnabled());
        extentTest.pass("Verify, if Destination page is active");
    }
}
