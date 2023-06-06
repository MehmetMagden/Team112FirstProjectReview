package tests.Esra;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;

public class US_07 {

BasePage basePage= new BasePage();
@Test
    public void facebookIconTest(){
    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
    JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
    js.executeScript("window.scrollBy(0,10000)");
    ReusableMethods.waitFor(2);
    Assert.assertTrue(basePage.footerFacobookIcon.isDisplayed());
    Assert.assertTrue(basePage.footerFacobookIcon.isEnabled());
    Driver.quitDriver();

}

@Test
    public void twitterIconTest(){

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,10000)");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(basePage.footerTwitterIcon.isDisplayed());
        Assert.assertTrue(basePage.footerTwitterIcon.isEnabled());
    Driver.quitDriver();

}

@Test
    public void linkedinIconTest(){

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,10000)");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(basePage.footerLinkedinIcon.isDisplayed());
        Assert.assertTrue(basePage.footerLinkedinIcon.isEnabled());
    Driver.quitDriver();
}

@Test
    public void pinterestIconTest(){

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,10000)");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(basePage.footerPinterestIcon.isDisplayed());
        Assert.assertTrue(basePage.footerPinterestIcon.isEnabled());
    Driver.quitDriver();
}

@Test
    public void instagramIconTest(){

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,10000)");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(basePage.footerInstagramIcon.isDisplayed());
        Assert.assertTrue(basePage.footerInstagramIcon.isEnabled());
    Driver.quitDriver();
}
}
