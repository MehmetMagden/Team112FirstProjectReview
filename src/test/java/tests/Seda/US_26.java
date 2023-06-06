package tests.Seda;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Date;

public class US_26 {

    /*
    I should be able to verify that I can access the administration panel of the website using admin credentials
     and view the admin dashboard.
     */

    AdminPage adminPage = new AdminPage();

    @Test
    public void viewTheAdminDashboard() {

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();

        String expectedTitle = "Admin Panel";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        Assert.assertTrue(adminPage.adminDashboardVisibility.isDisplayed());

        Driver.closeDriver();
    }

}
