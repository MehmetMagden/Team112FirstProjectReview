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

    @FindBy (xpath = "(//div[@class='row'])[4]")
    public WebElement featuredPackagesAllTogether;

    @FindBy(xpath = "(//div[@class='photo-title'])[4]")
    public WebElement buenosAiresPackageInPackagesPage;

    @FindBy(xpath = "//div[@class='photo-title']//a[contains(text(),'3 days in Bangkok')]")
    public WebElement buenosAiresPackageInPackagesPage2;





}
