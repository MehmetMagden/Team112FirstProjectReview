package tests.Seda;

import com.aventstack.extentreports.ExtentReports;
import org.apache.hc.core5.reactor.Command;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.openqa.selenium.JavascriptExecutor;
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

public class US_14 extends MethodBase  {

    /*
    As a user, I should be able to navigate to the "Featured Packages" page.
    I should then verify that the packages are visible and active on the page.
    */

    PackagesPage packagesPage ;
    BasePage basePage;
    JavascriptExecutor js ;

    @Test
    public void TC14_packagesPageIsActiveVisible () {

       packagesPage = new PackagesPage();
       basePage = new BasePage();

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl")); // Hazirladigim methodu testlerden sadece birinde kullanabiliyorum.
                                                                           // Her iki teste yapistirinca testler class level de calismiyor.
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

       extentTest = extentReports.createTest("TC14_01", "User Navigates To The First Packages");

       packagesPage = new PackagesPage();
       js = (JavascriptExecutor) Driver.getDriver();
       basePage = new BasePage();

       testMethod.navigatePackagesPage();

        js.executeScript("arguments[0].click();", packagesPage.theSecondPackages);
        ReusableMethods.waitFor(5);
        String expectedBannerText = "Book Now";
        String actualBannerText = packagesPage.bookNowText.getText();
        Assert.assertTrue(actualBannerText.contains(expectedBannerText));
        extentTest.pass("Verifies that  user can see the title in the banner");

    }

}
