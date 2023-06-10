package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='ACCEPT']")
    public WebElement acceptCookiesButton;

    @FindBy(xpath = "(//a[text()='Destinations'])[2]")
    public WebElement homePageDestinationsButton;

    @FindBy(xpath = "(//a[text()='Contact'])[2]")
    public WebElement homePageContactButton;

    @FindBy(xpath = "//ul[@id='menu']//a[normalize-space()='Home']") // Including BlogButton the locators here,
    public WebElement homePageHomeButton;                             //  except for destinations and contact,
    //  are for header menus on the home page
    @FindBy(xpath = "//ul[@id='menu']//a[normalize-space()='Services']")
    public WebElement homePageServicesButton;

    @FindBy(xpath = "//ul[@id='menu']//a[normalize-space()='Packages']")
    public WebElement homePagePackagesButton;

    @FindBy(xpath = "//ul[@id='menu']//a[normalize-space()='About Us']")
    public WebElement homePageAboutUsButton;

    @FindBy(xpath = "//ul[@id='menu']//a[normalize-space()='FAQ']")
    public WebElement homePgeFaqButton;

    @FindBy(xpath = "//ul[@id='menu']//a[normalize-space()='Blog']")  // the last header menu
    public WebElement homePageBlogButton;

    @FindBy(xpath = "//h3[normalize-space()='Featured Packages']")
    // locators here are for the Featured Packages section in the footer
    public WebElement featuredPackagesInFooter;

    @FindBy(xpath = "//div[@class='footer-item mt_30']//a[contains(text(),'3 days in Buenos Aires')]")
    public WebElement threeDaysInBuenosAiresButtonInFooter;

    @FindBy(xpath = "//div[@class='footer-item mt_30']//a[contains(text(),'10 days in Buenos Aires')]")
    public WebElement tenDaysInBuenosAiresButtonInFooter;

    @FindBy(xpath = "//div[@class='col-md-3 col-sm-6 wow fadeInLeft']//a[contains(text(),'3 days in Bangkok')]")
    public WebElement threeDaysInBangkokButtonInFooter;

    @FindBy(xpath = "//div[@class='col-md-3 col-sm-6 wow fadeInLeft']//a[contains(text(),'7 days in Salina Island')]")
    public WebElement sevenDaysInSalinaIslandButtonInFooter;

    @FindBy(xpath = "//div[@class='col-md-3 col-sm-6 wow fadeInLeft']//a[normalize-space()='5 Day California']")
    public WebElement fiveDayCaliforniaButtonInFooter;

    @FindBy(xpath = "//h3[normalize-space()='Latest Packages']")
    // locators here are for the Latest Packages section in the footer
    public WebElement latestPackagesInFooter;

    @FindBy(xpath = "//a[normalize-space()='Test Deneme']")
    public WebElement testDenemeButtonInFooter;

    @FindBy(xpath = "//div[@class='col-md-3 col-sm-6 wow fadeIn']//a[normalize-space()='5 Day California']")
    public WebElement fiveDayCaliforniaButtonInLatestPackagesInFooter;

    @FindBy(xpath = "//div[@class='col-md-3 col-sm-6 wow fadeIn']//a[contains(text(),'7 days in Salina Island')]")
    public WebElement sevenDaysInSalinaIslandButtonInLatestPackagesInFooter;

    @FindBy(xpath = "//div[@class='col-md-3 col-sm-6 wow fadeIn']//a[contains(text(),'3 days in Bangkok')]")
    public WebElement threeDaysInBangkokButtonInLatestPackagesInFooter;

    @FindBy(xpath = "//a[normalize-space()='7 days in Istanbul']")
    public WebElement sevenDaysInIstanbulButtonInLatestPackagesInFooter;

    @FindBy(xpath = "(//div[@data-wow-delay='0.4s'])[2]")
    public WebElement footerRecentPosts;

    @FindBy(xpath = "(//a)[154]")
    public WebElement recentPostsFirstLink;


    @FindBy(xpath = "(//a)[155]")
    public WebElement recentPostsSecondLink;


    @FindBy(xpath = "(//a)[156]")
    public WebElement recentPostsThirdLink;

    @FindBy(xpath = "(//a)[157]")
    public WebElement recentPostsFourthLink;


    @FindBy(xpath = "(//a)[158]")
    public WebElement recentPostsFifthLink;

    @FindBy(xpath = "//h3[text()='Comments']")
    public WebElement recentPostsLinkExpectedWord;

    @FindBy(xpath = "(//h3)[5]")
    public WebElement recentPostsSecondAndThirdExpectedWord;

    @FindBy(xpath = "(//h3)[3]")
    public WebElement getRecentPostsFourthAndFifthLinkExpectedWord;


    @FindBy(xpath = "(//i[@class='fab fa-facebook-f'])[13]")
    public WebElement footerFacobookIcon;

    @FindBy(xpath = "(//i[@class='fab fa-twitter'])[13]")
    public WebElement footerTwitterIcon;

    @FindBy(xpath = "(//i[@class='fab fa-linkedin-in'])[13]")
    public WebElement footerLinkedinIcon;

    @FindBy(xpath = "//i[@class='fab fa-pinterest-p']")
    public WebElement footerPinterestIcon;

    @FindBy(xpath = "//i[@class='fab fa-instagram']")
    public WebElement footerInstagramIcon;

    @FindBy(xpath = "//i[@class='fas fa-user-plus']")
    public WebElement registrationButton;


    // Page class'taki methodlar, sayfanin en altinda web elementlerden sonra yer almali
    public void acceptCookies() {
        if (acceptCookiesButton.isDisplayed()) {
            acceptCookiesButton.click();
        }
    }

    // FOOTER AREA ====-----======-------========------======
    @FindBy(xpath = "//div[@class='footer-area pt_50 pb_80']")
    public WebElement footerContact;


    @FindBy(xpath = "(//div[@class='footer-address-item'])[1]")
    public WebElement footerAddress;

    @FindBy(xpath = "(//p[normalize-space()='34, Edd Lane, NYC, 22335'])[1]")
    public WebElement footerAddress2;

    @FindBy(xpath = "(//div[@class='text'])[2]")
    public WebElement footerPhone;

    @FindBy(xpath = "(//div[@class='footer-address-item'])[3]")
    public WebElement footerEmail;

    @FindBy (xpath = "//h1[normalize-space()='Services']")
    public WebElement servicesAfterHeaderService;

    @FindBy (xpath = "//h1[normalize-space()='Packages']")
    public WebElement packagesAfterHeaderPackages;

    @FindBy (xpath = "//ul[@id='menu']//a[normalize-space()='FAQ']")
    public WebElement homePageFaqButton;
    @FindBy (xpath = "//h1[normalize-space()='FAQ']")
    public WebElement faqAfterHeaderFaq;
    @FindBy (xpath = "//h1[normalize-space()='Blog']")
    public WebElement blogAfterHeaderBlog;





    // ====-----======-------======-----======-------========

}
