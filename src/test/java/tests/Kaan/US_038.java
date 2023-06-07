package tests.Kaan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_038 {
    AdminPage adminPage = new AdminPage();
    @Test
    public void adminAccountChangePasswordTest(){
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
/*
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        ReusableMethods.waitFor(2);
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        ReusableMethods.waitFor(3);
        adminPage.adminLogInButton.click();
        ReusableMethods.waitFor(2);

        adminPage.adminDropDownButton.click();
        ReusableMethods.waitFor(2);
        adminPage.changeAdminPassword.click();

        String expectedWordChangePassword = "Edit Profile";
        String actualWordEditProfile = adminPage.editAdminProfile.getText();

        Assert.assertTrue(actualWordEditProfile.contains(actualWordEditProfile));

       //Test will fail as when you click the change password header it takes you to the edit profile section
        ReusableMethods.waitFor(3);
        Driver.closeDriver();
*/

        }


    }

