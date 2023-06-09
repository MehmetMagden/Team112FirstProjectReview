package tests.Ayse;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class US_03 {
    private HomePage homePage = new HomePage();
    private BasePage basePage = new BasePage();
    private PackagesPage packagesPage = new PackagesPage();

    private ServicesPage servicesPage = new ServicesPage();

    private DestinationsPage destinationsPage = new DestinationsPage();
    private JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();


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
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", areaOfPage);
        for (int i = 0; i < list.size(); i++) {
            ReusableMethods.waitFor(3);
            Assert.assertTrue(list.get(i).isDisplayed());

        }

    }

    public void listOfClickableWebElement(List<WebElement> list, WebElement title) {
        for (int i = 0; i < list.size(); i++) {
            ReusableMethods.waitFor(4);
            list.get(i).click();
            ReusableMethods.waitFor(3);
            Assert.assertTrue(title.isDisplayed());
            Driver.getDriver().navigate().back();
            ReusableMethods.waitFor(3);

        }

    }

    public void setUpTest(WebElement areaOfPage) {
        homePage = new HomePage();
        basePage = new BasePage();
        basePage.acceptCookiesButton.click();
        ReusableMethods.waitFor(5);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", areaOfPage);
        ReusableMethods.waitFor(3);

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
        ReusableMethods.waitFor(3);

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
        js = (JavascriptExecutor) Driver.getDriver();
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
        js = (JavascriptExecutor) Driver.getDriver();
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
        js = (JavascriptExecutor) Driver.getDriver();
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
        js = (JavascriptExecutor) Driver.getDriver();
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
        js = (JavascriptExecutor) Driver.getDriver();
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
    public void userClickTheFunctionsAboutHeroArea() {////TC_03_11
        homePage = new HomePage();
        basePage = new BasePage();
        packagesPage = new PackagesPage();
        basePage.acceptCookiesButton.click();
        ReusableMethods.waitFor(5);
        isClickableElements(homePage.firstIndicatorInHeroSection, homePage.readMoreButtonUnderExploreTheWorldAreaText, packagesPage.tourDatesText);
        ReusableMethods.waitFor(5);
        isClickableElements(homePage.thirdIndicatorInHeroSection, homePage.readMoreButtonUnderSalinaIslandAreaText, packagesPage.tourDatesText);
        ReusableMethods.waitFor(5);
        isClickableElements(homePage.secondIndicatorInHeroSection, homePage.readMoreButtonUnderTheWorldIsSoBeautifulText, packagesPage.tourDatesText);


        // isClickableElementsInHeroSection(homePage.firstIndicatorInHeroSection,homePage.readMoreButtonUnderExploreTheWorldAreaText,"https://tripandway.com/package/3-days-in-bangkok");

        //2)User sould click read more button under the Salina Island area in hero section on the homepage
        //3)User sould click read more button under the The World Is Beatiful Area in hero section on the homepage
        //4)User sould see read more button under the Explore The World Area in hero section on the homepage
        //5)User should click the slider on the right side of hero section on the homepage.
        //6)User should click the slider on the left side of hero section on the homepage
        //7)User should close the page

    }

    //User should be able to click the functions about "Our Services" section in the body section of the Homepage
    @Test
    public void userClickTheFunctionsAboutOurServices() {//TC_03_12
        setUpTest(homePage.ourServicesAreaOnHomepage);
        servicesPage = new ServicesPage();

        isClickableElementsInOurServices(homePage.internationalTourElementOnHomePage, servicesPage.internationalTourButton);
        isClickableElementsInOurServices(homePage.adventureTourElementOnHomePage, servicesPage.internationalTourButton);
        isClickableElementsInOurServices(homePage.cultureTourElementOnHomePage, servicesPage.internationalTourButton);
        isClickableElementsInOurServices(homePage.bussinessTourElementOnHomePage, servicesPage.internationalTourButton);
        isClickableElementsInOurServices(homePage.healthTourElementOnHomePage, servicesPage.internationalTourButton);
        isClickableElementsInOurServices(homePage.religiousTourElementOnHomePage, servicesPage.internationalTourButton);


    }

    //User should be able to click the functions about "Featured Packages" section in the body section of the Homepage
    @Test
    public void userClickTheFunctionsAboutFeaturedPackages() {//TC_03_13
        packagesPage = new PackagesPage();
        setUpTest(homePage.featuredAreaOnHomePage);
        ReusableMethods.waitFor(3);

        isClickableElements(homePage.firstIndicatorUnderFeaturedPackagesTitleOnHomePage, homePage.threeDaysInBuenosAiresText, packagesPage.bookNowText);
        isClickableElements(homePage.firstIndicatorUnderFeaturedPackagesTitleOnHomePage, homePage.tenDaysInBuenosAiresText, packagesPage.bookNowText);
        isClickableElements(homePage.firstIndicatorUnderFeaturedPackagesTitleOnHomePage, homePage.threeDaysInBangkokText, packagesPage.bookNowText);
        isClickableElements(homePage.firstIndicatorUnderFeaturedPackagesTitleOnHomePage, homePage.sevenDaysInSalinaIslandText, packagesPage.bookNowText);

    }

    //User should be able to click the functions about "Destinations" section in the body section of the Homepage
    @Test
    public void userClickTheFunctionsAboutDestinationsPackages() {//TC_03_14
        setUpTest(homePage.destinationAreaOnHomePage);
        destinationsPage = new DestinationsPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        List<WebElement> destinationsList = new ArrayList<>();
        destinationsList.add(homePage.bangkokThailandTextInDestinationsSection);
        destinationsList.add(homePage.greenvilleSouthCarolinaTextInDestinationsSection);
        destinationsList.add(homePage.buenosAiresArgentinaTextInDestinationsSection);
        destinationsList.add(homePage.marrakeshMoroccoTextInDestinationsSection);
        destinationsList.add(homePage.salinaIslandItalyTextInDestinationsSection);
        destinationsList.add(homePage.istanbulTurkeyTextInDestinationsSection);


        //listOfClickableWebElement(destinationsList,destinationsPage.titleEachDestinations);

        // js.executeScript("arguments[0].scrollIntoView();", homePage.seeAllDestinationsButtonOnHomepage);
        ReusableMethods.waitFor(5);
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.titleOfTeamMembersOnHomepage);
        ReusableMethods.waitForVisibility(homePage.seeAllDestinationsButtonOnHomepage, 30);
        homePage.seeAllDestinationsButtonOnHomepage.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(destinationsPage.destinationsImageWebElement.isDisplayed());
        Driver.getDriver().navigate().back();

    }

    //User should be able to click the functions about "Team Members" section in the body section of the Homepage

    @Test
    public void userClickTheFunctionsAboutTeamMembersSection() {////TC_03_15
       setUpTest(homePage.teamMembersAreaOnHomepage);

        List<WebElement> listOfTeamMembers = new ArrayList<>();
        listOfTeamMembers.add(homePage.knoxMitchellText);
        listOfTeamMembers.add(homePage.jaxonGreenText);
        listOfTeamMembers.add(homePage.averyJohnsonText);
        listOfTeamMembers.add(homePage.zaraWilliamsText);
       //listOfClickableWebElement(listOfTeamMembers, homePage.detailEachTeamMembers);

     String firstWH = Driver.getDriver().getWindowHandle();

        socialMediaIkonsTestOfTeamMembers(homePage.knoxMitchellFacebookIkon,homePage.facebookImg,firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.jaxonGreenFacebookIkon,homePage.facebookImg,firstWH );
        socialMediaIkonsTestOfTeamMembers(homePage.averyJohnsonFacebookIkon,homePage.facebookImg,firstWH );
        socialMediaIkonsTestOfTeamMembers(homePage.zaraWilliamsFacebookIkon,homePage.facebookImg,firstWH );
        socialMediaIkonsTestOfTeamMembers(homePage.knoxMitchellTwitterIkon,homePage.twitterKesfetArea,firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.jaxonGreenTwitterIkon,homePage.twitterKesfetArea,firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.averyJohnsonTwitterIkon,homePage.twitterKesfetArea,firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.zaraWilliamsTwitterIkon,homePage.twitterKesfetArea,firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.knoxMitchellLinkedInIkon,homePage.linkedinEmailBox,firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.jaxonGreenLinkedInIkon,homePage.linkedinEmailBox,firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.averyJohnsonLinkedInIkon,homePage.linkedinEmailBox,firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.zaraWilliamsLinkedInIkon,homePage.linkedinEmailBox,firstWH);


    }
    public void socialMediaIkonsTestOfTeamMembers(WebElement socialMediaIkon,WebElement testOfElement,String firstWH){
        String secondWH="";
        ReusableMethods.waitFor(5);
        js.executeScript("arguments[0].click();", socialMediaIkon);
        ReusableMethods.waitFor(5);
        Set<String> allWH = Driver.getDriver().getWindowHandles();
        for (String eachWH : allWH) {
            if (!eachWH.equals(firstWH)) {
                secondWH = eachWH;
            }
        }
        Driver.getDriver().switchTo().window(secondWH);

        Assert.assertTrue(testOfElement.isDisplayed());
        Driver.getDriver().switchTo().window(firstWH);
        ReusableMethods.waitFor(5);


    }
    @Test
    public void userClickableElementsOfTeamMembers(){
        homePage = new HomePage();
        basePage = new BasePage();
        packagesPage = new PackagesPage();
        basePage.acceptCookiesButton.click();
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", homePage.knoxMitchellFacebookIkon);

    }

    public void isClickableElementsInOurServices(WebElement element, WebElement internationalTourText) {
        element.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(internationalTourText.isDisplayed());
        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(3);
    }


    public void isClickableElements(WebElement clickableElement, WebElement readMoreButton, WebElement theOtherPageElement) {
        clickableElement.click();
        ReusableMethods.waitFor(3);
        readMoreButton.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(theOtherPageElement.isDisplayed());
        ReusableMethods.waitFor(3);
        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(3);
    }


    @AfterMethod
    public void tearDown() {

        Driver.closeDriver();
        Driver.quitDriver();

    }
}
