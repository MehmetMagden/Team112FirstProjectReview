package tests.Kaan;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;




public class US_037  extends TestBaseRapor {


   /*
After logging in as an admin,
I should be able to verify that I can access the admin account profile settings screen to make changes to the profile information
  */
AdminPage adminPage = new AdminPage();

    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void adminAccountProfileSettingsTest (){

//**** instead of creating two extentTest object, I think we should create only one
//when we create two of them, I think system will choose the last one

//**** still for everystep we should enter an explaining by  extentTest.info  code ***************


        extentTest = extentReports.createTest("TC37", "User Navigates To Edit profile");

        extentTest = extentReports.createTest("TC37", "User Navigates To Edit Password");


        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        ReusableMethods.waitFor(2);
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        ReusableMethods.waitFor(3);
        adminPage.adminLogInButton.click();
        ReusableMethods.waitFor(2);

        adminPage.adminDropDownButton.click();




        String expectedWordEditProfile = "Edit Profile";
        String actualWordChangePassword = adminPage.changeAdminPassword.getText();
        Assert.assertEquals(actualWordChangePassword,expectedWordEditProfile);
        extentTest.fail("When user clicks the drop down there is no access to the Edit profile header");

//**** if there is a bug, we do not need to write the code. Just creating bug report is enough. Still, writing helps us to gain experience :D
// furthermore, writing an explaining here about the situation helps readers like me :D

        ReusableMethods.waitFor(3);
        Driver.closeDriver();


    }
}
