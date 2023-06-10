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


    @Test
    public void visibilityOfFeaturedPackagesSectionInTheFooter () {



        BasePage footerSection = new BasePage();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        js.executeScript("window.scrollBy(0,10000)");
        ReusableMethods.waitFor(2);



        Assert.assertTrue(footerSection.featuredPackagesInFooter.isDisplayed());
        Assert.assertTrue(footerSection.threeDaysInBuenosAiresButtonInFooter.isDisplayed());
        Assert.assertTrue(footerSection.tenDaysInBuenosAiresButtonInFooter.isDisplayed());
        Assert.assertTrue(footerSection.threeDaysInBangkokButtonInFooter.isDisplayed());
        Assert.assertTrue(footerSection.sevenDaysInSalinaIslandButtonInFooter.isDisplayed());
        Assert.assertTrue(footerSection.fiveDayCaliforniaButtonInFooter.isDisplayed());

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

        // NOTE: isEnabled test passed because of not being visible of 5 Day California. This situation was mentioned in bug report
    }












}
