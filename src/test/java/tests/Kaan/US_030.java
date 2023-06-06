package tests.Kaan;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_030 {
    AdminPage adminPage = new AdminPage();
    Actions actions=new Actions(Driver.getDriver());
    @Test(priority = 1)
    public void adminLogin() {
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));

        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        ReusableMethods.waitFor(2);
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        ReusableMethods.waitFor(3);
        adminPage.adminLogInButton.click();
        ReusableMethods.waitFor(2);

        actions.moveToElement(adminPage.adminDashboardPackagesButton).perform();
        adminPage.adminDashboardPackagesButton.click();



    }
}
