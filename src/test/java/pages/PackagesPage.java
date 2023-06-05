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

    @FindBy (xpath = "(//h1[normalize-space()='Packages'])[1]")
    public WebElement packagesBanner;

    @FindBy (xpath = "(//div[@class='row'])[4]")
    public WebElement featuredPackagesAllTogether;




}
