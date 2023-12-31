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

    //**** there should be info steps for the test steps
//**** using hard wait is not  advised in coding instead we should use explicitly waits
//**** (but if is because of computer or connection problems it is acceptable)
    @Test
    public void TC006_01recentPostsAtFooterSectionIsVisible() {
        BasePage basePage = new BasePage();
        extentTest = extentReports.createTest("TC006_01", "User should be able to see the Recent Posts at Footer Section");

        //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));

//**** using hard wait is not  advised in coding instead we should use explicitly waits
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

//**** it is not wrong but sometimes using quitDriver may cause unexpected problems.
// If you face this kind of situations please try to use closeDriver()

        Driver.quitDriver();
    }

    @Test
    public void TC006_02recentPostSectionasAtFooterAreActive() {
        BasePage basePage = new BasePage();
        extentTest = extentReports.createTest("TC006_02", "Links under the Footer section should be active");

        //JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        //js.executeScript("window.scrollBy(0,10000)");

//**** yes they are enable but are there clickable and when we click them where do they take to??? I think we should also test that.
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



