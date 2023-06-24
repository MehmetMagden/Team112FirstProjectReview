package tests.Muhammed;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_011 extends TestBaseRapor {

//**** it test methods should start with " extentTest = extentReports.createTest("TC0314", "description");
//**** for each step we entered excel file there should be extentTest.info explaining
//**** for each assertion we should enter info with extentTest.pass code
// I believe this code won't create any report


    @Test
    public void US011_TC01PrivacyPolicyPageIsVisible(){
        BasePage basePage= new BasePage();


        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        String ActualURL = Driver.getDriver().getCurrentUrl();
        String ExpectingURL = "https://qa.tripandway.com/";
        Assert.assertTrue(ActualURL.contains(ExpectingURL));
        //User access to home page...

        basePage.acceptCookies();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
//**** to scroll to somewhere I prefer using a webelement instead of using numbers, When we use numbers it may not work on other computers
        js.executeScript("window.scrollBy(0,20000)");

//***** in coding, it is not advised to use hard-waits like "ReusableMethods.waitFor".
// instead we should use explicitly waits
//**** (but if is because of computer or connection problems it is acceptable)
        ReusableMethods.waitFor(2);
        Assert.assertTrue(BasePage.PrivacyPolicy.isDisplayed());


    }
}
