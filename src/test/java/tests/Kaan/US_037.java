package tests.Kaan;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class US_037 {

   /*
After logging in as an admin,
I should be able to verify that I can access the admin account profile settings screen to make changes to the profile information
  */
AdminPage adminPage = new AdminPage();

    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void adminAccountProfileSettingsTest (){
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        ReusableMethods.waitFor(2);
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        ReusableMethods.waitFor(3);
        adminPage.adminLogInButton.click();
        ReusableMethods.waitFor(2);

        adminPage.adminDropDownButton.click();
        adminPage.changeAdminPassword.click();


        ReusableMethods.waitFor(3);
        Driver.closeDriver();


    }
}
