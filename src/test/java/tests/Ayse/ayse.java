package tests.Ayse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

import java.util.ArrayList;
import java.util.List;

public class ayse {

    HomePage homePage = new HomePage();
    BasePage basePage = new BasePage();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);

    }

    @Test(priority = 1)
    public void userCanSeeTheFunctionsAboutOurServicesSection() {
        homePage = new HomePage();
        basePage = new BasePage();
        basePage.acceptCookiesButton.click();
        ReusableMethods.waitFor(5);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.ourServicesAreaOnHomepage);
        ReusableMethods.waitFor(3);
        //   Assert.assertTrue(homePage.ourServicesAreaOnHomepage.isDisplayed());

        //   ReusableMethods.waitFor(3);
        //   Assert.assertTrue(homePage.internationalTourElementOnHomePage.isDisplayed());

        //   ReusableMethods.waitFor(3);
        //   Assert.assertTrue(homePage.adventureTourElementOnHomePage.isDisplayed());

        //   ReusableMethods.waitFor(3);
        //   Assert.assertTrue(homePage.cultureTourElementOnHomePage.isDisplayed());

        //   ReusableMethods.waitFor(3);
        //   Assert.assertTrue(homePage.bussinessTourElementOnHomePage.isDisplayed());

        //   ReusableMethods.waitFor(3);
        //   Assert.assertTrue(homePage.healthTourElementOnHomePage.isDisplayed());

        //   ReusableMethods.waitFor(3);
        //   Assert.assertTrue(homePage.religiousTourElementOnHomePage.isDisplayed());

        List<WebElement> listOfOurServicesWebElement = new ArrayList<>();
        listOfOurServicesWebElement.add(homePage.ourServicesAreaOnHomepage);
        listOfOurServicesWebElement.add(homePage.internationalTourElementOnHomePage);
        listOfOurServicesWebElement.add(homePage.adventureTourElementOnHomePage);
        listOfOurServicesWebElement.add(homePage.cultureTourElementOnHomePage);
        listOfOurServicesWebElement.add(homePage.bussinessTourElementOnHomePage);
        listOfOurServicesWebElement.add(homePage.healthTourElementOnHomePage);
        listOfOurServicesWebElement.add(homePage.religiousTourElementOnHomePage);

        listOfVisibleWebElementTest(listOfOurServicesWebElement);


    }

    public void listOfVisibleWebElementTest(List<WebElement> list) {
        for (int i = 0; i < list.size(); i++) {
            ReusableMethods.waitFor(3);
            Assert.assertTrue(list.get(i).isDisplayed());

        }

    }
    //   public Object switchToWindowUrl(String actualUrl){
    //
    //       actualUrl = Driver.getDriver().getWindowHandle();
    //        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
    //        for (String handle : windowHandles) {
    //            if (!handle.equals(actualUrl)) {
    //                Driver.getDriver().switchTo().window(handle);
    //                break;
    //            }
    //        }
    //        String currentUrl= Driver.getDriver().getCurrentUrl();
    //        System.out.println(currentUrl);
    //        return currentUrl;
    //    }

    @AfterMethod
    public void tearDown() {

        Driver.closeDriver();

    }
}