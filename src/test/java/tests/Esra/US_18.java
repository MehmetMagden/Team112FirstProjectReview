package tests.Esra;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_18 extends TestBaseRapor {

  @BeforeMethod
  public void setUp() {
    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
  }

  @AfterMethod
  public void tearDown() {
    Driver.quitDriver();
  }

  @Test
  public void pozitiveRegistarationTest() {
    extentTest =
        extentReports.createTest(
            "TC1801",
            "Verify that register on the website with a valid name, email address and password.");
    BasePage basePage = new BasePage();
    RegistrationPage registrationPage = new RegistrationPage();
    basePage.registrationButton.click();
    basePage.acceptCookiesButton.click();
    Faker faker = new Faker();

    registrationPage.registrationNameBox.sendKeys(faker.name().firstName());

    registrationPage.registrationEmailBox.sendKeys(faker.internet().emailAddress());

    registrationPage.registrationPasswordBox.sendKeys(
        ConfigReader.getProperty("userRegistrationValidPassword"));

    ReusableMethods.waitFor(2);

    registrationPage.makeRegistrationButton.click();
    String registrationMessage = registrationPage.registrationWarningMessage.getText();
    String expectedRegistrationMessage = "Registration is completed. You can now login.";
    Assert.assertEquals(registrationMessage, expectedRegistrationMessage);
    extentTest.pass("User can register with a valid name, email address and password. ");
    // Assert.assertTrue(registrationPage.loginButton.isDisplayed());

  }

  /*
  Test with invalid password
   */
  @Test
  public void NegativeRegistrationTest() {
    extentTest =
        extentReports.createTest(
            "TC1802",
            "Verify that not to register on the website with a valid name, valid email address and invalid password.");
    BasePage basePage = new BasePage();
    RegistrationPage registrationPage = new RegistrationPage();
    basePage.registrationButton.click();
    basePage.acceptCookiesButton.click();
    Faker faker = new Faker();

    registrationPage.registrationNameBox.sendKeys(faker.name().firstName());

    registrationPage.registrationEmailBox.sendKeys(faker.internet().emailAddress());

    registrationPage.registrationPasswordBox.sendKeys(
        ConfigReader.getProperty("userRegistrationInvalidPassword"));

    ReusableMethods.waitFor(2);
    basePage.acceptCookies();

    registrationPage.makeRegistrationButton.click();
    Assert.assertTrue(registrationPage.makeRegistrationButton.isDisplayed());
    extentTest.pass(
        "User cannot register with a valid name, valid email address and invalid password. ");
  }

  @Test
  public void NegativeRegistrationTest01() {
    extentTest =
        extentReports.createTest(
            "TC1803",
            "Verify that not to register on the website with a valid name, invalid email address and valid password.");
    BasePage basePage = new BasePage();
    RegistrationPage registrationPage = new RegistrationPage();
    basePage.registrationButton.click();
    basePage.acceptCookiesButton.click();
    Faker faker = new Faker();

    registrationPage.registrationNameBox.sendKeys(faker.name().firstName());

    registrationPage.registrationEmailBox.sendKeys(
        ConfigReader.getProperty("userRegistrationInvalidEmailAddress"));

    registrationPage.registrationPasswordBox.sendKeys(
        ConfigReader.getProperty("userRegistrationValidPassword"));

    ReusableMethods.waitFor(2);
    basePage.acceptCookies();

    registrationPage.makeRegistrationButton.click();

    Assert.assertTrue(registrationPage.makeRegistrationButton.isDisplayed());
    extentTest.pass(
        "User cannot register with a valid name, invalid email address and valid password. ");
  }

  @Test
  public void NegativeRegistrationTest02() {
    extentTest =
        extentReports.createTest(
            "TC1804",
            "Verify that not to register on the website with a valid name, invalid email address and valid password.");
    BasePage basePage = new BasePage();
    RegistrationPage registrationPage = new RegistrationPage();
    basePage.registrationButton.click();
    basePage.acceptCookiesButton.click();
    Faker faker = new Faker();

    registrationPage.registrationNameBox.sendKeys(faker.name().firstName());

    registrationPage.registrationEmailBox.sendKeys(
        ConfigReader.getProperty("userRegistrationInvalidEmailAddress01"));

    registrationPage.registrationPasswordBox.sendKeys(
        ConfigReader.getProperty("userRegistrationValidPassword"));

    ReusableMethods.waitFor(2);
    basePage.acceptCookies();

    registrationPage.makeRegistrationButton.click();

    Assert.assertTrue(registrationPage.makeRegistrationButton.isDisplayed());
    extentTest.fail(
        "User can register with a valid name, invalid email address and valid password. ");
  }
}
