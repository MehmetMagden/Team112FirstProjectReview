package tests.Ayse;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US_21 extends TestBaseRapor {

    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();
    @Test
    public void userCanViewPaymentHistory(){

         homePage=new HomePage();
         loginPage=new LoginPage();
        extentTest=extentReports.createTest("US21TC01","user can view payment history");
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://qa.tripandway.com/";
        Assert.assertTrue(actualUrl.equals(expectedUrl));
        extentTest.pass("User access the home page");
        homePage.logInButtonInHeader.click();
        String actualLogInPageUrl=Driver.getDriver().getCurrentUrl();
        String expectedLogInPageUrl="https://qa.tripandway.com/traveller/login";
        Assert.assertTrue(actualLogInPageUrl.equals(expectedLogInPageUrl));
        extentTest.pass("User can access login page");
        loginPage.cookiesAcceptButton.click();
        loginPage.loginPageEmailAddressTextBox.sendKeys(ConfigReader.getProperty("userLoginEmailCorrect"));
        loginPage.loginPagePasswordBox.sendKeys(ConfigReader.getProperty("userLoginPasswordCorrect"));
        loginPage.loginPageLoginButton.click();
        String expectedLoginDashboardUrl="https://qa.tripandway.com/traveller/dashboard";
        String actualLoginDashboardUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualLoginDashboardUrl.equals(expectedLoginDashboardUrl));
        extentTest.pass("User can access the login dashboard");
        loginPage.paymentHistoryButtonInUserLoginPage.click();
        String actualPaymentHistoryUrl=Driver.getDriver().getCurrentUrl();
        String expectedPaymentHistroyUrl="https://qa.tripandway.com/traveller/order";
        Assert.assertTrue(actualPaymentHistoryUrl.equals(expectedPaymentHistroyUrl));
        extentTest.pass("User can access payment history area");
        loginPage.viewAllPaymentElementInPaymentElementOnLoginPage.isDisplayed();
        extentTest.pass("User can view all payment element ");
        Driver.closeDriver();



    }






}
