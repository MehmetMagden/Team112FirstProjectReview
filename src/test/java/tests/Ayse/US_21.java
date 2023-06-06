package tests.Ayse;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_21 {

    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();
    @Test
    public void userCanViewPaymentHistory(){
         homePage=new HomePage();
         loginPage=new LoginPage();
        //1)User should access to the homepage
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://qa.tripandway.com/";
        Assert.assertTrue(actualUrl.equals(expectedUrl));


//3)User should click login button on the homepage
        homePage.logInButtonInHeader.click();
        String actualLogInPageUrl=Driver.getDriver().getCurrentUrl();
        String expectedLogInPageUrl="https://qa.tripandway.com/traveller/login";
        Assert.assertTrue(actualLogInPageUrl.equals(expectedLogInPageUrl));

        loginPage.cookiesAcceptButton.click();

    //5)User should enter valid email to email box on the login page
       loginPage.loginPageEmailAddressTextBox.sendKeys(ConfigReader.getProperty("userLoginEmailCorrect"));
       loginPage.loginPagePasswordBox.sendKeys(ConfigReader.getProperty("userLoginPasswordCorrect"));
       loginPage.loginPageLoginButton.click();

    //6)User should enter valid password to password box on the login page
    //7)User should click login button on the login page
    //8)User should see that the login dashboard url and the expected url are the same.
    //9)User should click the payment history's button
    //10)User should see payment history's url and expected url are the same
    //11)User should see view all the payments on the payment history page
    //12)User should close the page




    }






}
