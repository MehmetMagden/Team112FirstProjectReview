package tests.Seda;

import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.FaqPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_16 extends MethodBase{

    /*
    As a user, I should be able to verify that the Frequently Asked Questions (FAQ) page is visible and active

     */

    BasePage basePage = new BasePage();
    FaqPage faqPage = new FaqPage();
    @Test
    public void TC16_frequentlyAskedQuestionsPage(){

        extentTest = extentReports.createTest("TC16",
                "User navigates Frequently Asked Questions Page");

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookies();

        faqPage.faqHeaderLink.click();

        String expectedBannerText = "FAQ";
        String actualBannerText = faqPage.faqBannerText.getText();
        Assert.assertTrue(actualBannerText.contains(expectedBannerText));
        extentTest.pass("Verifies that user can reach Frequently Asked Questions Page ");

        faqPage.faqQuestionOne.click();
        Assert.assertTrue(faqPage.faqText.isDisplayed());
        extentTest.pass("Verifies that user can click the questiona and see the answer.");


    }


}
