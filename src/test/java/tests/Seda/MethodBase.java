package tests.Seda;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.ah.A;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.AboutUsPage;
import pages.AdminPage;
import pages.BasePage;
import pages.PackagesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MethodBase {

    AdminPage adminPage = new AdminPage();
    PackagesPage packagesPage = new PackagesPage();
    AboutUsPage aboutUsPage = new AboutUsPage();
    BasePage basePage = new BasePage();

    Actions actions = new Actions(Driver.getDriver());


    static MethodBase testMethod = new MethodBase();

    protected static ExtentReports extentReports;
    protected static ExtentTest extentTest;

    @BeforeSuite
    public void beforeSuite() {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportFolder = "test-output";
        String reportName = "report_" + timeStamp + ".html";
        String reportPath = Paths.get(System.getProperty("user.dir"),reportFolder,reportName).toString();

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);

        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Automation Engineer", "Seda Ulgensoy Yalcin");
    }
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) { // if it fails
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // if skipped
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignores
        }
        Driver.closeDriver();
    }


    // To end reporting
    @AfterTest(alwaysRun = true)
    public void tearDownTest() {

        extentReports.flush();
    }
    public void logInAdminPageToNavigate (){

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();

        String expectedTitle = "Admin Panel";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    public void navigatePackagesPage(){

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookies();
        packagesPage.packagesHeaderLink.click();
        ReusableMethods.waitFor(2);

    }

    public void navigateAboutUsPage (){

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookies();
        aboutUsPage.aboutUsHeaderLink.click();

    }

    public void warningMessagesCheck (String expectedWarningMessage , String actualWarningMessage) {
        Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
    }

    public void endOfTheHomePage (){

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookies();

        actions.sendKeys(Keys.END).perform();

        ReusableMethods.waitFor(2);



    }

   }



