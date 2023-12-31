package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PackagesPage {

    public PackagesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//a[normalize-space()='Packages'])[2]")
    public WebElement packagesHeaderLink;


    @FindBy(xpath = "(//*[text()='Packages'])[2]")
    public WebElement packagesHeaderLink2;  // alternative to the one above

    @FindBy (xpath = "(//h1[normalize-space()='Packages'])[1]")
    public WebElement packagesBanner;

    @FindBy (xpath = "(//div[@class='banner-text'])[1]")
    public WebElement packagesBannerText;


    @FindBy (xpath = "(//div[@class='row'])[4]")
    public WebElement featuredPackagesAllTogether;



    @FindBy(xpath = "(//div[@class='photo-title'])[4]")
    public WebElement buenosAiresPackageInPackagesPage;

    @FindBy(xpath = "//div[@class='photo-title']//a[contains(text(),'3 days in Bangkok')]")
    public WebElement buenosAiresPackageInPackagesPage2;




   @FindBy (xpath = "/html/body/div[7]/div/div[2]/div[1]/div[2]")
   public WebElement theFirstPackagesWebElement;


//   @FindBy (xpath = "(//div[@class='photo-title'])[2]")
//    public WebElement theFirstPackagesWebElement;

   @FindBy (xpath = "(//h1[contains(text(),'3 days in Buenos Aires')])[1]")
    public WebElement theFirstPackageBannerText;

   @FindBy (xpath = "//h4[normalize-space()='More Information']")
   public WebElement moreInformationVisibility;


   @FindBy (xpath = "//h4[text()='Tour Dates']")
   public WebElement tourDatesText;

    @FindBy(xpath = "//h4[text()='Book Now']")
    public WebElement bookNowText;


   @FindBy (xpath = "//a[@href='https://qa.tripandway.com/package/7-days-in-istanbul']")
    public WebElement theThirdPackages;

   @FindBy (xpath = "//a[@href='https://qa.tripandway.com/package/10-days-in-buenos-aires'] ")
    public WebElement theSecondPackages;


}
