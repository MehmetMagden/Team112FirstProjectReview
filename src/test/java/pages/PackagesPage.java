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

    @FindBy (xpath = "(//div[@class='banner-text'])[1]")
    public WebElement packagesBannerText;

    @FindBy (xpath = "(//div[@class='row'])[4]")
    public WebElement featuredPackagesAllTogether;

   @FindBy (xpath = "/html/body/div[7]/div/div[2]/div[1]/div[2]")
   public WebElement theFirstPackagesWebElement;

//   @FindBy (xpath = "(//div[@class='photo-title'])[2]")
//    public WebElement theFirstPackagesWebElement;

   @FindBy (xpath = "(//h1[contains(text(),'3 days in Buenos Aires')])[1]")
    public WebElement theFirstPackageBannerText;

   @FindBy (xpath = "(//ul[@id='pills-tab'])[1]")
   public WebElement moreInformationVisibility;


}
