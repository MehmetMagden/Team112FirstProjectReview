package tests.Ayse;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_34 extends TestBaseRapor {
/*
After logging in as an admin, I should be able to verify
that I can access the Orders section and view the invoice of any specific order.
 */

    AdminPage adminPage=new AdminPage();
    @Test(testName = "US34_TC01")
    public void adminAccessOrderSection(){
        adminPage=new AdminPage();
        extentTest=extentReports.createTest("US34TC01","Admin can access order section in admin page ");

        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        String expectedAdminLogInUrl="https://qa.tripandway.com/admin/login";
        String actualAdminLogInUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualAdminLogInUrl.equals(expectedAdminLogInUrl));
        extentTest.pass("User can access admin page");

        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();

        String expectedAdminDashboardUrl="https://qa.tripandway.com/admin/dashboard";
        String actualAdminDashboardUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualAdminDashboardUrl.equals(expectedAdminDashboardUrl));
        extentTest.pass("User can access admin login page");


        adminPage.orderButtonInAdminPanelOnAdminPage.click();

        String expectedOrderViewPageUrl="https://qa.tripandway.com/admin/order/view";
        String actualOrderViewPageUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualOrderViewPageUrl.equals(expectedOrderViewPageUrl));
        extentTest.pass("user can view admin order view page");


        adminPage.firstInvoiceInViewOrders.isDisplayed();
        extentTest.pass("user can displayed the invoice of any order");
        // there is no assertion here so instead of pass we can use info


        //10)User should close the page
        Driver.closeDriver();


    }

}
