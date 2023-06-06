package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }

    //HEADER

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

    //HERO AREA
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
    //OUR SERVICES

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




    //===================================================================================================




}
