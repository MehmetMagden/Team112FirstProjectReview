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
        //As a user, admin should be able to access the Orders sections and view the invoice of any specific order.
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        String expectedAdminLogInUrl="https://qa.tripandway.com/admin/login";
        String actualAdminLogInUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualAdminLogInUrl.equals(expectedAdminLogInUrl));
        extentTest.pass("User can access admin page");

        //3)User should enter admin email adress to email box on the admin login page
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();

        //6)User should see admin dashboard url and expected url are the same
        String expectedAdminDashboardUrl="https://qa.tripandway.com/admin/dashboard";
        String actualAdminDashboardUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualAdminDashboardUrl.equals(expectedAdminDashboardUrl));
        extentTest.pass("User can access admin login page");
        //"7)User should click order button on admin dashboard page

        adminPage.orderButtonInAdminPanelOnAdminPage.click();

        //https://qa.tripandway.com/admin/order/view
        String expectedOrderViewPageUrl="https://qa.tripandway.com/admin/order/view";
        String actualOrderViewPageUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualOrderViewPageUrl.equals(expectedOrderViewPageUrl));
        extentTest.pass("user can view admin order view page");

        //8)User should see admin order view page's url and expected url are the same
        //"9)User should see the invoice of any specific order.
        adminPage.firstInvoiceInViewOrders.isDisplayed();
        extentTest.pass("user can displayed the invoice of any order");

        //10)User should close the page
        Driver.closeDriver();


    }

}
