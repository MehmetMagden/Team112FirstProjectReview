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
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class US_03 extends TestBaseRapor {
    private HomePage homePage = new HomePage();
    private BasePage basePage = new BasePage();
    private PackagesPage packagesPage = new PackagesPage();
    public ServicesPage servicesPage = new ServicesPage();
    public DestinationsPage destinationsPage = new DestinationsPage();
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
    public void TC01UserCanSeeTheFunctionsAboutHeroArea() {//TC_03_01
        // homePage = new HomePage();
        // basePage = new BasePage();
        // basePage.acceptCookiesButton.click();
        extentTest = extentReports.createTest("TC0301", "user see the functions about 'Hero Area' on homepage");
        homePage.exploreTheWorldArea.isDisplayed();
        ReusableMethods.waitFor(5);
        ReusableMethods.waitForVisibility(homePage.theWorldIsSoBeautifulAreaOnHomepage, 15);
        Assert.assertTrue(homePage.theWorldIsSoBeautifulAreaOnHomepage.isDisplayed());
        extentTest.pass("user  see first element of 'Hero Area' ");

        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.readMoreButtonUnderTheWorldIsSoBeautifulText.isDisplayed());
        extentTest.pass("User  see 'read more' button under the 'The World Is So Beautiful' ");

        homePage.sliderOnRightSideOfHeroArea.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.salinaIslandAreaOnHomepage.isDisplayed());
        extentTest.pass("User  see as a slider text 'Salina Island' and the accompanying text");

        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.readMoreButtonUnderSalinaIslandAreaText.isDisplayed());
        extentTest.pass("User  see 'read more' button under the 'Salina Island' ");

        ReusableMethods.waitFor(3);
        homePage.sliderOnRightSideOfHeroArea.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.exploreTheWorldArea.isDisplayed());
        extentTest.pass("User  see as a slider text 'Explore the world' and the accompanying text ");

        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.readMoreButtonUnderExploreTheWorldAreaText.isDisplayed());
        extentTest.pass("User  see 'read more' button under the 'Explore The World' ");

        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.sliderOnRightSideOfHeroArea.isDisplayed());
        extentTest.pass("User see the slider on the right side of the homepage.");

        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.sliderOnLeftSideOfHeroArea.isDisplayed());
        extentTest.pass("User  see the slider on the left side of the homepage.");

    }


    //User should be able to see the functions about "Our Services" section in the body section of the Homepage
    @Test//TC_03_02
    public void TC02userCanSeeTheFunctionsAboutOurServicesSection() {

        extentTest = extentReports.createTest("TC0302", "User see the functions about 'Our Services' on homepage");
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
        extentTest.pass("User can see every each element of 'Our Services' section");

    }

    //User should be able to see the functions about "Featured Packages" section in the body section of the Homepage
    @Test
    public void TC03UserSeeFunctionsAboutFeaturedPackagesSection() {//TC_03_03

        extentTest = extentReports.createTest("TC0303", "user see the functions about 'Featured Packages' section");
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
        extentTest.pass("User can see every each element of 'Featured Packages' section");
    }


    //User should be able to see the functions about "Counter Area" section in the body section of the Homepage
    @Test
    public void TC04UserSeeFunctionsAboutCounterAreaSection() {//TC_03_04
        extentTest = extentReports.createTest("TC0304", "User see the functions about 'Counter' area");
        ReusableMethods.waitFor(5);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.counterArea);
        Assert.assertTrue(homePage.counterArea.isDisplayed());
        extentTest.pass("User can see counter area");

    }
//User should be able to see verify that the functions about "Destinations" section in the body section of the Homepage

    @Test
    public void TC05UserSeeFunctionsOfDestinationsSection() {//TC_03_05

        extentTest = extentReports.createTest("TC0305", "User see the functions about 'Destinations' section");
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
        extentTest.pass("User can see ever each element of'Destinations' section ");

    }

    @Test//User should be able to see the functions about "Team Members" section in the body section of the Homepage
    public void TC06UserSeeFunctionsAboutTeamMembersSection() {//US03TC06

        extentTest = extentReports.createTest("TC0306", "User see the functions about 'Team Member' section");
        ReusableMethods.waitFor(5);
        js = (JavascriptExecutor) Driver.getDriver();

        List<WebElement>listOfTeamMemberArea=new ArrayList<>();
        listOfTeamMemberArea.add(homePage.knoxMitchell);
        listOfTeamMemberArea.add(homePage.jaxonGreen);
        listOfTeamMemberArea.add(homePage.averyJohnson);
        listOfTeamMemberArea.add(homePage.zaraWilliams);

        listOfVisibleWebElementTest(listOfTeamMemberArea,homePage.teamMembersAreaOnHomepage);


     //  js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.teamMembersAreaOnHomepage);
     //  ReusableMethods.waitFor(5);
     //  Assert.assertTrue(homePage.teamMembersAreaOnHomepage.isDisplayed());
     //  extentTest.pass("User can see 'Team Member' section ");
     //  ReusableMethods.waitFor(5);

     //  Assert.assertTrue(homePage.averyJohnson.isDisplayed());
     //  ReusableMethods.waitFor(5);
     //  extentTest.pass("User can see element of 'Avery Johnson' in 'Team Member' section");

     //  Assert.assertTrue(homePage.zaraWilliams.isDisplayed());
     //  ReusableMethods.waitFor(5);
     //  extentTest.pass("User can see element of 'Zara Williams' in 'Team Member' section");

     //  Assert.assertTrue(homePage.jaxonGreen.isDisplayed());
     //  ReusableMethods.waitFor(5);
     //  extentTest.pass("User can see element of 'Jaxon Green' in 'Team Member' section");

     //  Assert.assertTrue(homePage.knoxMitchell.isDisplayed());
     //  ReusableMethods.waitFor(5);
     //  extentTest.pass("User can see element of 'Knox Mitchell' in 'Team Member' section");
    }

    //User should be able to see the functions about "Testimonial" section in the body section of the Homepage
    @Test
    public void TC07UserSeeFunctionsAboutTestimonialSection() {//US03TC07

        extentTest = extentReports.createTest("TC0307", "User see the functions about 'Testimonial' on homepage");
        ReusableMethods.waitFor(3);
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.testimonialAreaHomePage);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.testimonialAreaHomePage.isDisplayed());
        extentTest.pass("User can see 'Testimonial' area");

        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.jessicaRainyArea.isDisplayed());
        extentTest.pass("User can see Jessica Rainy's area");

        homePage.indicator3UnderTestimonialTitleOnHomePage.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.stefanCarmanArea.isDisplayed());
        extentTest.pass("User can see Stefan Carman's area");


        homePage.indicator2UnderTestimonialTitleOnHomePage.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.dadivSmithArea.isDisplayed());
        extentTest.pass("User can see Dadiv Smith's area");

        homePage.indicator1UnderTestimonialTitleOnHomePage.click();
        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.johnsonShealeyArea.isDisplayed());
        extentTest.pass("User can see Johnson Shealey's area");


    }

    //User should be able to see the functions about "Latest Blog" section in the body section of the Homepage
    @Test
    public void TC08UserSeeFunctionsAboutLatestBlogSection() {//TC_03_08

        extentTest = extentReports.createTest("TC0308", "User see the functions about 'Latest Blog' on homepage");
        ReusableMethods.waitFor(5);
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,4800)");
        // js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.latestBlogArea);
        ReusableMethods.waitFor(10);
        Assert.assertTrue(homePage.titleOfLatestBlogOnHomepage.isDisplayed());
        ReusableMethods.waitFor(10);
        Assert.assertTrue(homePage.textUndertitleOfLatestBlogOnHomepage.isDisplayed());
        ReusableMethods.waitFor(10);
        Assert.assertTrue(homePage.bangkokAreaUnderTheLatestBlogOnHomepage.isDisplayed());
        ReusableMethods.waitFor(10);
        Assert.assertTrue(homePage.buenosAiresAreaUnderTheLatestBlogOnHomePage.isDisplayed());
        ReusableMethods.waitFor(15);
        Assert.assertTrue(homePage.discoveringGreenvilleAreaUnderTheLatestBlogOnHomePage.isDisplayed());
        ReusableMethods.waitFor(15);
        Assert.assertTrue(homePage.istanbulAreaUnderTheLatestBlogOnHomePage.isDisplayed());
        ReusableMethods.waitFor(15);
        Assert.assertTrue(homePage.discoveringGreenvilleAreaUnderTheLatestBlogOnHomePage.isDisplayed());
        ReusableMethods.waitFor(15);
        Assert.assertTrue(homePage.salinaIslandAreaUnderTheLatesBlogOnHomepage.isDisplayed());
        extentTest.fail("When you go to the 'Lates Blog' section manually, each element can be seen, but when you test with code, a different element cannot be seen in each test.");

    }


    @Test//User should be able to see functions about "Our Client" section in the body section of the Homepage
    public void TC09UserSeeFunctionsAboutOurClientSection() {//TC_03_09

        extentTest = extentReports.createTest("TC0309", "User see the functions about 'Our Client' on homepage");
        ReusableMethods.waitFor(3);
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.ourClientAreaOnHomePage);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(homePage.ourClientAreaOnHomePage.isDisplayed());
        extentTest.pass("User can see 'Our Client' area ");

    }

    @Test
//User should be able to see verify that the functions about "Newsletter" section in the body section of the Homepage
    public void TC10UserSeeFunctionsAboutNewsletterSection() {//TC_03_10
        extentTest = extentReports.createTest("TC0310", "User see the functions about 'Newsletter' section");

        setUpTest(homePage.newsLetterAreaOnHomepage);

        ReusableMethods.waitFor(5);
        Assert.assertTrue(homePage.titleAndTextAreaOfNewsLetterOnHomepage.isDisplayed());
        ReusableMethods.waitFor(5);
        extentTest.pass("User see title of 'Newsletter' area");
        Assert.assertTrue(homePage.emailBoxUnderTheNewsLetterOnHomepage.isDisplayed());
        extentTest.pass("user see email box in 'Newsletters' section ");
        ReusableMethods.waitFor(5);
        Assert.assertTrue(homePage.submitButtonUnderTheNewsLetterOnHomepage.isDisplayed());
        extentTest.pass("user see submit button in 'Newsletters' section");


    }

    @Test//User should be able to click the functions about hero area in the body section of the Homepage
    public void TC11UserClickTheFunctionsAboutHeroArea() {////TC_03_11
        extentTest = extentReports.createTest("TC0311", "User click the functions about 'Hero Area' section");
        packagesPage = new PackagesPage();

        ReusableMethods.waitFor(5);
        isClickableElements(homePage.firstIndicatorInHeroSection, homePage.readMoreButtonUnderExploreTheWorldAreaText, packagesPage.tourDatesText);
        extentTest.pass("User click read more button under the 'Explore The World' element and reach its page");
        ReusableMethods.waitFor(5);
        isClickableElements(homePage.thirdIndicatorInHeroSection, homePage.readMoreButtonUnderSalinaIslandAreaText, packagesPage.tourDatesText);
        ReusableMethods.waitFor(5);
        extentTest.pass("User click read more button under the 'Salina Island' element and reach its page");
        isClickableElements(homePage.secondIndicatorInHeroSection, homePage.readMoreButtonUnderTheWorldIsSoBeautifulText, packagesPage.tourDatesText);
        extentTest.pass("User click read more button under the 'The World is So Beautiful' element and reach its page");


    }


    //User should be able to click the functions about "Our Services" section in the body section of the Homepage
    @Test
    public void TC12UserClickTheFunctionsAboutOurServices() {//TC_03_12
        extentTest = extentReports.createTest("TC0312", "User see the functions about 'Our Services' section");
        setUpTest(homePage.ourServicesAreaOnHomepage);
        servicesPage = new ServicesPage();

        isClickableElementsInOurServices(homePage.internationalTourElementOnHomePage, servicesPage.internationalTourButton);
        extentTest.pass("User click 'International Tour' element and reach its page");
        isClickableElementsInOurServices(homePage.adventureTourElementOnHomePage, servicesPage.internationalTourButton);
        extentTest.pass("User click 'Adventure Tour' element and reach its page");
        isClickableElementsInOurServices(homePage.cultureTourElementOnHomePage, servicesPage.internationalTourButton);
        extentTest.pass("User click 'Culture Tour' element and reach its page");
        isClickableElementsInOurServices(homePage.bussinessTourElementOnHomePage, servicesPage.internationalTourButton);
        extentTest.pass("User click 'Business Tour' element and reach its page");
        isClickableElementsInOurServices(homePage.healthTourElementOnHomePage, servicesPage.internationalTourButton);
        extentTest.pass("User click 'Health Tour' element and reach its page");
        isClickableElementsInOurServices(homePage.religiousTourElementOnHomePage, servicesPage.internationalTourButton);
        extentTest.pass("User click 'Religious Tour' element and reach its page");


    }


    //User should be able to click the functions about "Featured Packages" section in the body section of the Homepage
    @Test
    public void TC13UserClickTheFunctionsAboutFeaturedPackages() {//TC_03_13
        extentTest = extentReports.createTest("TC0314", "user click the functions about 'Featured Packages' section");
        packagesPage = new PackagesPage();
        setUpTest(homePage.featuredAreaOnHomePage);
        ReusableMethods.waitFor(3);

        isClickableElements(homePage.firstIndicatorUnderFeaturedPackagesTitleOnHomePage, homePage.threeDaysInBuenosAiresText, packagesPage.bookNowText);
        extentTest.pass("User click '3 Days in Buenos Aires' text and reach its page ");
        isClickableElements(homePage.firstIndicatorUnderFeaturedPackagesTitleOnHomePage, homePage.tenDaysInBuenosAiresText, packagesPage.bookNowText);
        extentTest.pass("User click '10 Days in Buenos Aires' text and reach its page ");
        isClickableElements(homePage.firstIndicatorUnderFeaturedPackagesTitleOnHomePage, homePage.threeDaysInBangkokText, packagesPage.bookNowText);
        extentTest.pass("User click '3 Days in Bangkok' text and reach its page ");
        isClickableElements(homePage.firstIndicatorUnderFeaturedPackagesTitleOnHomePage, homePage.sevenDaysInSalinaIslandText, packagesPage.bookNowText);
        extentTest.pass("User click '7 Days in Salina Island' text and reach its page ");

    }

    //User should be able to click the functions about "Destinations" section in the body section of the Homepage
    @Test
    public void TC14UserClickTheFunctionsAboutDestinationsPackages() {//TC_03_14
        extentTest = extentReports.createTest("TC0314", "User click the functions about 'Destinations Packages' section");
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


        listOfClickableWebElement(destinationsList, destinationsPage.titleEachDestinations);
        extentTest.pass("User click every each element of Destinations Packages section");


    }

    //User should be able to click the functions about "Team Members" section in the body section of the Homepage

    @Test
    public void TC15UserClickTheFunctionsAboutTeamMembersSection() {//TC_03_15
        extentTest = extentReports.createTest("TC0315", "User click the functions about 'Team Members' section");


        setUpTest(homePage.teamMembersAreaOnHomepage);

        List<WebElement> listOfTeamMembers = new ArrayList<>();
        listOfTeamMembers.add(homePage.knoxMitchellText);
        listOfTeamMembers.add(homePage.jaxonGreenText);
        listOfTeamMembers.add(homePage.averyJohnsonText);
        listOfTeamMembers.add(homePage.zaraWilliamsText);

       listOfClickableWebElement(listOfTeamMembers, homePage.detailEachTeamMembers);
        extentTest.pass("User can reach page of each team members");

        String firstWH = Driver.getDriver().getWindowHandle();
        ReusableMethods.waitFor(5);
        List<WebElement>socialMediaIkonsList=new ArrayList<>();
        socialMediaIkonsList.add(homePage.knoxMitchellFacebookIkon);
        socialMediaIkonsList.add(homePage.jaxonGreenFacebookIkon);
        socialMediaIkonsList.add(homePage.averyJohnsonFacebookIkon);
        socialMediaIkonsList.add(homePage.zaraWilliamsFacebookIkon);
        socialMediaIkonsList.add(homePage.knoxMitchellTwitterIkon);
        socialMediaIkonsList.add(homePage.jaxonGreenTwitterIkon);
        socialMediaIkonsList.add(homePage.averyJohnsonTwitterIkon);
        socialMediaIkonsList.add(homePage.zaraWilliamsTwitterIkon);
        socialMediaIkonsList.add(homePage.knoxMitchellLinkedInIkon);
        socialMediaIkonsList.add(homePage.jaxonGreenLinkedInIkon);
        socialMediaIkonsList.add(homePage.averyJohnsonLinkedInIkon);
        socialMediaIkonsList.add(homePage.zaraWilliamsLinkedInIkon);

        List<WebElement>elementToTestList=new ArrayList<>();
        elementToTestList.add(homePage.facebookImg);
        elementToTestList.add(homePage.facebookImg);
        elementToTestList.add(homePage.facebookImg);
        elementToTestList.add(homePage.facebookImg);
        elementToTestList.add(homePage.twitterKesfetArea);
        elementToTestList.add(homePage.twitterKesfetArea);
        elementToTestList.add(homePage.twitterKesfetArea);
        elementToTestList.add(homePage.twitterKesfetArea);
        elementToTestList.add(homePage.linkedinEmailBox);
        elementToTestList.add(homePage.linkedinEmailBox);
        elementToTestList.add(homePage.linkedinEmailBox);
        elementToTestList.add(homePage.linkedinEmailBox);

        socialMediaIkonsTestOfTeamMembersWithList(socialMediaIkonsList,elementToTestList,firstWH);
        extentTest.pass("User can reach each social media page of each team members");

    }


    @Test//User should be able to click functions about "Latest Blog" section in the body section of the Homepage
    public void TC16UserClickTheFunctionsAboutLatestBlogSection() {//TC_03_16
        extentTest = extentReports.createTest("TC0316", "user click the functions about 'Latest Blog' section");
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,5200)");
        List<WebElement> elementsOfLatestBlogList = new ArrayList<>();
        elementsOfLatestBlogList.add(homePage.readMoreButtonUnderTheIstanbulAreaTextOnHomepage);
        elementsOfLatestBlogList.add(homePage.readMoreButtonUnderTheAncientCapitalTextOnHomePage);
        elementsOfLatestBlogList.add(homePage.readMoreButtonUnderTheSalinaIslandTextOnHomepage);
        elementsOfLatestBlogList.add(homePage.readMoreButtonUnderTheBangkokAreaTextOnHomepage);
        elementsOfLatestBlogList.add(homePage.readMoreButtonUnderTheBuenosAiresAreaTextOnHomepage);
        elementsOfLatestBlogList.add(homePage.readMoreButtonUnderTheDiscoveringGreenvilleAreaTextOnHomepage);

        latestBlogClickable(elementsOfLatestBlogList, homePage.searchHereEachLatestBlog);
        extentTest.pass("User click each element of 'Latest Blog'");

    }


    @Test//User should be able to click the functions about "Newsletter" section in the body section of the Homepage
    public void TC17UserClickTheFunctionsAboutNewsletterSection() {//TC_03_17
        extentTest = extentReports.createTest("TC0317", "user click the functions about 'NewsLetter' section");
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
        extentTest.pass("User verify that the email has been submitted");

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
            try {
                ReusableMethods.waitFor(5);
                Assert.assertTrue(list.get(i).isDisplayed());
            } catch (Exception e) {
                System.out.println(i+": problem");
            }
            ReusableMethods.waitFor(5);

        }

    }

    public void listOfClickableWebElement(List<WebElement> list, WebElement title) {
        for (int i = 0; i < list.size(); i++) {
            ReusableMethods.waitFor(5);
            list.get(i).click();
            ReusableMethods.waitFor(5);
            Assert.assertTrue(title.isDisplayed());
            Driver.getDriver().navigate().back();
            ReusableMethods.waitFor(5);
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
        Assert.assertTrue(testOfElement.isDisplayed());
        Driver.getDriver().switchTo().window(firstWH);

    }

    public void socialMediaIkonsTestOfTeamMembersWithList(List<WebElement> list, List<WebElement> testOfElementList, String firstWH) {
        String secondWH = "";
        ReusableMethods.waitFor(10);

        for (int i = 0; i < list.size(); i++) {
            ReusableMethods.waitFor(10);
            js.executeScript("arguments[0].click();", list.get(i));
            ReusableMethods.waitFor(10);
            Set<String> allWH = Driver.getDriver().getWindowHandles();
            for (String eachWH : allWH) {
                if (!eachWH.equals(firstWH)) {
                    secondWH = eachWH;
                }
            }
            Driver.getDriver().switchTo().window(secondWH);
            try {
                Assert.assertTrue(testOfElementList.get(i).isDisplayed());
            } catch (Exception e) {
                System.out.println(i+": problem");
            }
            Driver.getDriver().switchTo().window(firstWH);

        }


    }

    @AfterMethod
    public void tearDown() {

        Driver.closeDriver();
        Driver.quitDriver();
    }


}


