package tests.Elcin;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.security.Key;

public class US006 extends TestBaseRapor {
    @Test
    public void TC006_01recentPostsAtFooterSectionIsVisible() {
        BasePage basePage = new BasePage();
        extentTest=extentReports.createTest("TC006_01","User should be able to see the Recent Posts at Footer Section");

        //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
       // js.executeScript("window.scrollBy(0,1000)");
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(basePage.footerRecentPosts.isDisplayed());
        extentTest.pass("Recent Post heading is visible");
        Assert.assertTrue(basePage.recentPostsFirstLink.isDisplayed());
        extentTest.pass("First Link under Recent Post section is visible");
        Assert.assertTrue(basePage.recentPostsSecondLink.isDisplayed());
        extentTest.pass("Second Link under Recent Post section is visible");
        Assert.assertTrue(basePage.recentPostsThirdLink.isDisplayed());
        extentTest.pass("Third Link under Recent Post section is visible");
        Assert.assertTrue(basePage.recentPostsFourthLink.isDisplayed());
        extentTest.pass("Fourth Link under Recent Post section is visible");
        Assert.assertTrue(basePage.recentPostsFifthLink.isDisplayed());
        extentTest.pass("Fifth Link under Recent Post section is visible");

        Driver.quitDriver();
    }
    @Test
    public void TC006_02recentPostSectionasAtFooterAreActive() {
        BasePage basePage = new BasePage();
        extentTest=extentReports.createTest("TC006_02","Links under the Footer section should be active");

        //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        //js.executeScript("window.scrollBy(0,10000)");
        Assert.assertTrue(basePage.recentPostsFirstLink.isEnabled());
        extentTest.pass("First Link under Recent Post heading is active");
        Assert.assertTrue(basePage.recentPostsSecondLink.isEnabled());
        extentTest.pass("Second Link under Recent Post heading is active");
        Assert.assertTrue(basePage.recentPostsThirdLink.isEnabled());
        extentTest.pass("Third Link under Recent Post heading is active");
        Assert.assertTrue(basePage.recentPostsFourthLink.isEnabled());
        extentTest.pass("Fourth Link under Recent Post heading is active");
        Assert.assertTrue(basePage.recentPostsFifthLink.isEnabled());
        Driver.quitDriver();
    }
}




