package tests.Elcin;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.dnd.DragGestureEvent;

public class US019 extends TestBaseRapor {
  @BeforeMethod
  public void setUp() {
    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

  }

  @AfterMethod
  public void tearDown() {
    Driver.quitDriver();
  }
LoginPage loginPage=new LoginPage();
  @Test
  public void TC019_01logInToWebPageWithRegisteredNameAndPassword() {
    extentTest = extentReports.createTest("TC019_01", "User should be able to loginto admin page with registered name and password");
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    basePage.acceptCookiesButton.click();
    ReusableMethods.waitFor(2);
    loginPage.loginButtonHomePage.click();
    loginPage.loginPageEmailAddressTextBox.sendKeys(ConfigReader.getProperty("userLoginEmailCorrect"));
    loginPage.loginPagePasswordBox.sendKeys(ConfigReader.getProperty("userLoginPasswordCorrect"));
    loginPage.loginPageLoginButton.click();
    ReusableMethods.waitFor(2);
    basePage.homePageHomeButton.click();
    String actualUrl = Driver.getDriver().getCurrentUrl();
    String expectedUrl = "https://qa.tripandway.com/";
    Assert.assertEquals(actualUrl, expectedUrl);
    extentTest.pass("User can successfuly log into admin page");


  }


}
