package tests.Esra;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Locale;
import java.util.Set;

public class US_07 {

  BasePage basePage = new BasePage();

  @Test
  public void facebookIconTest() {
    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    js.executeScript("window.scrollBy(0,10000)");
    ReusableMethods.waitFor(2);
    Assert.assertTrue(basePage.footerFacobookIcon.isDisplayed());
    String firstPageWH= Driver.getDriver().getWindowHandle();
    basePage.footerFacobookIcon.click();
    ReusableMethods.waitFor(2);
    Set<String> allWH=Driver.getDriver().getWindowHandles();
    String secondWinddowHandleValue="";
    for (String eachWH: allWH) {
      if (!eachWH.equals(firstPageWH)){
        secondWinddowHandleValue=eachWH;
      }
    }
    Driver.getDriver().switchTo().window(secondWinddowHandleValue);
    String expectedTitle="facebook";
    String actualTtitle=Driver.getDriver().getTitle().toLowerCase();
    Assert.assertTrue(actualTtitle.contains(expectedTitle));

    Driver.quitDriver();
  }

  @Test
  public void twitterIconTest() {

    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    js.executeScript("window.scrollBy(0,10000)");
    ReusableMethods.waitFor(2);
    Assert.assertTrue(basePage.footerTwitterIcon.isDisplayed());
    String firstPageWH= Driver.getDriver().getWindowHandle();
    basePage.footerTwitterIcon.click();
    ReusableMethods.waitFor(2);
    Set<String> allWH=Driver.getDriver().getWindowHandles();
    String secondWinddowHandleValue="";
    for (String eachWH: allWH) {
      if (!eachWH.equals(firstPageWH)){
        secondWinddowHandleValue=eachWH;
      }
    }
    Driver.getDriver().switchTo().window(secondWinddowHandleValue);
    String expectedTitle="twitter";
    String actualTtitle=Driver.getDriver().getTitle().toLowerCase();
    Assert.assertTrue(actualTtitle.contains(expectedTitle));

    Driver.quitDriver();
  }

  @Test
  public void linkedinIconTest() {

    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    js.executeScript("window.scrollBy(0,10000)");
    ReusableMethods.waitFor(2);
    Assert.assertTrue(basePage.footerLinkedinIcon.isDisplayed());
    String firstPageWH= Driver.getDriver().getWindowHandle();
    basePage.footerLinkedinIcon.click();
    ReusableMethods.waitFor(2);
    Set<String> allWH=Driver.getDriver().getWindowHandles();
    String secondWinddowHandleValue="";
    for (String eachWH: allWH) {
      if (!eachWH.equals(firstPageWH)){
        secondWinddowHandleValue=eachWH;
      }
    }
    Driver.getDriver().switchTo().window(secondWinddowHandleValue);
    String expectedTitle="linkedin";
    String actualTtitle=Driver.getDriver().getTitle().toLowerCase();
    Assert.assertTrue(actualTtitle.contains(expectedTitle));
    Driver.quitDriver();
  }

  @Test
  public void pinterestIconTest() {

    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    js.executeScript("window.scrollBy(0,10000)");
    ReusableMethods.waitFor(2);
    Assert.assertTrue(basePage.footerPinterestIcon.isDisplayed());
    String firstPageWH= Driver.getDriver().getWindowHandle();
    basePage.footerPinterestIcon.click();
    ReusableMethods.waitFor(2);
    Set<String> allWH=Driver.getDriver().getWindowHandles();
    String secondWinddowHandleValue="";
    for (String eachWH: allWH) {
      if (!eachWH.equals(firstPageWH)){
        secondWinddowHandleValue=eachWH;
      }
    }
    Driver.getDriver().switchTo().window(secondWinddowHandleValue);
    String expectedTitle="pinterest";
    String actualTtitle=Driver.getDriver().getTitle().toLowerCase();
    Assert.assertTrue(actualTtitle.contains(expectedTitle));
    Driver.quitDriver();
  }

  @Test
  public void instagramIconTest() {

    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    js.executeScript("window.scrollBy(0,10000)");
    ReusableMethods.waitFor(2);
    Assert.assertTrue(basePage.footerInstagramIcon.isDisplayed());
    String firstPageWH= Driver.getDriver().getWindowHandle();
    basePage.footerInstagramIcon.click();
    ReusableMethods.waitFor(2);
    Set<String> allWH=Driver.getDriver().getWindowHandles();
    String secondWinddowHandleValue="";
    for (String eachWH: allWH) {
      if (!eachWH.equals(firstPageWH)){
        secondWinddowHandleValue=eachWH;
      }
    }
    Driver.getDriver().switchTo().window(secondWinddowHandleValue);
    String expectedTitle="instagram";
    String actualTtitle=Driver.getDriver().getTitle().toLowerCase();
    Assert.assertTrue(actualTtitle.contains(expectedTitle));
    Driver.quitDriver();
  }
}
