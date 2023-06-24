package tests.Seda;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.BasePage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_09 extends MethodBase {

//**** in testNG framework, extends word is used to create report
// does your test create a report??

//**** for everystep entered to Excel file we should create an explaining by using test.info

    /*

    As a user, I should be able to verify that I can join the website's email newsletter.

     */

    HomePage homePage = new HomePage();
    AdminPage adminPage = new AdminPage();
    BasePage basePage = new BasePage();

    Actions actions = new Actions(Driver.getDriver());

    Faker faker = new Faker();


    @Test
    public void TC09_01_joiningEmailNewsletter() {

        extentTest = extentReports.createTest("TC09_01", "User Joins Email Newsletter");

        testMethod.endOfTheHomePage();

        homePage.emailBoxUnderTheNewsLetterOnHomepage.sendKeys(faker.internet().emailAddress());
        homePage.submitButtonUnderTheNewsLetterOnHomepage.click();

        ReusableMethods.waitFor(2);

        testMethod.warningMessagesCheck("To activate your subscription please check your email and follow instruction there.",
                adminPage.warningMessage.getText());
        extentTest.pass("Verifies that user can join email newsletter successfully with correct email address.");

    }

    @Test
    public void TC09_02_negativeJoiningEmailNewsletter() {

        extentTest = extentReports.createTest("TC09_02",
                "User Joins Email Newsletter by using email address without '@'");

        testMethod.endOfTheHomePage();

        homePage.emailBoxUnderTheNewsLetterOnHomepage.sendKeys(ConfigReader.getProperty("userNewsLetterInvalidEmailAddress"));
        homePage.submitButtonUnderTheNewsLetterOnHomepage.click();

//***** in coding, it is not advised to use hard-waits like "ReusableMethods.waitFor".
// instead we should use explicitly waits
//**** (but if is because of computer or connection problems it is acceptable)
        ReusableMethods.waitFor(2);

        testMethod.warningMessagesCheck("Email address is invalid",
                adminPage.warningMessage.getText());
        extentTest.pass("Verifies that user CANNOT enter email address without @");

    }


    @Test
    public void TC09_03_negativeJoiningEmailNewsletter() {

        extentTest = extentReports.createTest("TC09_02",
                "User Joins Email Newsletter by using email address without '.' ");

        testMethod.endOfTheHomePage();

        homePage.emailBoxUnderTheNewsLetterOnHomepage.sendKeys(ConfigReader.getProperty("userNewsLetterInvalidEmailAddress1"));
        homePage.submitButtonUnderTheNewsLetterOnHomepage.click();

        ReusableMethods.waitFor(2);

        testMethod.warningMessagesCheck("Email address is invalid",
                adminPage.warningMessage.getText());
        extentTest.fail("Verifies that user can enter email address without '.' ");

    }

    @Test
    public void TC09_04_negativeJoiningEmailNewsletter() {

        extentTest = extentReports.createTest("TC09_02",
                "User Joins Email Newsletter by using the email address that is submitted before");

        testMethod.endOfTheHomePage();

        homePage.emailBoxUnderTheNewsLetterOnHomepage.sendKeys(ConfigReader.getProperty("userLoginEmailCorrect"));
        homePage.submitButtonUnderTheNewsLetterOnHomepage.click();

        ReusableMethods.waitFor(2);

        testMethod.warningMessagesCheck("Email address already exists",
                adminPage.warningMessage.getText());
        extentTest.fail("Verifies that user CANNOT enter email address that is already submitted before");

    }

}