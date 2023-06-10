package tests.Mustafa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.UserDashboardPage;
import pages.LoginPage;
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
    UserDashboardPage userDashboardPage = new UserDashboardPage();

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

        loginPage.loginAsUser();  // Log in to a user account
        userDashboardPage.paymentHistory.click();

        WebElement purchaseConfirmation = Driver.getDriver().findElement(By.xpath("//tbody/tr[2]/td[7]/a[1]"));
        Assert.assertTrue(purchaseConfirmation.isDisplayed());

    }
}

