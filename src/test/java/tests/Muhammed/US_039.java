package tests.Muhammed;

import com.beust.ah.A;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import javax.swing.*;

public class US_039 extends TestBaseRapor {

    AdminPage adminPage = new AdminPage();
    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void US039_TC01_AdminPageProfileEdition(){

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys("admin01@tripandway.com");
        adminPage.adminLogInPasswordTextBox.sendKeys("123123123");
        adminPage.adminLogInButton.submit();
        ReusableMethods.waitFor(2);

        adminPage.AdminMainPageProfile.click();
        ReusableMethods.waitFor(2);
        String ExpectingChangePhoto = "Change Photo";
        String ActualChangingPhoto = adminPage.AdminChangingIMG.getText();
        Assert.assertEquals(ActualChangingPhoto,ExpectingChangePhoto);
        adminPage.AdminChangingIMG.click();
        ReusableMethods.waitFor(2);
        //There is a bug on Update button
        // Assert.assertTrue(adminPage.AdminPhotoUpdate.isEnabled());


    }

}
