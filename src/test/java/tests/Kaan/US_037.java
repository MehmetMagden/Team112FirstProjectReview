package tests.Kaan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;


public class US_037 {

   /*
After logging in as an admin,
I should be able to verify that I can access the admin account profile settings screen to make changes to the profile information
  */
    AdminPage adminPage = new AdminPage();
    @Test
    public void adminAccountProfileSettingsTest (){
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));

        adminPage.adminLoginEmailAdressTextBox.sendKeys(new CharSequence[]{ConfigReader.getProperty("adminLoginEmailValid")});
        adminPage.adminLogInPasswordTextBox.sendKeys(new CharSequence[]{ConfigReader.getProperty("adminLoginPasswordValid")});
        adminPage.adminLogInButton.click();
        adminPage.adminDropDownButton.click();

        String expectedWordEditProfile = "Edit Profile";
        String actualWordChangePassword = adminPage.changeAdminPassword.getText();

        Assert.assertTrue(actualWordChangePassword.contains(expectedWordEditProfile));
       //Test will fail as there is no edit profile header on the drop-down menu

        Driver.closeDriver();


    }
}
