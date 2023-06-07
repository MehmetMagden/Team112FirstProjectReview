package tests.Seda;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutUsPage;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_15 extends TestBaseRapor {

    AboutUsPage aboutUsPage = new AboutUsPage();
    BasePage basePage = new BasePage();


    @Test
    public void aboutUsPageTest() {

        extentTest = extentReports.createTest("TC15", "User Navigates To About Us Page");

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        aboutUsPage.aboutUsHeaderLink.click();
        basePage.acceptCookiesButton.click();

        String expectedWordMission = "OUR MISSION";
        String actualWordMission = aboutUsPage.aboutUsPageOurMission.getText();
        Assert.assertTrue(aboutUsPage.aboutUsPageOurMission.isDisplayed());
        extentTest.pass("Verify, user can see Mission Statement in the page");

        String expectedWordVision = "OUR VISION";
        String actualWordVision = aboutUsPage.AboutUsPageOurVision.getText();
        Assert.assertTrue(aboutUsPage.AboutUsPageOurVision.isDisplayed());
        extentTest.pass("Verify, user can see Vision Statement in the page");

        String expectedWordAboutUs = "ABOUT US";
        String actualWordAboutUs = aboutUsPage.aboutUsBanner.getText();
        Assert.assertTrue(actualWordAboutUs.contains(expectedWordAboutUs));
        extentTest.fail("Verify, user can see About Us text in the banner");//Test failed as NO "About Us" written in the banner

        Driver.closeDriver();

    }
}
