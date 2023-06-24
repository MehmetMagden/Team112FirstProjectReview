package tests.Esra;

import com.github.javafaker.Faker;
import java.util.HashMap;
import java.util.Map;
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
  BasePage basePage = new BasePage();
  RegistrationPage registrationPage = new RegistrationPage();

  @BeforeMethod
  public void setUp() {
    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
  }

  @AfterMethod

//**** using quitDriver method sometimes may cause unexpected problems, If you face this kind of problem, try to use Driver.closeDriver
  public void tearDown() {
    Driver.quitDriver();
  }

  @Test
  public void positiveRegistarationTest() {
    extentTest =
        extentReports.createTest(
            "TC1801",
            "Verify that register on the website with a valid name, email address and password.");
    basePage = new BasePage();
    registrationPage = new RegistrationPage();
    basePage.registrationButton.click();
    String actualPageTitle = Driver.getDriver().getTitle();
    String expectedPageTitle = "Registration";
    Assert.assertTrue(actualPageTitle.contains(expectedPageTitle));
    extentTest.pass("User can access Registration page");

 //**** what a wonderful method :D
    generateFieldsAndFillRegistrationForm(true, true, true);

    ReusableMethods.waitFor(2);
    basePage.acceptCookies();
    registrationPage.makeRegistrationButton.click();
    String registrationMessage = registrationPage.actualRegistrationMessage.getText();
    String expectedRegistrationMessage = "Registration is completed. You can now login.";
    Assert.assertEquals(registrationMessage, expectedRegistrationMessage);
    extentTest.pass("User can register with a valid name, email address and password. ");
    // Assert.assertTrue(registrationPage.loginButton.isDisplayed());

  }

  @Test
  public void NegativeRegistrationTest() {
    extentTest =
        extentReports.createTest(
            "TC1802",
            "Verify that not to register on the website with a valid name, valid email address and invalid password.");
    basePage = new BasePage();
    registrationPage = new RegistrationPage();
    basePage.registrationButton.click();
    String actualPageTitle = Driver.getDriver().getTitle();
    String expectedPageTitle = "Registration";
    Assert.assertTrue(actualPageTitle.contains(expectedPageTitle));
    extentTest.pass("User can access Registration page");

    generateFieldsAndFillRegistrationForm(true, true, false);

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
    basePage = new BasePage();
    registrationPage = new RegistrationPage();
    basePage.registrationButton.click();
    String actualPageTitle = Driver.getDriver().getTitle();
    String expectedPageTitle = "Registration";
    Assert.assertTrue(actualPageTitle.contains(expectedPageTitle));
    extentTest.pass("User can access Registration page");

    generateFieldsAndFillRegistrationForm(true, false, true);

    ReusableMethods.waitFor(2);
    basePage.acceptCookies();

    registrationPage.makeRegistrationButton.click();

    Assert.assertTrue(registrationPage.makeRegistrationButton.isDisplayed());
    extentTest.pass(
        "User cannot register with a valid name, invalid email address and valid password. ");
  }

  private void generateFieldsAndFillRegistrationForm(
      boolean name, boolean email, boolean password) {
    Faker faker = new Faker();
    RegistrationPage registrationPage = new RegistrationPage();
    Map<String, String> fields = new HashMap<>();
    if (name) {
      fields.put("name", faker.name().firstName());
    } else {
      fields.put("name", "");
    }

    if (email) {
      fields.put("email", faker.internet().emailAddress());
    } else {
      fields.put("email", faker.name().username());
    }

    if (password) {
      fields.put("password", faker.internet().password(8, 20, true, true, true));
    } else {
      fields.put("password", faker.internet().password(5, 7, false, false, false));
    }

    registrationPage.fillInRegistrationForm(
        fields.get("name"), fields.get("email"), fields.get("password"));
  }
}
