package tests.Mustafa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PackagesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_25 {
    /*

TC_25_01	As a user, I should access my Dashboard
            1) User navigates to the main page after logging in
			2) User clicks the Dashboard link. URL changed.
			3) User should have the same URL: https://qa.tripandway.com/traveller/dashboard

TC_25_02	I should be able to navigate to "Payment History" page and see my latest payment.
            1) User navigates to Payment History page. URL changed.
			2) User should see the package name on the list (e.g., Bangkok)
     */

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    DashboardPage dashboardPage = new DashboardPage();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl")); // navigate to homepage
        basePage.acceptCookies();
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void TC_25_01_customerLogin() {

        loginPage.loginPageLoginButton2.click();
        loginPage.loginPageEmailAddressTextBox.sendKeys(ConfigReader.getProperty("userLoginEmailCorrect"));
        loginPage.loginPagePasswordBox.sendKeys(ConfigReader.getProperty("userLoginPasswordCorrect"));
        ReusableMethods.waitFor(2);
        loginPage.loginPageLoginButton.click();

        dashboardPage.paymentHistory.click();

        WebElement bangkokPackageVisibility = Driver.getDriver().findElement(By.xpath("//tbody/tr[2]/td[6]"));
        String actualText = bangkokPackageVisibility.getText();
        System.out.println(actualText);
        String expectedText = "Bangkok";
        Assert.assertTrue(actualText.contains(expectedText));

    }
}

