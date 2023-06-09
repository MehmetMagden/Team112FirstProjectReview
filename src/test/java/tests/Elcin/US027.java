package tests.Elcin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US027 {


    @Test
    public  void TC027_01adminDashboardFeatures(){
        AdminPage adminPage=new AdminPage();
        Actions actions=new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
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

        actions.moveToElement(adminPage.adminDashboardPageSettingsButton).perform();
        adminPage.adminDashboardPageSettingsButton.click();
        ReusableMethods.waitFor(5);
        adminPage.adminDashboardPageSettingsButton.click();
        Assert.assertTrue(adminPage.adminDashboardPageSettingsButton.isEnabled());

        actions.moveToElement(adminPage.adminDashboardPaymentSettingsButton).perform();
        adminPage.adminDashboardPaymentSettingsButton.click();
        ReusableMethods.waitFor(5);
        adminPage.adminDashboardPaymentSettingsButton.click();
        Assert.assertTrue(adminPage.adminDashboardPaymentSettingsButton.isEnabled());


        actions.moveToElement(adminPage.adminDashboardDynamicPagesButton).perform();
        adminPage.adminDashboardDynamicPagesButton.click();
        ReusableMethods.waitFor(5);
        adminPage.adminDashboardDynamicPagesButton.click();
        Assert.assertTrue(adminPage.adminDashboardDynamicPagesButton.isEnabled());

        actions.moveToElement(adminPage.adminDashboardLanguageButton).perform();
        adminPage.adminDashboardLanguageButton.click();
        ReusableMethods.waitFor(5);
        adminPage.adminDashboardLanguageButton.click();
        Assert.assertTrue(adminPage.adminDashboardPageSettingsButton.isEnabled());


        actions.moveToElement(adminPage.adminDashboardWebsiteSectionButton).perform();
        adminPage.adminDashboardWebsiteSectionButton.click();
        ReusableMethods.waitFor(5);
        adminPage.adminDashboardWebsiteSectionButton.click();
        Assert.assertTrue(adminPage.adminDashboardWebsiteSectionButton.isEnabled());


        actions.moveToElement(adminPage.adminDashBoardEmailTemplateButton).perform();
        adminPage.adminDashBoardEmailTemplateButton.click();
        ReusableMethods.waitFor(5);
        adminPage.adminDashBoardEmailTemplateButton.click();
        Assert.assertTrue(adminPage.adminDashBoardEmailTemplateButton.isEnabled());




        Driver.quitDriver();


}




}
