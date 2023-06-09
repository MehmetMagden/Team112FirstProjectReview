package tests.Seda;

import com.aventstack.extentreports.ExtentReports;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.PackagesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_14 extends MethodBase {
    /*
    As a user, I should be able to navigate to the "Featured Packages" page.
    I should then verify that the packages are visible and active on the page.
    */

    PackagesPage packagesPage = new PackagesPage();
    BasePage basePage = new BasePage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC14_01_packagesPageIsActiveVisible () {

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookies();

        packagesPage.packagesHeaderLink.click();

        ReusableMethods.waitFor(2);

        extentTest = extentReports.createTest("TC14", "User Navigates To Packages Page");
        String expectedBanner = "PACKAGES";
        String actualBanner = packagesPage.packagesBannerText.getText();
        ReusableMethods.waitForVisibility(packagesPage.packagesBannerText, 5);
        Assert.assertTrue(actualBanner.contains(expectedBanner));
        extentTest.pass("Verify, if user can see the title in the banner");

        Assert.assertTrue(packagesPage.theFirstPackagesWebElement.isDisplayed() &&
                                  packagesPage.theSecondPackages.isDisplayed() &&
                                  packagesPage.theThirdPackages.isDisplayed());
        extentTest.pass("Verifies that user can see the first three packages in the page");
    }

    @Test
    public void TC14_02_theFirstPackagesFeaturesTest() {

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookies();
        packagesPage.packagesHeaderLink.click();
        ReusableMethods.waitFor(2);

        extentTest = extentReports.createTest("TC14_01", "User Navigates To The First Packages");

        packagesPage.theFirstPackagesWebElement.click();
        String expectedBannerText = "3 DAYS IN BUENOS AIRES";
        String actualBannerText = packagesPage.theFirstPackageBannerText.getText();
        Assert.assertTrue(actualBannerText.contains(expectedBannerText));
        extentTest.pass("Verifies that  user can see the title in the banner");

        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitFor(2);

        Assert.assertTrue(packagesPage.moreInformationVisibility.isDisplayed());
        extentTest.pass("Verifies that user can see information tabs in the page");
    }

}
