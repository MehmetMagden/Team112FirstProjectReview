package tests.Bahadir;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_04 extends TestBaseRapor {

    BasePage footerSection = new BasePage();

//**** there could be an explaining before tests

    @Test
    public void visibilityOfFeaturedPackagesSectionInTheFooter () {



        BasePage footerSection = new BasePage();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
//**** instead of using numbers to scroll somewhere it is adviced to use a webelement, so I will also work on other computers
        js.executeScript("window.scrollBy(0,10000)");
//**** Using hard wait is not very popular in coding because no matter what it will wait for the entered time
        ReusableMethods.waitFor(2);



        Assert.assertTrue(footerSection.featuredPackagesInFooter.isDisplayed());
        Assert.assertTrue(footerSection.threeDaysInBuenosAiresButtonInFooter.isDisplayed());
        Assert.assertTrue(footerSection.tenDaysInBuenosAiresButtonInFooter.isDisplayed());
        Assert.assertTrue(footerSection.threeDaysInBangkokButtonInFooter.isDisplayed());
        Assert.assertTrue(footerSection.sevenDaysInSalinaIslandButtonInFooter.isDisplayed());
        Assert.assertTrue(footerSection.fiveDayCaliforniaButtonInFooter.isDisplayed());

//**** there should be an explaining here for the report

    }

    @Test
    public void clickablityOfFeaturedPackagesSectionInTheFooter () {

        BasePage footerSection = new BasePage();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        js.executeScript("window.scrollBy(0,10000)");
        ReusableMethods.waitFor(2);

        Assert.assertTrue(footerSection.threeDaysInBuenosAiresButtonInFooter.isEnabled());
        Assert.assertTrue(footerSection.tenDaysInBuenosAiresButtonInFooter.isEnabled());
        Assert.assertTrue(footerSection.threeDaysInBangkokButtonInFooter.isEnabled());
        Assert.assertTrue(footerSection.sevenDaysInSalinaIslandButtonInFooter.isEnabled());
        Assert.assertTrue(footerSection.fiveDayCaliforniaButtonInFooter.isEnabled());


    }












}
