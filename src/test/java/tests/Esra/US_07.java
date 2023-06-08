package tests.Esra;

import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_07 extends TestBaseRapor {

  BasePage basePage = new BasePage();

  @BeforeMethod
  public void setUp() {
    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    js.executeScript("window.scrollBy(0,10000)");
    ReusableMethods.waitFor(2);
  }

  @AfterMethod
  public void tearDown() {
    Driver.quitDriver();
  }

  @Test
  public void facebookIconTest() {
    extentTest =
        extentReports.createTest(
            "TC0701",
            "Verify that the Facebook icon in the footer section of the website is visible and active.");
    BasePage basePage = new BasePage();

    Assert.assertTrue(basePage.footerFacobookIcon.isDisplayed());
    extentTest.pass(
        "Verify that the Facebook icon in the footer section of the website is visible");

    String firstPageWH = Driver.getDriver().getWindowHandle();
    basePage.footerFacobookIcon.click();
    ReusableMethods.waitFor(2);
    Set<String> allWH = Driver.getDriver().getWindowHandles();
    String secondWinddowHandleValue = "";
    for (String eachWH : allWH) {
      if (!eachWH.equals(firstPageWH)) {
        secondWinddowHandleValue = eachWH;
      }
    }
    Driver.getDriver().switchTo().window(secondWinddowHandleValue);
    String expectedTitle = "facebook";
    String actualTtitle = Driver.getDriver().getTitle().toLowerCase();
    Assert.assertTrue(actualTtitle.contains(expectedTitle));
    extentTest.pass("Verify that the Facebook icon in the footer section of the website is active");


  }

  @Test
  public void twitterIconTest() {
    extentTest =
        extentReports.createTest(
            "TC1302",
            "Verify that the Twitter icon in the footer section of the website is visible and active.");
    BasePage basePage = new BasePage();

    Assert.assertTrue(basePage.footerTwitterIcon.isDisplayed());
    extentTest.pass("Verify that the Twitter icon in the footer section of the website is visible");

    String firstPageWH = Driver.getDriver().getWindowHandle();
    basePage.footerTwitterIcon.click();
    ReusableMethods.waitFor(2);
    Set<String> allWH = Driver.getDriver().getWindowHandles();
    String secondWinddowHandleValue = "";
    for (String eachWH : allWH) {
      if (!eachWH.equals(firstPageWH)) {
        secondWinddowHandleValue = eachWH;
      }
    }
    Driver.getDriver().switchTo().window(secondWinddowHandleValue);
    String expectedTitle = "twitter";
    String actualTtitle = Driver.getDriver().getTitle().toLowerCase();
    Assert.assertTrue(actualTtitle.contains(expectedTitle));
    extentTest.fail(
        "Verify that the Twitter icon in the footer section of the website is not functional");


  }

  @Test
  public void linkedinIconTest() {
    extentTest =
        extentReports.createTest(
            "TC1303",
            "Verify that the Linkedin icon in the footer section of the website is visible and active.");
    BasePage basePage = new BasePage();

    Assert.assertTrue(basePage.footerLinkedinIcon.isDisplayed());
    extentTest.pass(
        "Verify that the Linkedin icon in the footer section of the website is visible");

    String firstPageWH = Driver.getDriver().getWindowHandle();
    basePage.footerLinkedinIcon.click();
    ReusableMethods.waitFor(2);
    Set<String> allWH = Driver.getDriver().getWindowHandles();
    String secondWinddowHandleValue = "";
    for (String eachWH : allWH) {
      if (!eachWH.equals(firstPageWH)) {
        secondWinddowHandleValue = eachWH;
      }
    }
    Driver.getDriver().switchTo().window(secondWinddowHandleValue);
    String expectedTitle = "linkedin";
    String actualTtitle = Driver.getDriver().getTitle().toLowerCase();
    Assert.assertTrue(actualTtitle.contains(expectedTitle));
    extentTest.pass("Verify that the Linkedin icon in the footer section of the website is active");

  }

  @Test
  public void pinterestIconTest() {

    extentTest =
        extentReports.createTest(
            "TC1304",
            "Verify that the Pinterest icon in the footer section of the website is visible and active.");
    BasePage basePage = new BasePage();

    Assert.assertTrue(basePage.footerPinterestIcon.isDisplayed());
    extentTest.pass(
        "Verify that the Pinterest icon in the footer section of the website is visible");

    String firstPageWH = Driver.getDriver().getWindowHandle();
    basePage.footerPinterestIcon.click();
    ReusableMethods.waitFor(2);
    Set<String> allWH = Driver.getDriver().getWindowHandles();
    String secondWinddowHandleValue = "";
    for (String eachWH : allWH) {
      if (!eachWH.equals(firstPageWH)) {
        secondWinddowHandleValue = eachWH;
      }
    }
    Driver.getDriver().switchTo().window(secondWinddowHandleValue);
    String expectedTitle = "pinterest";
    String actualTtitle = Driver.getDriver().getTitle().toLowerCase();
    Assert.assertTrue(actualTtitle.contains(expectedTitle));
    extentTest.fail(
        "Verify that the Pinterest icon in the footer section of the website is not functional");


  }

  @Test
  public void instagramIconTest() {
    extentTest =
        extentReports.createTest(
            "TC1305",
            "Verify that the Instagram icon in the footer section of the website is visible and active.");
    BasePage basePage = new BasePage();

    Assert.assertTrue(basePage.footerInstagramIcon.isDisplayed());
    extentTest.pass(
        "Verify that the Instagram icon in the footer section of the website is visible");

    String firstPageWH = Driver.getDriver().getWindowHandle();
    basePage.footerInstagramIcon.click();
    ReusableMethods.waitFor(2);
    Set<String> allWH = Driver.getDriver().getWindowHandles();
    String secondWinddowHandleValue = "";
    for (String eachWH : allWH) {
      if (!eachWH.equals(firstPageWH)) {
        secondWinddowHandleValue = eachWH;
      }
    }
    Driver.getDriver().switchTo().window(secondWinddowHandleValue);
    String expectedTitle = "instagram";
    String actualTtitle = Driver.getDriver().getTitle().toLowerCase();
    Assert.assertTrue(actualTtitle.contains(expectedTitle));
    extentTest.pass(
        "Verify that the Instagram icon in the footer section of the website is active");


  }
}
