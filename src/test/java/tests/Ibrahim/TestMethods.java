package tests.Ibrahim;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.AdminPage;
import pages.BasePage;
import pages.DestinationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestMethods {
    BasePage basePage = new BasePage();
    DestinationsPage destinationsPage = new DestinationsPage();
    AdminPage adminPage = new AdminPage();
    String actualTestData = "";
    String expectedTestData = "";
    String ordersAmount = "";

    protected static ExtentReports extent;
    protected static ExtentTest test;

    @BeforeSuite
    public void beforeSuite() {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportFolder = "test-output";
        String reportName = "report_" + timeStamp + ".html";
        String reportPath = Paths.get(System.getProperty("user.dir"),reportFolder,reportName).toString();

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Engineer", "Ibrahim Unal");
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush();
        Driver.quitDriver();
    }

    public void userNavigatesAndVerifiesToDestinationPage () {

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage = new BasePage();
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("tripAndWayUrl");
        Assert.assertEquals(actualTestData, expectedTestData);
        Assert.assertTrue(basePage.homePageDestinationsButton.isEnabled());
        basePage.homePageDestinationsButton.click();
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("destinationsUrl");
        Assert.assertEquals(actualTestData, expectedTestData);

    }

    public void userVerifiesDestinationPageVisibleAndActive() {

        destinationsPage = new DestinationsPage();
        Assert.assertTrue(destinationsPage.destinationsImageWebElement.isDisplayed());
        Assert.assertTrue(destinationsPage.destinationsFirstPackageWebElement.isEnabled());

    }

    public void userNavigatesAndVerifiesToAdminPage(){

        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        ReusableMethods.waitFor(2);
        adminPage = new AdminPage();
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();
        ReusableMethods.waitFor(2);
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminDashboardUrl");
        Assert.assertEquals(actualTestData, expectedTestData);
        Assert.assertTrue(adminPage.adminDashboardVisibility.isDisplayed());
        ReusableMethods.waitFor(2);

    }

    public void userAccessAndVerifiesOrdersSection() {

        adminPage = new AdminPage();
        ordersAmount = adminPage.adminMainPageCompletedOrdersWebElement.getText();
        adminPage.adminDashboardOrderButton.click();
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminOrdersPageUrl");
        Assert.assertEquals(actualTestData,expectedTestData);
        actualTestData = adminPage.viewOrdersWebElement.getText();
        expectedTestData = "View Orders";
        Assert.assertTrue(actualTestData.contains(expectedTestData));
        ReusableMethods.waitFor(2);

    }

    public void userViewAndVerifiesAllPlacedOrder() {

        adminPage = new AdminPage();
        Assert.assertTrue(adminPage.allOrdersWebElement.isDisplayed());
        actualTestData = adminPage.allOrdersWebElement.getText();
        Assert.assertTrue(actualTestData.contains(ordersAmount));
        ReusableMethods.waitFor(2);

    }


    public void userNavigatesAndVerifiesToSubscribersPage() {

        adminPage = new AdminPage();
        adminPage.subscriberButton.click();
        adminPage.allSubscribersButton.click();
        ReusableMethods.waitFor(2);
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminSubscribersPageUrl");
        Assert.assertEquals(actualTestData,expectedTestData);
        Assert.assertTrue(adminPage.viewSubscribersWebElement.isDisplayed());
        ReusableMethods.waitFor(2);

    }

    public void userAccessAndVerifiesAllNewsletterSubscribers() {

        adminPage = new AdminPage();
        Assert.assertTrue(adminPage.allSubscribersButton.isEnabled());
        ReusableMethods.waitFor(2);
        actualTestData = adminPage.allSubscribersWebElement.getText();
        expectedTestData ="Showing 1 to 10 of";
        Assert.assertTrue(actualTestData.contains(expectedTestData));
        ReusableMethods.waitFor(2);

    }

    public void userNavigatesAndVerifiesToCategoriesPageInBlogSection() {

        adminPage = new AdminPage();
        adminPage.adminPanelBlogSectionButton.click();
        adminPage.adminPanelBlogSectionCategoriesButton.click();
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminCategoriesPageUrl");
        Assert.assertEquals(actualTestData,expectedTestData);
        Assert.assertTrue(adminPage.blogSectionCategoriesAddNewButton.isEnabled());
        ReusableMethods.waitFor(2);
    }

    public void userAddsNewCategoryAndVerifiesInCategorySection() {

        adminPage = new AdminPage();
        adminPage.blogSectionCategoriesAddNewButton.click();
        Assert.assertTrue(adminPage.addCategorySubmitButton.isEnabled());
        adminPage.addCategoryNameBox.sendKeys("Team112");
        adminPage.addCategorySubmitButton.click();
        Assert.assertTrue(adminPage.addCategorySuccessfulAlert.isDisplayed());
        ReusableMethods.waitFor(2);

    }

    public void userEditsToAddedCategoryAndVerifiesInCategorySection() {

        adminPage = new AdminPage();
        adminPage.categoriesSearchBox.sendKeys("Team112");
        adminPage.categoriesActionEditButton.click();
        Assert.assertTrue(adminPage.editCategoryUpdateButton.isEnabled());
        adminPage.addCategoryNameBox.clear();
        adminPage.addCategoryNameBox.sendKeys("T112-Category Edited");
        adminPage.editCategoryUpdateButton.click();
        Assert.assertTrue(adminPage.editCategorySuccessfulAlert.isDisplayed());
        ReusableMethods.waitFor(2);

    }

    public void userDeletesToAddedCategoryAndVerifiesInCategorySection() {

        adminPage = new AdminPage();
        adminPage.categoriesSearchBox.sendKeys("T112-Category Edited");
        Assert.assertTrue(adminPage.categoriesActionDeleteButton.isEnabled());
        adminPage.categoriesActionDeleteButton.click();
        Driver.getDriver().switchTo().alert().accept();
        Assert.assertTrue(adminPage.categoriesDeletedSuccessfulAlert.isDisplayed());
        ReusableMethods.waitFor(2);

    }
}