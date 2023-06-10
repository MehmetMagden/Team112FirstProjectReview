package tests.Esra;

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

public class US_23 extends TestBaseRapor {
  // As a user, I should be able to verify that I can log out of the user session after logging in.
  BasePage basePage = new BasePage();
  LoginPage loginPage = new LoginPage();

  @BeforeMethod
  public void setUp() {
    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
  }

  @AfterMethod
  public void tearDown() {
    Driver.quitDriver();
  }

  @Test
  public void successfullLogOutTest() {
    extentTest =
        extentReports.createTest(
            "TC2301", "Verify that user can log out of the user session after logging in.");

    loginPage.loginButtonHomePage.click();
    basePage.acceptCookiesButton.click();
    loginPage.loginPageEmailAddressTextBox.sendKeys(
        ConfigReader.getProperty("userLoginEmailCorrect"));
    loginPage.loginPagePasswordBox.sendKeys(ConfigReader.getProperty("userLoginPasswordCorrect"));
    loginPage.loginPageLoginButton.click();
    ReusableMethods.waitFor(2);
    loginPage.logOutButton.click();
    Assert.assertTrue(loginPage.loginPageLoginButton.isDisplayed());
    extentTest.pass("User can log out after a successful log in.");
  }
}
