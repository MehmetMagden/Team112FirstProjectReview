package tests.Seda;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.Date;

public class US_26 extends TestBaseRapor {

    /*
    I should be able to verify that I can access the administration panel of the website using admin credentials
     and view the admin dashboard.
     */

    AdminPage adminPage = new AdminPage();

    @Test
    public void viewTheAdminDashboard() {

        extentTest = extentReports.createTest("TC26",
                                              "User Navigates To Admin Dashboard to navigate Admin Panel");

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();

        String expectedTitle = "Admin Panel";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        extentTest.pass("Verify, user is in the Admin Panel page");

        Assert.assertTrue(adminPage.adminDashboardVisibility.isDisplayed());
        extentTest.pass("Verify, user can see Admin Panel items in the page");

        Driver.closeDriver();
    }
}
