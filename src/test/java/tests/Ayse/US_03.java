package tests.Ayse;


import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.PackagesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class US_03 {
    private HomePage homePage = new HomePage();
    private BasePage basePage = new BasePage();


    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);

    }

    //User should be able to see the functions about hero area in the body section of the Home page
    @Test(priority = 2)
    public void userCanSeeTheFunctionsAboutHeroArea() {
        homePage = new HomePage();
        basePage = new BasePage();
        basePage.acceptCookiesButton.click();
        homePage.exploreTheWorldArea.isDisplayed();
        ReusableMethods.waitFor(5);
        ReusableMethods.waitForVisibility(homePage.theWorldIsSoBeautifulAreaOnHomepage, 15);
        Assert.assertTrue(homePage.theWorldIsSoBeautifulAreaOnHomepage.isDisplayed());

        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.readMoreButtonUnderTheWorldIsSoBeautifulText.isDisplayed());

        homePage.sliderOnRightSideOfHeroArea.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.salinaIslandAreaOnHomepage.isDisplayed());

        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.readMoreButtonUnderSalinaIslandAreaText.isDisplayed());

        ReusableMethods.waitFor(3);
        homePage.sliderOnRightSideOfHeroArea.click();

        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.exploreTheWorldArea.isDisplayed());


        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.readMoreButtonUnderExploreTheWorldAreaText.isDisplayed());

        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.sliderOnRightSideOfHeroArea.isDisplayed());

        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.sliderOnLeftSideOfHeroArea.isDisplayed());

    }

    public void listOfVisibleWebElementTest(List<WebElement> list, WebElement areaOfPage) {

        ReusableMethods.waitFor(5);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", areaOfPage);
        for (int i = 0; i < list.size(); i++) {
            ReusableMethods.waitFor(3);
            Assert.assertTrue(list.get(i).isDisplayed());

        }

    }

    //User should be able to see the functions about "Our Services" section in the body section of the Homepage
    @Test(priority = 1)
    public void userCanSeeTheFunctionsAboutOurServicesSection() {
        homePage = new HomePage();
        basePage = new BasePage();
        basePage.acceptCookiesButton.click();

        List<WebElement> listOfOurServicesWebElement = new ArrayList<>();
        listOfOurServicesWebElement.add(homePage.ourServicesAreaOnHomepage);
        listOfOurServicesWebElement.add(homePage.internationalTourElementOnHomePage);
        listOfOurServicesWebElement.add(homePage.adventureTourElementOnHomePage);
        listOfOurServicesWebElement.add(homePage.cultureTourElementOnHomePage);
        listOfOurServicesWebElement.add(homePage.bussinessTourElementOnHomePage);
        listOfOurServicesWebElement.add(homePage.healthTourElementOnHomePage);
        listOfOurServicesWebElement.add(homePage.religiousTourElementOnHomePage);

        listOfVisibleWebElementTest(listOfOurServicesWebElement, homePage.ourServicesAreaOnHomepage);

    }

    //User should be able to see the functions about "Featured Packages" section in the body section of the Homepage
    @Test
    public void userSeeFunctionsAboutFeaturedPackagesSection() {
        homePage = new HomePage();
        basePage = new BasePage();
        basePage.acceptCookiesButton.click();

        List<WebElement> listOfFeaturedPackagesWebElement = new ArrayList<>();
        listOfFeaturedPackagesWebElement.add(homePage.featuredAreaOnHomePage);
        listOfFeaturedPackagesWebElement.add(homePage.featurePackagesSecondPictureOnHomePage);
        listOfFeaturedPackagesWebElement.add(homePage.featurePackagesThirdPictureOnHomePage);
        listOfFeaturedPackagesWebElement.add(homePage.featurePackagesFourthPictureOnHomePage);
        listOfFeaturedPackagesWebElement.add(homePage.firstIndicatorUnderFeaturedPackagesTitleOnHomePage);
        listOfFeaturedPackagesWebElement.add(homePage.secondIndicatorUnderFeaturedPackagesTitleOnHomePage);
        listOfVisibleWebElementTest(listOfFeaturedPackagesWebElement, homePage.featuredAreaOnHomePage);

        homePage.firstIndicatorUnderFeaturedPackagesTitleOnHomePage.click();
        ReusableMethods.waitFor(3);

        Assert.assertTrue(homePage.featurePackagesFirstPictureOnHomePage.isDisplayed());
    }

    //User should be able to see the functions about "Counter Area" section in the body section of the Homepage
    @Test
    public void userSeeFunctionsAboutCounterAreaSection() {
        homePage = new HomePage();
        basePage = new BasePage();
        basePage.acceptCookiesButton.click();
        ReusableMethods.waitFor(5);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.counterArea);
        Assert.assertTrue(homePage.counterArea.isDisplayed());

    }
//User should be able to see verify that the functions about "Destinations" section in the body section of the Homepage

    @Test
    public void userSeeFunctionsOfDestinationsSection() {
        homePage = new HomePage();
        basePage = new BasePage();
        basePage.acceptCookiesButton.click();
        ReusableMethods.waitFor(3);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.destinationAreaOnHomePage);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.destinationAreaOnHomePage.isDisplayed());
        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.elementsOfDestionationsOnHomePage.isDisplayed());
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.seeAllDestinationsButtonOnHomepage);
        Assert.assertTrue(homePage.seeAllDestinationsButtonOnHomepage.isDisplayed());

    }

        @Test//User should be able to see the functions about "Team Members" section in the body section of the Homepage
        public void userSeeFunctionsAboutTeamMembersSection(){//US03TC06
            homePage = new HomePage();
            basePage = new BasePage();
            basePage.acceptCookiesButton.click();
            ReusableMethods.waitFor(3);
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.teamMembersAreaOnHomepage);
            ReusableMethods.waitFor(3);
            Assert.assertTrue(homePage.teamMembersAreaOnHomepage.isDisplayed());
        }
//User should be able to see the functions about "Testimonial" section in the body section of the Homepage
        @Test
        public void userSeeFunctionsAboutTestimonialSection(){
            homePage = new HomePage();
            basePage = new BasePage();
            basePage.acceptCookiesButton.click();
            ReusableMethods.waitFor(3);
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.testimonialAreaHomePage);
            ReusableMethods.waitFor(3);
            Assert.assertTrue(homePage.testimonialAreaHomePage.isDisplayed());
            ReusableMethods.waitFor(3);
            Assert.assertTrue(homePage.jessicaRainyArea.isDisplayed());
            homePage.indicator3UnderTestimonialTitleOnHomePage.click();
            ReusableMethods.waitFor(3);
            Assert.assertTrue(homePage.stefanCarmanArea.isDisplayed());
            homePage.indicator2UnderTestimonialTitleOnHomePage.click();
            ReusableMethods.waitFor(3);
            Assert.assertTrue(homePage.dadivSmithArea.isDisplayed());
            homePage.indicator1UnderTestimonialTitleOnHomePage.click();
            ReusableMethods.waitFor(3);
            Assert.assertTrue(homePage.johnsonShealeyArea.isDisplayed());


        }

    @AfterMethod
    public void tearDown() {

        Driver.closeDriver();

    }
}
