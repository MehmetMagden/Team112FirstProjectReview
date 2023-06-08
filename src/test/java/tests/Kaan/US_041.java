package tests.Kaan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_041 {
    AdminPage adminPage = new AdminPage();
    Actions actions = new Actions(Driver.getDriver());
   /*
   I should be able to log out from the admin account and return to the main screen.
    */
    @Test
    public void LogoutReturnToMainPaigeTest(){

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();

        adminPage.adminDropDownButton.click();
        adminPage.adminLogoutButton.click();
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();

        adminPage.visitWebsiteButtonAtTheTopOfAdminPage.click();


        ReusableMethods.waitFor(2);
        Driver.closeDriver();




    }

}
