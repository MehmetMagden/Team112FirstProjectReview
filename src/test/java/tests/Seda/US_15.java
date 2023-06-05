package tests.Seda;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutUsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_15 {

    AboutUsPage aboutUsPage = new AboutUsPage();

    @Test
    public void aboutUsPageTest (){

    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));

    aboutUsPage.aboutUsHeaderLink.click();

    aboutUsPage.acceptCookies.click();

    String expectedWordMission= "OUR MISSION";
    String actualWordMission = aboutUsPage.aboutUsPageOurMission.getText();

    Assert.assertTrue(aboutUsPage.aboutUsPageOurMission.isDisplayed());

    String expectedWordVision = "OUR VISION";
    String actualWordVision = aboutUsPage.AboutUsPageOurVision.getText();

    Assert.assertTrue(aboutUsPage.AboutUsPageOurVision.isDisplayed());

   // Test failed  as NO "About Us" written in the banner

    String expectedWordAboutUs = "About Us";
    String actualWordAboutUs = aboutUsPage.aboutUsBanner.getText();

    Assert.assertTrue(actualWordAboutUs.contains(expectedWordAboutUs));

    Driver.closeDriver();

    }

}
