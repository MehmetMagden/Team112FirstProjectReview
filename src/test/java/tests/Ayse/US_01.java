package tests.Ayse;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_01 extends TestBaseRapor {

    HomePage homePage=new HomePage();
    BasePage basePage=new BasePage();
//**** there should be info steps for the test steps
//**** There is no assertion at the end ( for lines 29-30)

    @Test
    public void userSeeHomepage(){

        extentTest=extentReports.createTest("TC0101","user see homepage");
        homePage=new HomePage();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        String actualUrl=Driver.getDriver().getCurrentUrl();
        String expectedUrl="https://qa.tripandway.com/";
        Assert.assertTrue(actualUrl.equals(expectedUrl));
        extentTest.pass("User can access home page");
        homePage.homeButtonInHeader.isDisplayed();
        homePage.homeButtonInHeader.click();
        extentTest.info("Home button in header sectin on homepage is clickable");
        Driver.closeDriver();



    }



}
