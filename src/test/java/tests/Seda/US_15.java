package tests.Seda;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutUsPage;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_15 extends MethodBase {

    /*
    As a user, I should be able to verify that all the accessible elements on the About Us page are visible.
     */

    AboutUsPage aboutUsPage = new AboutUsPage();
    BasePage basePage = new BasePage();

    @Test
    public void aboutUsPageTest() {

        extentTest = extentReports.createTest("TC15", "User Navigates To About Us Page");

        testMethod.navigateAboutUsPage();

//**** I think "expectedWordMission" and "actualWordMission" have not been used in this test case
        String expectedWordMission = "OUR MISSION";
        String actualWordMission = aboutUsPage.aboutUsPageOurMission.getText();
        Assert.assertTrue(aboutUsPage.aboutUsPageOurMission.isDisplayed());
        extentTest.pass("Verify, user can see Mission Statement in the page");
//**** I think "expectedWordVision" and "actualWordVision" have not been used in this test case
        String expectedWordVision = "OUR VISION";
        String actualWordVision = aboutUsPage.AboutUsPageOurVision.getText();
        Assert.assertTrue(aboutUsPage.AboutUsPageOurVision.isDisplayed());
        extentTest.pass("Verify, user can see Vision Statement in the page");

        String expectedWordAboutUs = "ABOUT US";
        String actualWordAboutUs = aboutUsPage.aboutUsBanner.getText();
        Assert.assertTrue(actualWordAboutUs.contains(expectedWordAboutUs));
        extentTest.fail("Verifies that user CANNOT see About Us text in the banner");//Test failed as NO "About Us" written in the banner

    }
}
