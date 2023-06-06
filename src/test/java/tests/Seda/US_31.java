package tests.Seda;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.awt.dnd.DragGestureEvent;

public class US_31 {

    /*
    I should be able to login admin dashboard.

   I should be able to verify that in the Packages Section, I can add a new package and confirm that

   I should be able to confirm that the added package can be edited.

  */

    AdminPage adminPage = new AdminPage();
    Actions actions = new Actions(Driver.getDriver());
    @BeforeTest
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();

        }
    @Test
    public void  TC_31_AddPackagesToAdminDashboard(){

        String expectedTitle = "Admin Panel";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        adminPage.adminPagePackagesTab.click();
        adminPage.addPackages.click();






    }


}
