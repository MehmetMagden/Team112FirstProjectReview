package tests.Bahadir;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_05 {


    BasePage footerSection = new BasePage();


    @Test
    public void visibilityOfLatestPackagesSectionInTheFooter() {

        BasePage footerSection = new BasePage();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        js.executeScript("window.scrollBy(0,10000)");
        ReusableMethods.waitFor(2);

        Assert.assertTrue(footerSection.latestPackagesInFooter.isDisplayed());
        Assert.assertTrue(footerSection.testDenemeButtonInFooter.isDisplayed());
        Assert.assertTrue(footerSection.fiveDayCaliforniaButtonInLatestPackagesInFooter.isDisplayed());
        Assert.assertTrue(footerSection.sevenDaysInSalinaIslandButtonInLatestPackagesInFooter.isDisplayed());
        Assert.assertTrue(footerSection.threeDaysInBangkokButtonInLatestPackagesInFooter.isDisplayed());
        Assert.assertTrue(footerSection.sevenDaysInIstanbulButtonInLatestPackagesInFooter.isDisplayed());

    }

    @Test
    public void clickabilityOfLatestPackagesSectionInTheFooter() {

        BasePage footerSection = new BasePage();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        js.executeScript("window.scrollBy(0,10000)");
        ReusableMethods.waitFor(2);

        Assert.assertTrue(footerSection.latestPackagesInFooter.isEnabled());
        Assert.assertTrue(footerSection.testDenemeButtonInFooter.isEnabled());
        Assert.assertTrue(footerSection.fiveDayCaliforniaButtonInLatestPackagesInFooter.isEnabled());
        Assert.assertTrue(footerSection.threeDaysInBangkokButtonInFooter.isEnabled());
        Assert.assertTrue(footerSection.sevenDaysInSalinaIslandButtonInFooter.isEnabled());
        Assert.assertTrue(footerSection.secondFiveDayCaliforniaButtonInLatestPackages.isEnabled());


    }


}