package tests.Esra;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_23 {
  // As a user, I should be able to verify that I can log out of the user session after logging in.
  BasePage basePage = new BasePage();
  LoginPage loginPage=new LoginPage();

  @Test
  public void successfullLogOutTest() {
    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
    loginPage.loginButtonHomePage.click();
    basePage.acceptCookiesButton.click();
    loginPage.loginPageEmailAddressTextBox.sendKeys(ConfigReader.getProperty("userLoginEmailCorrect"));
    loginPage.loginPagePasswordBox.sendKeys(ConfigReader.getProperty("userLoginPasswordCorrect"));
    loginPage.loginPageLoginButton.click();
    ReusableMethods.waitFor(2);
    loginPage.logOutButton.click();
    Assert.assertTrue(loginPage.loginPageLoginButton.isDisplayed());
    Driver.quitDriver();
  }
}