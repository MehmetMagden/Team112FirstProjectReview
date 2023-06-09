package tests.Muhammed;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import javax.lang.model.element.Name;

public class US_020 extends TestBaseRapor {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void US020_TC01AccountLoginAndEditionProfile(){

        //User access to home page
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        String ActualURL = Driver.getDriver().getCurrentUrl();
        String ExpectingURL = "https://qa.tripandway.com/";
        Assert.assertTrue(ActualURL.contains(ExpectingURL));

        basePage.acceptCookies();
        ReusableMethods.waitFor(2);

        loginPage.loginButtonHomePage.click();
        loginPage.loginPageEmailAddressTextBox.sendKeys("team112strong@gmail.com");
        loginPage.loginPagePasswordBox.sendKeys("Team112!");
        loginPage.loginPageLoginButton.submit();
        loginPage.UpdateProfile.click();
        loginPage.Name.clear();
        loginPage.Name.sendKeys("King ");
        loginPage.Submit.submit();
        ReusableMethods.waitFor(4);

    }


}
