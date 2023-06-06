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

public class US_14 extends TestBaseRapor {
    /*

    As a user, I should be able to navigate to the "Featured Packages" page.
    I should then verify that the packages are visible and active on the page.
    */

    PackagesPage packagesPage = new PackagesPage();
    BasePage basePage = new BasePage();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeClass
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        packagesPage.packagesHeaderLink.click();
        basePage.acceptCookiesButton.click();
        ReusableMethods.waitFor(5);
    }



    @Test
    public void TC14_packagesPageIsActiveVisiable() {

        String expectedBanner = "PACKAGES";
        String actualBanner = packagesPage.packagesBannerText.getText();
        ReusableMethods.waitForVisibility(packagesPage.packagesBannerText, 5);
        Assert.assertTrue(actualBanner.contains(expectedBanner));
        extentTest.pass("Verify, if user can see the title in the banner");

        Assert.assertTrue(packagesPage.featuredPackagesAllTogether.isDisplayed());
        extentTest.pass("User sees all packages in the page");
    }

    @Test
    public void TC14_01_theFirstPackagesFeaturesTest() {


        packagesPage.theFirstPackagesWebElement.click();

        ReusableMethods.waitFor(5);

        String expectedBannerText = "3 DAYS IN BUENOS AIRES";
        String actualBannerText = packagesPage.theFirstPackageBannerText.getText();
        Assert.assertTrue(actualBannerText.contains(expectedBannerText));

        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitFor(2);

        Assert.assertTrue(packagesPage.moreInformationVisibility.isDisplayed());

    }

    @AfterClass
    public void tearDown() {

        Driver.quitDriver();
    }
}
