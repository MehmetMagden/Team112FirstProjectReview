package tests.Kaan;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_038 extends TestBaseRapor {
    AdminPage adminPage = new AdminPage();
    Actions actions = new Actions(Driver.getDriver());

    /*After logging in as an admin,
     I should be able to verify that I can access
     the admin account password change screen to change the password
     */

    @Test
    public void adminAccountChangePasswordTest(){

//***** after loggin as an admin I think instead of "user" we should use "admin" word in description
        extentTest = extentReports.createTest("TC38", "User Navigates To Change password");




        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));

        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));

//***** in coding, it is not advised to use hard-waits like "ReusableMethods.waitFor".
// instead we should use explicitly waits

        ReusableMethods.waitFor(2);
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        ReusableMethods.waitFor(3);
        adminPage.adminLogInButton.click();
        ReusableMethods.waitFor(2);

        adminPage.adminDropDownButton.click();
        ReusableMethods.waitFor(2);
        adminPage.changeAdminPassword.click();


        String expectedWordChangePassword = "Change Password";
        String actualWordEditProfile = adminPage.changeAdminPassword.getText();
        Assert.assertEquals(actualWordEditProfile,expectedWordChangePassword);
        extentTest.fail("When user access the change password header it takes you to the edit profile section");//Test failed as NO "Change Password" screen








       //Test will fail as when you click the change password header it takes you to the edit profile section

        ReusableMethods.waitFor(3);
        Driver.closeDriver();


        }


    }

