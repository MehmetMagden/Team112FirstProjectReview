package tests.Seda;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MethodBase {

    AdminPage adminPage = new AdminPage();

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

    @AfterSuite
    public void afterSuite() {
        extentReports.flush();
        Driver.quitDriver();
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
    public void warningMessagesCheck (String expectedWarningMessage , String actualWarningMessage) {
        Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
    }
}
