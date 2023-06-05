package tests.Ibrahim;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_032 extends TestBaseRapor {

    /*
    After logging in as an admin,
    I should be able to verify that I can access the Orders section and
    view all the orders placed.
     */

    AdminPage adminPage = new AdminPage();
    String actualTestData = "";
    String expectedTestData = "";

    @Test ()
    public void TC3201userNavigatesToAdminPage (){

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

    @Test
    public void TC3202userAccessOrdersSection () {

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

    @Test
    public void TC3203userViewAllPlacedOrder () {

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
}
