package tests.Mustafa;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PackagesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_24 {

/*
TC_24_01	I can log in as a customer/user.
            1) User open browser
			2) User navigates to the main page
			3) User clicks on THE Login link on the main page. (URL changed)
			4) User writes email address to Email Address Box
			5) User writes password to Password Box
			6) User clicks the Login Button. URL changed

TC_24_02	I can navigate to Packages page and select a package.
            1) User navigates to Packages page. URL changed.
			2) User selects/clicks a package of their choice. (Say Bangkok).
               User navigates to the corresponding page. URL changed.
			3) User's URL should be the same with the actual URL:

TC_24_03	I can pay for my selected package
            1) User decides the number of people for the trip using the drop-down menu.
			2) User clicks "Book Your Seat" button. URL changed
			3) User clicks "Pay with Card"
			4) User enters card number in the corresponding field 4242424242424242
			5) User enters the expiry date of the card in the corresponding field: 11/24
			6) User enters the CCV number of the card in the corresponding field: 111
			7) User approves payment by clicking the Pay button
			8) User should see "Payment is successful" message. (URL changed.)
*/
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    PackagesPage packagesPage = new PackagesPage();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl")); // navigate to homepage
        basePage.acceptCookies();
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
    @Test
    public void TC_24_01_customerLogin(){

        loginPage.loginPageLoginButton2.click();
        loginPage.loginPageEmailAddressTextBox.sendKeys(ConfigReader.getProperty("userLoginEmailCorrect"));
        loginPage.loginPagePasswordBox.sendKeys(ConfigReader.getProperty("userLoginPasswordCorrect"));
        loginPage.loginPageLoginButton.click();

        String expectedText = "Dashboard";
        String actualText = loginPage.userDashboard.getText();
        Assert.assertTrue(actualText.contains(expectedText));

    }
    @Test
    public void TC_24_02_selectPackage(){
        Driver.getDriver().get(ConfigReader.getProperty("packagesUrl"));

        basePage.acceptCookies();
        packagesPage.buenosAiresPackageInPackagesPage2.click();

    }

    @Test
    public void TC_24_03_payForPackage(){
        Driver.getDriver().get(ConfigReader.getProperty("bangkokPackageUrl"));
        basePage.acceptCookies();

    }
}