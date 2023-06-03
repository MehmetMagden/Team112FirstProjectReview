package tests.Ibrahim;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DestinationsPage;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Collections;
import java.util.List;

public class US_013 extends TestBaseRapor {

    /*
    As a user, I should be able to navigate to the "Destination" page.
    I should then verify that the destinations are visible and active on the page.
     */

    BasePage homeBase = new BasePage();
    DestinationsPage destinationsPage = new DestinationsPage();
    String actualPageUrl = "";
    String expectedPageUrl = "";



    @Test()
    public void TC1301userNavigatesToDestinationPage() {
        extentTest = extentReports.createTest("TC1301", "User Navigates To Destination Page");
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        extentTest.info("User navigates to main page");
        ReusableMethods.waitForClickablility(homeBase.acceptCookiesButton,5);
        homeBase.acceptCookiesButton.click();
        actualPageUrl = Driver.getDriver().getCurrentUrl();
        expectedPageUrl = ConfigReader.getProperty("tripAndWayUrl");
        Assert.assertEquals(actualPageUrl, expectedPageUrl);
        extentTest.pass("Verify, if user can access to main page");
        Assert.assertTrue(homeBase.homePageDestinationsButton.isEnabled());
        ReusableMethods.waitForClickablility(homeBase.homePageDestinationsButton,5);
        homeBase.homePageDestinationsButton.click();
        extentTest.info("User navigates to Destination page");
        actualPageUrl = Driver.getDriver().getCurrentUrl();
        expectedPageUrl = ConfigReader.getProperty("destinationsUrl");
        Assert.assertEquals(actualPageUrl, expectedPageUrl);
        extentTest.pass("Verify, if user can access Destination page");
    }

    @Test(dependsOnMethods = {"TC1301userNavigatesToDestinationPage"})
    public void TC1302userVerifiesDestinationPageVisibleAndActive() {
        destinationsPage =new DestinationsPage();
        extentTest = extentReports.createTest("TC1302","User Verifies Destination Page Visible And Active");
        Driver.getDriver().get(ConfigReader.getProperty("destinationsUrl"));
        ReusableMethods.waitForVisibility(destinationsPage.destinationsImageWebElement,5);
        Assert.assertTrue(destinationsPage.destinationsImageWebElement.isDisplayed());
        extentTest.pass("Verify, if Destination page is visible");
        Assert.assertTrue(destinationsPage.destinationsFirstPackageWebElement.isEnabled());
        extentTest.pass("Verify, if Destination page is active");
    }
}
