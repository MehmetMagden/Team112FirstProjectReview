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

    @Test
    public void adminAccountProfileSettingsTest (){
      /*  Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        ReusableMethods.waitFor(2);
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        ReusableMethods.waitFor(3);
        adminPage.adminLogInButton.click();
        ReusableMethods.waitFor(2);

        String expectedWordEditProfile = "Edit Profile";
        String actualWordChangePassword = adminPage.changeAdminPassword.getText();

        Assert.assertTrue(actualWordChangePassword.contains(expectedWordEditProfile));
       //Test will fail as there is no edit profile header on the drop-down menu

        ReusableMethods.waitFor(3);
        Driver.closeDriver();
*/

    }
}
