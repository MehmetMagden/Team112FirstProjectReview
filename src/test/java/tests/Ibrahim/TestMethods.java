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
        Assert.assertEquals(actualTestData, expectedTestData, "Actual page is NOT main page");
        Assert.assertTrue(basePage.homePageDestinationsButton.isEnabled() , "Main page is NOT active");
        basePage.homePageDestinationsButton.click();
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("destinationsUrl");
        Assert.assertEquals(actualTestData, expectedTestData , "Actual page is NOT Destinations page");

    }

    public void userVerifiesDestinationPageVisibleAndActive() {

        destinationsPage = new DestinationsPage();
        Assert.assertTrue(destinationsPage.destinationsImageWebElement.isDisplayed(), "Destination page is NOT displayed");
        Assert.assertTrue(destinationsPage.destinationsFirstPackageWebElement.isEnabled(), "Destination page is NOT active");

    }

    public void userNavigatesAndVerifiesToAdminPage(){

        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        adminPage = new AdminPage();
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminDashboardUrl");
        Assert.assertEquals(actualTestData, expectedTestData, "Actual page is NOT admin dashboard");
        Assert.assertTrue(adminPage.adminDashboardVisibility.isDisplayed(), "Admin dashboard is NOT displayed");
        ReusableMethods.waitFor(2);

    }

    public void userAccessAndVerifiesOrdersSection() {

        adminPage = new AdminPage();
        ordersAmount = adminPage.adminMainPageCompletedOrdersWebElement.getText();
        adminPage.adminDashboardOrderButton.click();
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminOrdersPageUrl");
        Assert.assertEquals(actualTestData,expectedTestData, "Actual page is NOT Orders page");
        actualTestData = adminPage.viewOrdersWebElement.getText();
        expectedTestData = "View Orders";
        Assert.assertTrue(actualTestData.contains(expectedTestData), "Orders page is NOT displayed");
        ReusableMethods.waitFor(2);

    }

    public void userViewAndVerifiesAllPlacedOrder() {

        adminPage = new AdminPage();
        Assert.assertTrue(adminPage.allOrdersWebElement.isDisplayed());
        actualTestData = adminPage.allOrdersWebElement.getText();
        Assert.assertTrue(actualTestData.contains(ordersAmount), "All placed orders is NOT displayed");
        ReusableMethods.waitFor(2);

    }


    public void userNavigatesAndVerifiesToSubscribersPage() {

        adminPage = new AdminPage();
        adminPage.subscriberButton.click();
        adminPage.allSubscribersButton.click();
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminSubscribersPageUrl");
        Assert.assertEquals(actualTestData,expectedTestData, "Actual page is NOT Subscribers page");
        Assert.assertTrue(adminPage.viewSubscribersWebElement.isDisplayed(), "Subscribers page is NOT displayed");
        ReusableMethods.waitFor(2);

    }

    public void userAccessAndVerifiesAllNewsletterSubscribers() {

        adminPage = new AdminPage();
        Assert.assertTrue(adminPage.allSubscribersButton.isEnabled(), "All Subscribers button is NOT enabled");
        actualTestData = adminPage.allSubscribersWebElement.getText();
        expectedTestData ="Showing 1 to 10 of";
        Assert.assertTrue(actualTestData.contains(expectedTestData), "All Subscribers list is NOT displayed");
        ReusableMethods.waitFor(2);

    }

    public void userNavigatesAndVerifiesToCategoriesPageInBlogSection() {

        adminPage = new AdminPage();
        adminPage.adminPanelBlogSectionButton.click();
        adminPage.adminPanelBlogSectionCategoriesButton.click();
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminCategoriesPageUrl");
        Assert.assertEquals(actualTestData,expectedTestData, "Actual page is NOT Categories page");
        Assert.assertTrue(adminPage.blogSectionCategoriesAddNewButton.isEnabled(),"Categories page is NOT displayed");
        ReusableMethods.waitFor(2);
    }

    public void userAddsNewCategoryAndVerifiesInCategorySection() {

        adminPage = new AdminPage();
        adminPage.blogSectionCategoriesAddNewButton.click();
        Assert.assertTrue(adminPage.addCategorySubmitButton.isEnabled(), "Categories page is NOT active");
        adminPage.addCategorySubmitButton.click();
        Assert.assertTrue(adminPage.addCategoryWithoutNameAlertMEssage.isDisplayed());
        adminPage.addCategoryNameBox.sendKeys("Team112");
        adminPage.addCategorySubmitButton.click();
        expectedTestData = "Category is added successfully!";
        actualTestData = adminPage.addCategorySuccessfulAlert.getText();
        Assert.assertEquals(actualTestData,expectedTestData, "New category is NOT added");
        Assert.assertTrue(adminPage.addCategorySuccessfulAlert.isDisplayed(),"New category is NOT added");
        ReusableMethods.waitFor(2);

    }

    public void userEditsToAddedCategoryAndVerifiesInCategorySection() {

        adminPage = new AdminPage();
        adminPage.categoriesSearchBox.sendKeys("Team112");
        adminPage.categoriesActionEditButton.click();
        Assert.assertTrue(adminPage.editCategoryUpdateButton.isEnabled(), "Category edit button is NOT active");
        adminPage.addCategoryNameBox.clear();
        adminPage.addCategoryNameBox.sendKeys("T112-Category Edited");
        adminPage.editCategoryUpdateButton.click();
        expectedTestData = "Category is updated successfully!";
        actualTestData = adminPage.addCategorySuccessfulAlert.getText();
        Assert.assertEquals(actualTestData,expectedTestData, "Category is NOT updated");
        Assert.assertTrue(adminPage.editCategorySuccessfulAlert.isDisplayed(), "Category is NOT updated");
        ReusableMethods.waitFor(2);

    }

    public void userDeletesToAddedCategoryAndVerifiesInCategorySection() {

        adminPage = new AdminPage();
        adminPage.categoriesSearchBox.sendKeys("T112-Category Edited");
        Assert.assertTrue(adminPage.categoriesActionDeleteButton.isEnabled(), "Category delete button is NOT active");
        adminPage.categoriesActionDeleteButton.click();
        Driver.getDriver().switchTo().alert().accept();
        expectedTestData = "Category is deleted successfully!";
        actualTestData = adminPage.addCategorySuccessfulAlert.getText();
        Assert.assertEquals(actualTestData,expectedTestData, "Category is NOT deleted");
        Assert.assertTrue(adminPage.categoriesDeletedSuccessfulAlert.isDisplayed(),"Category is NOT deleted");
        ReusableMethods.waitFor(2);

    }
}