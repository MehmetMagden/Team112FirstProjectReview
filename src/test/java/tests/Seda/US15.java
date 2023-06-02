package tests.Seda;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutUsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US15 {

    AboutUsPage aboutUsPage = new AboutUsPage();

    @Test
    public void aboutUsPageTest (){

     //1- User opens browser and go to the webpage
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));

    // 2- User go to the About Us Page
        aboutUsPage.aboutUsHeaderLink.click();

    //3 -Accept cookies
         aboutUsPage.acceptCookies.click();

    // 4- Check if "OUR MISSION" is visiable

    String expectedWordMission= "OUR MISSION";
    String actualWordMission = aboutUsPage.aboutUsPageOurMission.getText();

    Assert.assertTrue(aboutUsPage.aboutUsPageOurMission.isDisplayed());

   // 5- Check if "OUR VISION" is visiable

    String expectedWordVision = "OUR VISION";
    String actualWordVision = aboutUsPage.AboutUsPageOurVision.getText();

    Assert.assertTrue(aboutUsPage.AboutUsPageOurVision.isDisplayed());

    // 6 - Check if "About Us" is NOT appeared in the banner

    String expectedWordAboutUs = "About Us";
    String actualWordAboutUs = aboutUsPage.aboutUsBanner.getText();

    Assert.assertFalse(actualWordAboutUs.contains(expectedWordAboutUs));



    }

}
