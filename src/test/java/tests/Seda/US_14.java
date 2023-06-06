package tests.Seda;

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

public class US_14 {
    /*

    As a user, I should be able to navigate to the "Featured Packages" page.
    I should then verify that the packages are visible and active on the page.
    */


    @BeforeMethod
     public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        packagesPage.packagesHeaderLink.click();
        basePage.acceptCookiesButton.click();
        ReusableMethods.waitFor(5);
    }



    PackagesPage packagesPage = new PackagesPage();
    BasePage basePage = new BasePage();

    @Test
    public void TC14_packagesPageIsActiveVisiable() {

        String expectedBanner = "PACKAGES";
        String actualBanner = packagesPage.packagesBannerText.getText();
        ReusableMethods.waitForVisibility(packagesPage.packagesBannerText,5);
        Assert.assertTrue(actualBanner.contains(expectedBanner));

        Assert.assertTrue(packagesPage.featuredPackagesAllTogether.isDisplayed());

    }

    @Test
    public void TC14_01_theFirstPackagesFeaturesTest () {

        packagesPage.theFirstPackagesWebElement.click();

        String expectedBannerText = "3 DAYS IN BUENOS AIRES";
        String actualBannerText = packagesPage.theFirstPackageBannerText.getText();
        Assert.assertTrue(actualBannerText.contains(expectedBannerText));

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitFor(2);

        Assert.assertTrue(packagesPage.moreInformationVisibility.isDisplayed());

       }

    @AfterMethod
    public void tearDown() {

        Driver.closeDriver();
    }
}
