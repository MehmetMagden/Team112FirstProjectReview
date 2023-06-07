package tests.Kaan;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_030 {
    AdminPage adminPage = new AdminPage();
    Actions actions = new Actions(Driver.getDriver());
@BeforeMethod
public void setup(){
    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
}
@AfterMethod
public void tearDown (){Driver.closeDriver();}
    @Test
    public void TC_30_01_adminLogin() {

        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        ReusableMethods.waitFor(2);
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        ReusableMethods.waitFor(3);
        adminPage.adminLogInButton.click();
        ReusableMethods.waitFor(2);




    }
    @Test
    public void TC_30_02_addNewPackage(){





    }
}