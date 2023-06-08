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

    public void setUpTest(WebElement areaOfPage) {
        homePage = new HomePage();
        basePage = new BasePage();
        basePage.acceptCookiesButton.click();
        ReusableMethods.waitFor(5);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", areaOfPage);
        ReusableMethods.waitFor(2);

    }

    //User should be able to see the functions about "Our Services" section in the body section of the Homepage
    @Test(priority = 1)
    public void userCanSeeTheFunctionsAboutOurServicesSection() {
        homePage = new HomePage();
        basePage = new BasePage();
        basePage.acceptCookiesButton.click();

        List<WebElement> listOfOurServicesWebElement = new ArrayList<>();
        listOfOurServicesWebElement.add(homePage.ourServicesTitleTextOnHomePage);
        listOfOurServicesWebElement.add(homePage.textUnderOurServicesTitleOnHomepage);
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
    public void userSeeFunctionsAboutTeamMembersSection() {//US03TC06
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
    public void userSeeFunctionsAboutTestimonialSection() {//US03TC07
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

    //User should be able to see the functions about "Latest Blog" section in the body section of the Homepage
    @Test
    public void userSeeFunctionsAboutLatestBlogSection() {//TC_03_08

        homePage = new HomePage();
        basePage = new BasePage();
        basePage.acceptCookiesButton.click();
        ReusableMethods.waitFor(3);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.latestBlogArea);
        ReusableMethods.waitFor(3);

        Assert.assertTrue(homePage.latestBlogArea.isDisplayed());
        Assert.assertTrue(homePage.sliderRightSideUnderTheLatestBlogOnHomePage.isDisplayed());
        Assert.assertTrue(homePage.sliderLeftSideUnderTheLatestBlogOnHomePage.isDisplayed());

    }

    @Test//User should be able to see functions about "Our Client" section in the body section of the Homepage
    public void userSeeFunctionsAboutOurClientSection() {//TC_03_09
        homePage = new HomePage();
        basePage = new BasePage();
        basePage.acceptCookiesButton.click();
        ReusableMethods.waitFor(3);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.ourClientAreaOnHomePage);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.ourClientAreaOnHomePage.isDisplayed());

    }

    @Test
//User should be able to see verify that the functions about "Newsletter" section in the body section of the Homepage
    public void userSeeFunctionsAboutNewsletterSection() {//TC_03_10
        // homePage = new HomePage();
        // basePage = new BasePage();
        // basePage.acceptCookiesButton.click();
        // ReusableMethods.waitFor(3);
        // JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.newsLetterAreaOnHomepage);
        // ReusableMethods.waitFor(3);
        setUpTest(homePage.newsLetterAreaOnHomepage);
        Assert.assertTrue(homePage.newsLetterAreaOnHomepage.isDisplayed());


    }

    @Test//User should be able to click the functions about hero area in the body section of the Homepage
    public void userClickTheFunctionsAboutHeroArea() {
        setUpTest(homePage.heroAreaOnHomePage);
       isClickableElementsInHeroSection();

        //2)User sould click read more button under the Salina Island area in hero section on the homepage
        //3)User sould click read more button under the The World Is Beatiful Area in hero section on the homepage
        //4)User sould see read more button under the Explore The World Area in hero section on the homepage
        //5)User should click the slider on the right side of hero section on the homepage.
        //6)User should click the slider on the left side of hero section on the homepage
        //7)User should close the page

    }
    public void isClickableElementsInHeroSection(WebElement clickableElement,WebElement readMoreButton, String url){
        clickableElement.click();
        ReusableMethods.waitFor(2);
        String expectedUrl=url;
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.equals(expectedUrl));
        Driver.getDriver().navigate().back();


    }

    @AfterMethod
    public void tearDown() {

        Driver.closeDriver();

    }
}
