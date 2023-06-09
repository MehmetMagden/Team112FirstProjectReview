package tests.Bahadir;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Set;

public class US_40 extends TestBaseRapor {




    AdminPage adminPage = new AdminPage();

    @Test
    public void adminPanel() {

        extentTest = extentReports.createTest("TC40_01", "User Navigates To Admin  Panel");

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();

        String expectedTitle = "Admin Panel";
        String actualTitle = Driver.getDriver().getTitle();

        extentTest.pass("Verify, user sees the Admin Panel page");

        Assert.assertEquals(expectedTitle, actualTitle);

        extentTest.info("Admin Dashboard is visible");

        Assert.assertTrue(adminPage.adminDashboardVisibility.isDisplayed());


    }

    @Test
    public void dropdownArrowSymbol() {

        extentTest = extentReports.createTest("TC40_02", "User Navigates To Admin  Panel");

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();

        extentTest.pass("Verify, user sees the Admin Panel page");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("adminDashboardUrl"));
        ReusableMethods.waitFor(2);
        js.executeScript("window.scrollBy(0,10000)");


        extentTest.info("dropDownArrowsButton is clickable");

        Assert.assertTrue(adminPage.dropdownArrowSymbolButtonInAdminPage.isEnabled());

    }

    @Test
    public void visitWebSite() {


        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();
        ReusableMethods.waitFor(5);


        String firstWH=Driver.getDriver().getWindowHandle();
        String secondWH="";

        adminPage.visitWebsiteButtonAtTheTopOfAdminPage.click();
        Set<String> allWH=Driver.getDriver().getWindowHandles();
        for (String each:allWH
        ) {
            if(!each.equals(firstWH)){
                secondWH=each;
            }
        }
        Driver.getDriver().switchTo().window(secondWH);

        String expectedUrl = "https://qa.tripandway.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        extentTest.pass("Verify, user sees the home page");

        Assert.assertEquals(actualUrl,expectedUrl);



    }
}