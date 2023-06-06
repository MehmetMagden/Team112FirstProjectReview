package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }

    //==============HEADER==================

    @FindBy(xpath = "//a[@href='https://qa.tripandway.com']")
    public WebElement homeButtonInHeader;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/services'])[2]")
    public WebElement servicesButtonInHeader;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/destination'])[2]")
    public WebElement destinationsButtonInHeader;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/package'])[2]")
    public WebElement packagesButtonButtonInHeader;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/about'])[2]")
    public WebElement aboutUsButtonInHeader;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/faq'])[2]")
    public WebElement faqButtonInHeader;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/blog'])[2]")
    public WebElement blogButtonInHeader;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/contact'])[2]")
    public WebElement contactButtonInHeader;

    @FindBy (xpath = "(//img[@alt='Logo'])[1]")
    public WebElement logoOfCompanyInHeader;

    @FindBy(xpath = "//a[@href='https://qa.tripandway.com/traveller/register']")
    public WebElement registrationButtonInHeader;

    @FindBy(xpath = "//a[@href='https://qa.tripandway.com/traveller/login']")
    public WebElement logInButtonInHeader;

    @FindBy(xpath = "//p[@xpath='1']")
    public WebElement infosectionInHeader;

    //==============================================

    //===============HERO AREA==================
    @FindBy(xpath = "(//div[@class='container'])[6]")
    public WebElement theWorldIsSoBeautifulAreaOnHomepage;

   @FindBy(xpath = "(//a[text()='Read More'])[4]")
    public WebElement readMoreButtonUnderTheWorldIsSoBeautifulText;

   @FindBy(xpath = "(//div[@class='container'])[7]")
    public WebElement salinaIslandAreaOnHomepage;

   @FindBy(xpath = "(//a[text()='Read More'])[5]")
    public WebElement readMoreButtonUnderSalinaIslandAreaText;

   @FindBy(xpath = "(//div[@class='container'])[5]")
    public  WebElement exploreTheWorldArea;

   @FindBy(xpath = "(//a[text()='Read More'])[3]")
    public WebElement readMoreButtonUnderExploreTheWorldAreaText;

   @FindBy(xpath = "(//div[@class='owl-prev'])[1]")
    public WebElement sliderOnLeftSideOfHeroArea;

   @FindBy(xpath = "(//div[@class='owl-next'])[1]")
    public WebElement sliderOnRightSideOfHeroArea;


//=============================================================================================
    //======================OUR SERVICES========================

    @FindBy(xpath = "//h2[text()='Our Services']")
    public WebElement ourServicesTitleTextOnHomePage;

    @FindBy(xpath = "(//div[@class='main-headline'])[1]")
    public WebElement ourServicesAreaOnHomepage;

    @FindBy(xpath = "//a[@href='https://qa.tripandway.com/service/international-tour']")
    public WebElement internationalTourElementOnHomePage;

    @FindBy(xpath = "//a[@href='https://qa.tripandway.com/service/adventure-tour']")
    public WebElement adventureTourElementOnHomePage;

    @FindBy(xpath = "//a[@href='https://qa.tripandway.com/service/culture-tour']")
    public WebElement cultureTourElementOnHomePage;

    @FindBy(xpath = "//a[@href='https://qa.tripandway.com/service/bussiness-tour']")
    public WebElement bussinessTourElementOnHomePage;

    @FindBy(xpath = "//a[@href='https://qa.tripandway.com/service/health-tour']")
    public WebElement healthTourElementOnHomePage;

    @FindBy(xpath = "//a[@href='https://qa.tripandway.com/service/religious-tour']")
    public WebElement religiousTourElementOnHomePage;


    //================================FEATURED PACKAGES======================================

    @FindBy(xpath = "(//div[@class='main-headline'])[2]")
    public WebElement featuredAreaOnHomePage;

    @FindBy(xpath = "(//div[@class='featured-item wow fadeIn'])[1]")
    public WebElement featurePackagesFirstPictureOnHomePage;

    @FindBy(xpath = "(//div[@class='featured-item wow fadeIn'])[2]")
    public WebElement featurePackagesSecondPictureOnHomePage;

    @FindBy(xpath = "(//div[@class='featured-item wow fadeIn'])[3]")
    public WebElement featurePackagesThirdPictureOnHomePage;

    @FindBy(xpath = "(//div[@class='featured-item wow fadeIn'])[4]")
    public WebElement featurePackagesFourthPictureOnHomePage;

    @FindBy(xpath = "(//div[@class='owl-dot'])[3]")
    public WebElement firstIndicatorUnderFeaturedPackagesTitleOnHomePage;

    @FindBy(xpath = "(//div[@class='owl-dot active'])[2]")
    public WebElement secondIndicatorUnderFeaturedPackagesTitleOnHomePage;

 //==========================COUNTER AREA==============================

    @FindBy(xpath = "(//div[@class='counterup-area pt_70 pb_100'])[1]")
    public WebElement counterArea;



    //=========================DESTINATION ON HOMEPAGE========================


    @FindBy(xpath = "(//div[@class='main-headline'])[3]")
    public WebElement destinationAreaOnHomePage;

    @FindBy(xpath = "(//div[@class='col-md-4 col-xs-6 clear-three wow fadeIn'])[7]")
    public WebElement firstPictureAboutBangkokUnderTheDestinationOnHomePage;

    @FindBy(xpath = "(//div[@class='col-md-4 col-xs-6 clear-three wow fadeIn'])[8]")
    public WebElement secondPictureAboutGreenvilleUnderTheDestinationOnHomePage;

    @FindBy(xpath = "(//div[@class='col-md-4 col-xs-6 clear-three wow fadeIn'])[9]")
    public WebElement thirdPictureAboutBuenosAiresUnderTheDestinationOnHomePage;

    @FindBy(xpath = "(//div[@class='col-md-4 col-xs-6 clear-three wow fadeIn'])[10]")
    public WebElement fourthPictureAboutMarrakeshUnderTheDestinationOnHomePage;

    @FindBy(xpath = "(//div[@class='col-md-4 col-xs-6 clear-three wow fadeIn'])[11]")
    public WebElement fifthPictureAboutSalinaIslandUnderTheDestinationOnHomePage;

    @FindBy(xpath = "(//div[@class='col-md-4 col-xs-6 clear-three wow fadeIn'])[12]")
    public WebElement sixthPictureAboutIstanbulUnderTheDestinationOnHomePage;

    @FindBy(xpath = "//a[text()='See All Destinations']")
    public WebElement seeAllDestinationsButtonOnHomepage;
    //==============================================================================================
    //TEAM MEMBERS ON HOMEPAGE

    //Zara Williams
    @FindBy(xpath = "(//div[@class='main-headline'])[4]")
    public WebElement teamMembersAreaOnHomepage;

    @FindBy(xpath = "(//div[@class='team-item wow fadeIn'])[6]")
    public WebElement zaraWilliams;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/team-member/zara-williams'])[3]")
    public WebElement zaraWilliamsText;

    @FindBy(xpath = "(//i[@class='fab fa-facebook-f'])[6]")
    public WebElement zaraWilliamsFacebookIkon;

    @FindBy(xpath = "(//a[@href='http://www.twitter.com'])[6]")
    public WebElement zaraWilliamsTwitterIkon;

    @FindBy (xpath = "(//a[@href='http://www.linkedin.com'])[6]")
    public WebElement zaraWilliamsLinkedInIkon;

    @FindBy(xpath = "https://qa.tripandway.com/team-member/zara-williams")
    public WebElement zaraWilliamsPageUrl;

  //Jaxon Green


    @FindBy(xpath = "(//div[@class='team-item wow fadeIn'])[7]")
    public WebElement jaxonGreen;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/team-member/jaxon-green'])[2]")
    public WebElement jaxonGreenText;

    @FindBy(xpath = "(//i[@class='fab fa-facebook-f'])[7]")
    public WebElement jaxonGreenFacebookIkon;

    @FindBy(xpath = "(//a[@href='http://www.twitter.com'])[7]")
    public WebElement jaxonGreenTwitterIkon;

    @FindBy(xpath = "(//a[@href='http://www.linkedin.com'])[7]")
    public WebElement jaxonGreenLinkedInIkon;

    @FindBy(xpath = "https://qa.tripandway.com/team-member/jaxon-green")
    public WebElement jaxonGreenPageUrl;

    //AVERY JOHNSON

    @FindBy(xpath = "(//div[@class='team-item wow fadeIn'])[8]")
    public WebElement averyJohnson;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/team-member/avery-johnson'])[3]")
    public WebElement averyJohnsonText;

    @FindBy(xpath = "(//i[@class='fab fa-facebook-f'])[8]")
    public WebElement averyJohnsonFacebookIkon;

    @FindBy(xpath = "(//a[@href='http://www.twitter.com'])[8]")
    public WebElement averyJohnsonTwitterIkon;

    @FindBy(xpath = "(//a[@href='http://www.linkedin.com'])[8]")
    public WebElement averyJohnsonLinkedInIkon;

    @FindBy(xpath = "https://qa.tripandway.com/team-member/avery-johnson")
    public WebElement averyJohnsonPageUrl;

    //KNOW MITCHELL

    @FindBy(xpath = "(//div[@class='team-item wow fadeIn'])[9]")
    public WebElement knoxMitchell;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/team-member/knox-mitchell'])[3]")
    public WebElement knoxMitchellText;

    @FindBy(xpath = "(//i[@class='fab fa-facebook-f'])[9]")
    public WebElement knoxMitchellFacebookIkon;

    @FindBy(xpath = "(//a[@href='http://www.twitter.com'])[9]")
    public WebElement knoxMitchellTwitterIkon;

    @FindBy(xpath = "(//a[@href='http://www.linkedin.com'])[9]")
    public WebElement knoxMitchellLinkedInIkon;

    @FindBy (xpath = "https://qa.tripandway.com/team-member/knox-mitchell")
    public WebElement knoxMitchellPageUrl;

    //=============================TESTİMONIAL ON HOMEPAGE===================================


    @FindBy(xpath = "//h2[text()='Testimonial']")
    public WebElement testimonialTextHomePage;

    @FindBy(xpath = "//p[text()='Our happy clients always recommend our travel agency']")
    public WebElement textUnderTheTestimonial;

    @FindBy(xpath = "(//div[@class='testimonial-item'])[4]")
    public WebElement jessicaRainyArea;

    @FindBy(xpath = "(//div[@class='testimonial-item'])[2]")
    public WebElement dadivSmithArea;

    @FindBy(xpath = "(//div[@class='testimonial-item'])[1]")
    public WebElement johnsonShealeyArea;

    @FindBy(xpath = "(//div[@class='testimonial-item'])[3]")
    public WebElement stefanCarmanArea;

    @FindBy(xpath = "(//div[@class='owl-dot'])[4]")
    public WebElement indicator1UnderTestimonialTitleOnHomePage;

    @FindBy(xpath = "(//div[@class='owl-dot'])[5]")
    public WebElement indicator2UnderTestimonialTitleOnHomePage;

    @FindBy(xpath = "(//div[@class='owl-dot'])[6]")
    public WebElement indicator3UnderTestimonialTitleOnHomePage;

    @FindBy(xpath = "(//div[@class='owl-dot active'])[4]")
    public WebElement indicator4UnderTestimonialTitleOnHomePage;

    //================================LATEST BLOG==========================================


    @FindBy(xpath = "(//div[@class='main-headline'])[5]")
    public WebElement latestBlogAreaText;

    @FindBy(xpath = "(//i[@class='fas fa-angle-right'])[3]")
    public WebElement sliderRightSideUnderTheLatestBlogOnHomePage;

    @FindBy(xpath = "(//div[@class='owl-prev'])[5]")
    public WebElement sliderLeftSideUnderTheLatestBlogOnHomePage;

    @FindBy(xpath = "(//div[@class='blog-item wow fadeIn'])[6]")
    public WebElement discoveringTheAncientCapitalAreaOnHomepage;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/blog/discovering-the-ancient-capital-of-the-hittites'])[3]")
    public WebElement readMoreButtonUnderTheAncientCapitalTextOnHomePage;

    @FindBy(xpath = "(//div[@class='blog-item wow fadeIn'])[7]")
    public WebElement salinaIslandAreaUnderTheLatesBlogOnHomepage;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/blog/salina-island-perfect-family-getaway'])[3]")
    public WebElement readMoreButtonUnderTheSalinaIslandTextOnHomepage;

    @FindBy(xpath = "(//div[@class='blog-item wow fadeIn'])[8]")
    public WebElement bangkokAreaUnderTheLatestBlogOnHomepage;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/blog/bangkok-a-city-of-contrasts'])[3]")
    public WebElement readMoreButtonUnderTheBangkokAreaTextOnHomepage;

    @FindBy(xpath = "(//div[@class='blog-item wow fadeIn'])[9]")
    public WebElement buenosAiresAreaUnderTheLatestBlogOnHomePage;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/blog/buenos-aires-the-paris-of-south-america'])[6]")
    public WebElement readMoreButtonUnderTheBuenosAiresAreaTextOnHomepage;

    @FindBy(xpath = "(//div[@class='blog-item wow fadeIn'])[10]")
    public WebElement discoveringGreenvilleAreaUnderTheLatestBlogOnHomePage;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/blog/discovering-greenville-a-hidden-gem-in-south-carolina'])[6]")
    public WebElement readMoreButtonUnderTheDiscoveringGreenvilleAreaTextOnHomepage;

    @FindBy(xpath = "(//div[@class='blog-item wow fadeIn'])[13]")
    public WebElement istanbulAreaUnderTheLatestBlogOnHomePage;

    @FindBy(xpath = "(//a[normalize-space()='Read More'])[20]")
    public WebElement readMoreButtonUnderTheIstanbulAreaTextOnHomepage;


//===================================OUR CLİENTS ON HOMEPAGE==============================================

    @FindBy(xpath = "(//div[@class='container wow fadeIn'])[8]")
    public WebElement ourClientAreaOnHomePage;
//========================================================================================================
    //===============================NEWSLETTER ON HOMEPAGE===========================================
    @FindBy(xpath = "(//div[@class='col'])[1]")
    public WebElement newsLetterAreaTextOnHomepage;

    @FindBy(xpath = "(//input[@placeholder='Email Address'])[1]")
    public WebElement emailBoxUnderTheNewsLetterOnHomepage;

    @FindBy(xpath = "(//input[@value='Submit'])[1]")
    public WebElement submitButtonUnderTheNewsLetterOnHomepage;






}
