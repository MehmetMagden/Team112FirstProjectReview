package tests.Elcin;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
public class US006 {
  //Back Up test in case I cannot use US006_MightChange class//

    @Test
    public void TC006_01recentPostsAtFooterSectionIsVisible() {
        BasePage basePage = new BasePage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        js.executeScript("window.scrollBy(0,10000)");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(basePage.footerRecentPosts.isDisplayed());
        Assert.assertTrue(basePage.recentPostsFirstLink.isDisplayed());
        Assert.assertTrue(basePage.recentPostsSecondLink.isDisplayed());
        Assert.assertTrue(basePage.recentPostsThirdLink.isDisplayed());
        Assert.assertTrue(basePage.recentPostsFourthLink.isDisplayed());
        Assert.assertTrue(basePage.recentPostsFifthLink.isDisplayed());

        Driver.quitDriver();
    }
    @Test
    public void TC006_02recentPostSectionasAtFooterAreActive() {
        BasePage basePage = new BasePage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        js.executeScript("window.scrollBy(0,10000)");
        Assert.assertTrue(basePage.recentPostsFirstLink.isEnabled());
        Assert.assertTrue(basePage.recentPostsSecondLink.isEnabled());
        Assert.assertTrue(basePage.recentPostsThirdLink.isEnabled());
        Assert.assertTrue(basePage.recentPostsFourthLink.isEnabled());
        Assert.assertTrue(basePage.recentPostsFifthLink.isEnabled());
        Driver.quitDriver();
    }
}




