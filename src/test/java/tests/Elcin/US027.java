package tests.Elcin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US027 extends TestBaseRapor {
    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));


    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

    @Test
    public void TC027_01adminDashboardFeatures() {
        extentTest = extentReports.createTest("TC027_01", "User should be able to  view the following pages sequentially  : General Settings, Page Settings, Payment Settings, Dynamic Pages, Language, Web Site Section, and Email Template");
        AdminPage adminPage = new AdminPage();
        Actions actions = new Actions(Driver.getDriver());

        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        ReusableMethods.waitFor(2);
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        ReusableMethods.waitFor(3);
        adminPage.adminLogInButton.click();
        ReusableMethods.waitFor(2);

        actions.moveToElement(adminPage.adminDashboardGeneralSettingsButton).perform();
        adminPage.adminDashboardGeneralSettingsButton.click();
        ReusableMethods.waitFor(5);
        adminPage.adminDashboardGeneralSettingsButton.click();
        Assert.assertTrue(adminPage.adminDashboardGeneralSettingsButton.isEnabled());
        extentTest.pass("Dashboard General Settings-VIEWED");

        actions.moveToElement(adminPage.adminDashboardPageSettingsButton).perform();
        adminPage.adminDashboardPageSettingsButton.click();
        ReusableMethods.waitFor(5);
        adminPage.adminDashboardPageSettingsButton.click();
        Assert.assertTrue(adminPage.adminDashboardPageSettingsButton.isEnabled());
        extentTest.pass("Dashboard Page Settings-VIEWED");

        actions.moveToElement(adminPage.adminDashboardPaymentSettingsButton).perform();
        adminPage.adminDashboardPaymentSettingsButton.click();
        ReusableMethods.waitFor(5);
        adminPage.adminDashboardPaymentSettingsButton.click();
        Assert.assertTrue(adminPage.adminDashboardPaymentSettingsButton.isEnabled());
        extentTest.pass("Dashboard Payment Settings-VIEWED");

        actions.moveToElement(adminPage.adminDashboardDynamicPagesButton).perform();
        adminPage.adminDashboardDynamicPagesButton.click();
        ReusableMethods.waitFor(5);
        adminPage.adminDashboardDynamicPagesButton.click();
        Assert.assertTrue(adminPage.adminDashboardDynamicPagesButton.isEnabled());
        extentTest.pass("Dashboard Dynamic Page-VIEWED");

        actions.moveToElement(adminPage.adminDashboardLanguageButton).perform();
        adminPage.adminDashboardLanguageButton.click();
        ReusableMethods.waitFor(5);
        adminPage.adminDashboardLanguageButton.click();
        Assert.assertTrue(adminPage.adminDashboardLanguageButton.isEnabled());
        extentTest.pass("Dashboard Language-VIEWED");


        actions.moveToElement(adminPage.adminDashboardWebsiteSectionButton).perform();
        adminPage.adminDashboardWebsiteSectionButton.click();
        ReusableMethods.waitFor(5);
        adminPage.adminDashboardWebsiteSectionButton.click();
        Assert.assertTrue(adminPage.adminDashboardWebsiteSectionButton.isEnabled());
        extentTest.pass("Dashboard Website Section Settings-VIEWED");

        actions.moveToElement(adminPage.adminDashBoardEmailTemplateButton).perform();
        adminPage.adminDashBoardEmailTemplateButton.click();
        ReusableMethods.waitFor(5);
        adminPage.adminDashBoardEmailTemplateButton.click();
        Assert.assertTrue(adminPage.adminDashBoardEmailTemplateButton.isEnabled());
        extentTest.pass("Dashboard Email Template-VIEWED");


    }


}
