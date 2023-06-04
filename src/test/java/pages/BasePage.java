package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//button[text()='ACCEPT']")
    public WebElement acceptCookiesButton;

    @FindBy (xpath = "(//a[text()='Destinations'])[2]")
    public WebElement homePageDestinationsButton;

    @FindBy(xpath = "(//a[text()='Contact'])[2]")
    public WebElement homePageContactButton;

    @FindBy (xpath = "//ul[@id='menu']//a[normalize-space()='Home']") // Including BlogButton the locators here,
    public WebElement homePageHomeButton;                             //  except for destinations and contact,
                                                                      //  are for header menus on the home page
    @FindBy (xpath = "//ul[@id='menu']//a[normalize-space()='Services']")
    public WebElement homePageServicesButton;

    @FindBy (xpath = "//ul[@id='menu']//a[normalize-space()='Packages']")
    public WebElement homePagePackagesButton;

    @FindBy (xpath = "//ul[@id='menu']//a[normalize-space()='About Us']")
    public WebElement homePageAboutUsButton;

    @FindBy (xpath = "//ul[@id='menu']//a[normalize-space()='FAQ']")
    public WebElement homePgeFaqButton;

    @FindBy (xpath = "//ul[@id='menu']//a[normalize-space()='Blog']")  // the last header menu
    public WebElement homePageBlogButton;

    @FindBy (xpath = "//h3[normalize-space()='Featured Packages']") // locators here are for the Featured Packages section in the footer
    public WebElement featuredPackagesInFooter;

    @FindBy (xpath = "//div[@class='footer-item mt_30']//a[contains(text(),'3 days in Buenos Aires')]")
    public WebElement threeDaysInBuenosAiresButtonInFooter;

    @FindBy (xpath = "//div[@class='footer-item mt_30']//a[contains(text(),'10 days in Buenos Aires')]")
    public WebElement tenDaysInBuenosAiresButtonInFooter;

    @FindBy (xpath = "//div[@class='col-md-3 col-sm-6 wow fadeInLeft']//a[contains(text(),'3 days in Bangkok')]")
    public WebElement threeDaysInBangkokButtonInFooter;

    @FindBy (xpath = "//div[@class='col-md-3 col-sm-6 wow fadeInLeft']//a[contains(text(),'7 days in Salina Island')]")
    public WebElement sevenDaysInSalinaIslandButtonInFooter;

    @FindBy (xpath = "//div[@class='col-md-3 col-sm-6 wow fadeInLeft']//a[normalize-space()='5 Day California']")
    public WebElement fiveDayCaliforniaButtonInFooter;

    @FindBy (xpath = "//h3[normalize-space()='Latest Packages']") // locators here are for the Latest Packages section in the footer
    public WebElement latestPackagesInFooter;

    @FindBy (xpath = "//a[normalize-space()='Test Deneme']")
    public WebElement testDenemeButtonInFooter;

    @FindBy (xpath = "//div[@class='col-md-3 col-sm-6 wow fadeIn']//a[normalize-space()='5 Day California']")
    public WebElement fiveDayCaliforniaButtonInLatestPackagesInFooter;

    @FindBy (xpath = "//div[@class='col-md-3 col-sm-6 wow fadeIn']//a[contains(text(),'7 days in Salina Island')]")
    public WebElement sevenDaysInSalinaIslandButtonInLatestPackagesInFooter;

    @FindBy (xpath = "//div[@class='col-md-3 col-sm-6 wow fadeIn']//a[contains(text(),'3 days in Bangkok')]")
    public WebElement threeDaysInBangkokButtonInLatestPackagesInFooter;

    @FindBy (xpath = "//a[normalize-space()='7 days in Istanbul']")
    public WebElement sevenDaysInIstanbulButtonInLatestPackagesInFooter;







}
