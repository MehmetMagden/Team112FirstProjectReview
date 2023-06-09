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
        js.executeScript("window.scrollBy(0,20000)");
        ReusableMethods.waitFor(2);
        Assert.assertTrue(BasePage.PrivacyPolicy.isDisplayed());


    }
}
