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

    @Test
    public void TC006_01recentPostSAtFooterVisible(){
        BasePage basePage=new BasePage();
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        Actions actions=new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        js.executeScript("window.scrollBy(0,10000)");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(basePage.footerRecentPosts.isDisplayed());

        Driver.quitDriver();
    }

    @Test
    public void TC006_02recentPostSectionasAtFooterAreActive(){
        BasePage basePage=new BasePage();
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        Actions actions=new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        js.executeScript("window.scrollBy(0,10000)");
        ReusableMethods.waitFor(3);

        basePage.recentPostsFirstLink.click();
        js.executeScript("window.scrollBy(0,1000)");
        ReusableMethods.waitFor(2);
        String actualWord=basePage.recentPostsLinkExpectedWord.getText();
        String expectedWord= "Comments";
        Assert.assertEquals(actualWord,expectedWord);


        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(3);
        basePage.recentPostsSecondLink.click();
        ReusableMethods.waitFor(3);
        js.executeScript("window.scrollBy(0,300)");
        actualWord=basePage.recentPostsSecondAndThirdExpectedWord.getText();
        ReusableMethods.waitFor(2);
        expectedWord= "Categories";
        Assert.assertEquals(actualWord,expectedWord);

        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(3);
        basePage.recentPostsThirdLink.click();
        ReusableMethods.waitFor(2);
        js.executeScript("window.scrollBy(0,900)");
        actualWord=basePage.recentPostsSecondAndThirdExpectedWord.getText();
        expectedWord= "Categories";
        Assert.assertEquals(actualWord,expectedWord);

        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(3);
        basePage.recentPostsFourthLink.click();
        ReusableMethods.waitFor(2);
        js.executeScript("window.scrollBy(0,1400)");
        actualWord=basePage.getRecentPostsFourthAndFifthLinkExpectedWord.getText();
        expectedWord= "Share Now";
        Assert.assertEquals(actualWord,expectedWord);


        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(3);
        basePage.recentPostsFifthLink.click();
        ReusableMethods.waitFor(2);
        js.executeScript("window.scrollBy(0,1400)");
        ReusableMethods.waitFor(3);
        actualWord=basePage.getRecentPostsFourthAndFifthLinkExpectedWord.getText();
        expectedWord= "Share Now";
        Assert.assertEquals(actualWord,expectedWord);

        Driver.quitDriver();



    }

}
