package tests.Ayse;


import com.github.javafaker.Faker;
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
        homePage = new HomePage();
        basePage = new BasePage();
        basePage.acceptCookiesButton.click();
    }

    //User should be able to see the functions about hero area in the body section of the Home page
    @Test
    public void userCanSeeTheFunctionsAboutHeroArea() {//TC_03_01
        // homePage = new HomePage();
        // basePage = new BasePage();
        // basePage.acceptCookiesButton.click();
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


    //User should be able to see the functions about "Our Services" section in the body section of the Homepage
    @Test//TC_03_02
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
    public void userSeeFunctionsAboutFeaturedPackagesSection() {//TC_03_03
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
    public void userSeeFunctionsAboutCounterAreaSection() {//TC_03_04
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
    public void userSeeFunctionsOfDestinationsSection() {//TC_03_05
        homePage = new HomePage();
        basePage = new BasePage();
        basePage.acceptCookiesButton.click();

        List<WebElement> listOfDestinations = new ArrayList<>();
        listOfDestinations.add(homePage.destinationsTitleInDestinationsSectionOnHomepage);
        listOfDestinations.add(homePage.textUnderDestinationsTitleOnHomepage);
        listOfDestinations.add(homePage.bangkokThailandTextInDestinationsSection);
        listOfDestinations.add(homePage.greenvilleSouthCarolinaTextInDestinationsSection);
        listOfDestinations.add(homePage.buenosAiresArgentinaTextInDestinationsSection);
        listOfDestinations.add(homePage.marrakeshMoroccoTextInDestinationsSection);
        listOfDestinations.add(homePage.salinaIslandItalyTextInDestinationsSection);
        listOfDestinations.add(homePage.istanbulTurkeyTextInDestinationsSection);
        listOfDestinations.add(homePage.seeAllDestinationsButtonOnHomepage);
        listOfVisibleWebElementTest(listOfDestinations, homePage.destinationAreaOnHomePage);

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
        ReusableMethods.waitFor(5);
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,4800)");
        // js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.latestBlogArea);
        ReusableMethods.waitFor(10);
        Assert.assertTrue(homePage.titleOfLatestBlogOnHomepage.isEnabled());
        ReusableMethods.waitFor(10);
        Assert.assertTrue(homePage.textUndertitleOfLatestBlogOnHomepage.isEnabled());
        ReusableMethods.waitFor(10);
        Assert.assertTrue(homePage.bangkokAreaUnderTheLatestBlogOnHomepage.isEnabled());
        ReusableMethods.waitFor(10);
        Assert.assertTrue(homePage.buenosAiresAreaUnderTheLatestBlogOnHomePage.isEnabled());
        ReusableMethods.waitFor(15);
        Assert.assertTrue(homePage.discoveringGreenvilleAreaUnderTheLatestBlogOnHomePage.isEnabled());
        ReusableMethods.waitFor(15);
        Assert.assertTrue(homePage.istanbulAreaUnderTheLatestBlogOnHomePage.isEnabled());
        ReusableMethods.waitFor(15);
        Assert.assertTrue(homePage.discoveringGreenvilleAreaUnderTheLatestBlogOnHomePage.isEnabled());
        ReusableMethods.waitFor(15);
        Assert.assertTrue(homePage.salinaIslandAreaUnderTheLatesBlogOnHomepage.isEnabled());


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

        // JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        setUpTest(homePage.newsLetterAreaOnHomepage);

        ReusableMethods.waitFor(5);
        Assert.assertTrue(homePage.titleAndTextAreaOfNewsLetterOnHomepage.isDisplayed());
        ReusableMethods.waitFor(5);
        Assert.assertTrue(homePage.emailBoxUnderTheNewsLetterOnHomepage.isDisplayed());
        ReusableMethods.waitFor(5);
        Assert.assertTrue(homePage.submitButtonUnderTheNewsLetterOnHomepage.isDisplayed());


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
        js = (JavascriptExecutor) Driver.getDriver();

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
        // js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.titleOfTeamMembersOnHomepage);
        // ReusableMethods.waitForVisibility(homePage.seeAllDestinationsButtonOnHomepage, 30);

        js.executeScript("arguments[0].click();", homePage.seeAllDestinationsButtonOnHomepage);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(destinationsPage.destinationsImageWebElement.isDisplayed());
        Driver.getDriver().navigate().back();

    }

    //User should be able to click the functions about "Team Members" section in the body section of the Homepage

    @Test
    public void userClickTheFunctionsAboutTeamMembersSection() {//TC_03_15


        setUpTest(homePage.teamMembersAreaOnHomepage);

        List<WebElement> listOfTeamMembers = new ArrayList<>();
        listOfTeamMembers.add(homePage.knoxMitchellText);
        listOfTeamMembers.add(homePage.jaxonGreenText);
        listOfTeamMembers.add(homePage.averyJohnsonText);
        listOfTeamMembers.add(homePage.zaraWilliamsText);

        listOfClickableWebElement(listOfTeamMembers, homePage.detailEachTeamMembers);

        String firstWH = Driver.getDriver().getWindowHandle();
        ReusableMethods.waitFor(8);
        socialMediaIkonsTestOfTeamMembers(homePage.knoxMitchellFacebookIkon, homePage.facebookImg, firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.jaxonGreenFacebookIkon, homePage.facebookImg, firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.averyJohnsonFacebookIkon, homePage.facebookImg, firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.zaraWilliamsFacebookIkon, homePage.facebookImg, firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.knoxMitchellTwitterIkon, homePage.twitterKesfetArea, firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.jaxonGreenTwitterIkon, homePage.twitterKesfetArea, firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.averyJohnsonTwitterIkon, homePage.twitterKesfetArea, firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.zaraWilliamsTwitterIkon, homePage.twitterKesfetArea, firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.knoxMitchellLinkedInIkon, homePage.linkedinEmailBox, firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.jaxonGreenLinkedInIkon, homePage.linkedinEmailBox, firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.averyJohnsonLinkedInIkon, homePage.linkedinEmailBox, firstWH);
        socialMediaIkonsTestOfTeamMembers(homePage.zaraWilliamsLinkedInIkon, homePage.linkedinEmailBox, firstWH);


    }


    @Test//User should be able to click functions about "Latest Blog" section in the body section of the Homepage
    public void userClickTheFunctionsAboutLatestBlogSection() {//TC_03_16
        homePage = new HomePage();
        js = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookies();
//        js.executeScript("arguments[0].scrollIntoView();", homePage.latestBlogArea);
        js.executeScript("window.scrollBy(0,5200)");
        List<WebElement> elementsOfLatestBlogList = new ArrayList<>();
        elementsOfLatestBlogList.add(homePage.readMoreButtonUnderTheIstanbulAreaTextOnHomepage);
        elementsOfLatestBlogList.add(homePage.readMoreButtonUnderTheAncientCapitalTextOnHomePage);
        elementsOfLatestBlogList.add(homePage.readMoreButtonUnderTheSalinaIslandTextOnHomepage);
        elementsOfLatestBlogList.add(homePage.readMoreButtonUnderTheBangkokAreaTextOnHomepage);
        elementsOfLatestBlogList.add(homePage.readMoreButtonUnderTheBuenosAiresAreaTextOnHomepage);
        elementsOfLatestBlogList.add(homePage.readMoreButtonUnderTheDiscoveringGreenvilleAreaTextOnHomepage);

        latestBlogClickable(elementsOfLatestBlogList, homePage.searchHereEachLatestBlog);

    }


    public void socialMediaIkonsTestOfTeamMembers(WebElement socialMediaIkon, WebElement testOfElement, String firstWH) {
        String secondWH = "";
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


    }

    @Test//User should be able to click the functions about "Newsletter" section in the body section of the Homepage
    public void userClickTheFunctionsAboutNewsletterSection() {//TC_03_17
        js = (JavascriptExecutor) Driver.getDriver();
        Faker faker = new Faker();
        AdminPage adminPage = new AdminPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));

        js.executeScript("arguments[0].scrollIntoView();", homePage.emailBoxUnderTheNewsLetterOnHomepage);

        homePage.emailBoxUnderTheNewsLetterOnHomepage.sendKeys(faker.internet().emailAddress());
        homePage.submitButtonUnderTheNewsLetterOnHomepage.click();

        String actualMessage = adminPage.warningMessage.getText(); // Chrome's Save Card prompt ruins the test!!
        String expectedMessage = "To activate your subscription please check your email and follow instruction there.";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    public void userClickableElementsOfTeamMembers() {
        homePage = new HomePage();
        basePage = new BasePage();
        packagesPage = new PackagesPage();
        basePage.acceptCookiesButton.click();
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", homePage.knoxMitchellFacebookIkon);

    }

    public void latestBlogClickable(List<WebElement> list, WebElement clickElement) {

        for (WebElement each : list
        ) {
            ReusableMethods.waitFor(5);
            js.executeScript("arguments[0].click();", each);
            ReusableMethods.waitFor(3);
            Assert.assertTrue(clickElement.isDisplayed());
            Driver.getDriver().navigate().back();
            ReusableMethods.waitFor(1);
        }
    }

    public void listOfVisibleWebElementTest(List<WebElement> list, WebElement areaOfPage) {

        ReusableMethods.waitFor(5);
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", areaOfPage);
        for (int i = 0; i < list.size(); i++) {
            ReusableMethods.waitFor(5);
            Assert.assertTrue(list.get(i).isDisplayed());
            ReusableMethods.waitFor(5);

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

    public void isVisibleElementOfWebElementListForEach(List<WebElement> list) {
        ReusableMethods.waitFor(10);

        try {
            for (WebElement each : list
            ) {
                ReusableMethods.waitFor(20);
                Assert.assertTrue(each.isDisplayed());
                ReusableMethods.waitFor(10);
            }
        } catch (Exception e) {
            System.out.println(e + "Element is not display");
        }

    }

    public void isClickableElements(WebElement clickableElement, WebElement readMoreButton, WebElement
            theOtherPageElement) {
        clickableElement.click();
        ReusableMethods.waitFor(3);
        readMoreButton.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(theOtherPageElement.isDisplayed());
        ReusableMethods.waitFor(3);
        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(3);
    }

    public void isClickableElementsInOurServices(WebElement element, WebElement internationalTourText) {
        element.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(internationalTourText.isDisplayed());
        Driver.getDriver().navigate().back();
        ReusableMethods.waitFor(3);
    }

    @AfterMethod
    public void tearDown() {

        Driver.closeDriver();
        Driver.quitDriver();
    }


}


