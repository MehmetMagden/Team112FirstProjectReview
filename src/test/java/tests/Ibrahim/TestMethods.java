package tests.Ibrahim;

import org.testng.Assert;
import pages.AdminPage;
import pages.BasePage;
import pages.DestinationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TestMethods extends TestBaseRapor{
    BasePage basePage = new BasePage();
    DestinationsPage destinationsPage = new DestinationsPage();
    AdminPage adminPage = new AdminPage();
    String actualTestData = "";
    String expectedTestData = "";

    public void TC1301userNavigatesAndVerifiesToDestinationPage(){
        extentTest = extentReports.createTest("TC1301", "User Navigates To Destination Page");
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        extentTest.info("User navigates to main page");
        ReusableMethods.waitForClickablility(basePage.acceptCookiesButton,5);
        basePage.acceptCookiesButton.click();
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("tripAndWayUrl");
        Assert.assertEquals(actualTestData, expectedTestData);
        extentTest.pass("Verify, if user can access to main page");
        Assert.assertTrue(basePage.homePageDestinationsButton.isEnabled());
        ReusableMethods.waitForClickablility(basePage.homePageDestinationsButton,5);
        basePage.homePageDestinationsButton.click();
        extentTest.info("User navigates to Destination page");
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("destinationsUrl");
        Assert.assertEquals(actualTestData, expectedTestData);
        extentTest.pass("Verify, if user can access to Destination page");
    }

    public void TC1302userVerifiesDestinationPageVisibleAndActive() {
        basePage = new BasePage();
        destinationsPage =new DestinationsPage();
        extentTest = extentReports.createTest("TC1302","User Verifies Destination Page Visible And Active");
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        extentTest.info("User navigates to main page");
        ReusableMethods.waitForClickablility(basePage.acceptCookiesButton,10);
        basePage.acceptCookiesButton.click();
        ReusableMethods.waitFor(2);
        basePage.homePageDestinationsButton.click();
        extentTest.info("User navigates to Destination page");
        ReusableMethods.waitForVisibility(destinationsPage.destinationsImageWebElement,5);
        Assert.assertTrue(destinationsPage.destinationsImageWebElement.isDisplayed());
        extentTest.pass("Verify, if Destination page is visible");
        Assert.assertTrue(destinationsPage.destinationsFirstPackageWebElement.isEnabled());
        extentTest.pass("Verify, if Destination page is active");
    }

    public void TC3201userNavigatesAndVerifiesToAdminPage(){

        extentTest = extentReports.createTest("TC3201", "User Navigates To Admin Page");
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        extentTest.info("User navigates to Admin page");
        ReusableMethods.waitFor(2);
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();
        extentTest.info("User writes admin credential and login to admin dashboard ");
        ReusableMethods.waitFor(2);
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminDashboardUrl");
        Assert.assertEquals(actualTestData, expectedTestData);
        extentTest.pass("Verify, if user can access to Admin Dashboard page");
        ReusableMethods.waitFor(2);
    }

    public void TC3202userAccessAndVerifiesOrdersSection() {

        extentTest = extentReports.createTest("TC3202", "User should access the Orders section");
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        extentTest.info("User navigates to Admin page");
        ReusableMethods.waitFor(2);
        adminPage = new AdminPage();
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();
        extentTest.info("User writes admin credential and login to admin dashboard ");
        ReusableMethods.waitFor(2);
        adminPage.adminDashboardOrderButton.click();
        extentTest.info("User navigates to Orders page");
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminOrdersPageUrl");
        Assert.assertEquals(actualTestData,expectedTestData);
        extentTest.pass("Verify, if Orders page url same with test data");
        actualTestData = adminPage.viewOrdersWebElement.getText();
        expectedTestData = "View Orders";
        Assert.assertTrue(actualTestData.contains(expectedTestData));
        extentTest.pass("Verify, if user can access Orders section in Admin Dashboard");
        ReusableMethods.waitFor(2);
    }

    public void TC3203userViewAndVerifiesAllPlacedOrder() {

        extentTest = extentReports.createTest("TC3203", "User should view all placed orders");
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        extentTest.info("User navigates to Admin page");
        ReusableMethods.waitFor(2);
        adminPage = new AdminPage();
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();
        extentTest.info("User writes admin credential and login to admin dashboard ");
        String ordersAmount = adminPage.adminMainPageCompletedOrdersWebElement.getText();
        ReusableMethods.waitFor(2);
        adminPage.adminDashboardOrderButton.click();
        extentTest.info("User navigates to Orders page");
        ReusableMethods.waitFor(2);
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminOrdersPageUrl");
        Assert.assertEquals(actualTestData,expectedTestData);
        extentTest.pass("Verify, if Orders page url same with test data");
        Assert.assertTrue(adminPage.allOrdersWebElement.isDisplayed());
        actualTestData = adminPage.allOrdersWebElement.getText();
        Assert.assertTrue(actualTestData.contains(ordersAmount));
        extentTest.pass("Verify, if user can view all placed orders");
        ReusableMethods.waitFor(2);
    }

    public void TC3501userNavigatesAndVerifiesToAdminPage(){

        extentTest = extentReports.createTest("TC3501", "User Navigates To Admin Page");
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        extentTest.info("User navigates to Admin page");
        ReusableMethods.waitFor(2);
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();
        extentTest.info("User writes admin credential and login to admin dashboard ");
        ReusableMethods.waitFor(2);
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminDashboardUrl");
        Assert.assertEquals(actualTestData, expectedTestData);
        extentTest.pass("Verify, if user can access to Admin Dashboard page");
        ReusableMethods.waitFor(2);
    }

    public void TC3502userNavigatesAndVerifiesToSubscribersPage() {

        extentTest = extentReports.createTest("TC3502", "User Navigates and Verifies to Subscribers Page");
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        extentTest.info("User navigates to Admin page");
        ReusableMethods.waitFor(2);
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();
        extentTest.info("User writes admin credential and login to admin dashboard ");
        ReusableMethods.waitFor(2);
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminDashboardUrl");
        Assert.assertEquals(actualTestData, expectedTestData);
        extentTest.pass("Verify, if user can access to Admin Dashboard page");
        ReusableMethods.waitFor(2);
        adminPage.subscriberButton.click();
        adminPage.allSubscribersButton.click();
        ReusableMethods.waitFor(2);
        extentTest.info("User navigates to Subscribers page");
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminSubscribersPageUrl");
        Assert.assertEquals(actualTestData,expectedTestData);
        extentTest.pass("Verify, if user can access to Subscribers page");
        Assert.assertTrue(adminPage.viewSubscribersWebElement.isDisplayed());
        extentTest.pass("Verify, if Subscribers page is active");
        ReusableMethods.waitFor(2);
    }

    public void TC3503userAccessAndVerifiesAllNewsletterSubscribers() {
        extentTest = extentReports.createTest("TC3503", "User Access and Verifies All Newsletter Subscribers");
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        extentTest.info("User navigates to Admin page");
        ReusableMethods.waitFor(2);
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();
        extentTest.info("User writes admin credential and login to admin dashboard ");
        ReusableMethods.waitFor(2);
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminDashboardUrl");
        Assert.assertEquals(actualTestData, expectedTestData);
        extentTest.pass("Verify, if user can access to Admin Dashboard page");
        ReusableMethods.waitFor(2);
        adminPage.subscriberButton.click();
        adminPage.allSubscribersButton.click();
        ReusableMethods.waitFor(2);
        extentTest.info("User navigates to Subscribers page");
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminSubscribersPageUrl");
        Assert.assertEquals(actualTestData,expectedTestData);
        extentTest.pass("Verify, if user can access to Subscribers page");
        Assert.assertTrue(adminPage.viewSubscribersWebElement.isDisplayed());
        Assert.assertTrue(adminPage.allSubscribersButton.isEnabled());
        extentTest.pass("Verify, if Subscribers page is active");
        ReusableMethods.waitFor(2);
        actualTestData = adminPage.allSubscribersWebElement.getText();
        expectedTestData ="Showing 1 to 10 of";
        Assert.assertTrue(actualTestData.contains(expectedTestData));
        extentTest.pass("Verify, if user can see all newsletter subscribers list");
        ReusableMethods.waitFor(2);
    }
}
