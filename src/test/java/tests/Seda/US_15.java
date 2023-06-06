package tests.Seda;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutUsPage;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_15 {

    AboutUsPage aboutUsPage = new AboutUsPage();
    BasePage basePage = new BasePage();


    @Test
    public void aboutUsPageTest() {

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        aboutUsPage.aboutUsHeaderLink.click();
        basePage.acceptCookiesButton.click();

        String expectedWordMission = "OUR MISSION";
        String actualWordMission = aboutUsPage.aboutUsPageOurMission.getText();
        Assert.assertTrue(aboutUsPage.aboutUsPageOurMission.isDisplayed());

        String expectedWordVision = "OUR VISION";
        String actualWordVision = aboutUsPage.AboutUsPageOurVision.getText();
        Assert.assertTrue(aboutUsPage.AboutUsPageOurVision.isDisplayed());

        String expectedWordAboutUs = "ABOUT US";
        String actualWordAboutUs = aboutUsPage.aboutUsBanner.getText();
        Assert.assertTrue(actualWordAboutUs.contains(expectedWordAboutUs)); //Test failed as NO "About Us" written in the banner

        Driver.closeDriver();

    }
}
