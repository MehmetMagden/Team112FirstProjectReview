package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AboutUsPage {

    public AboutUsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//a[normalize-space()='About Us'])[2]")
    public WebElement aboutUsHeaderLink;


    @FindBy (xpath = "//button[@type='button']")
    public WebElement acceptCookies;

    @FindBy (xpath = "//h3[normalize-space()='OUR MISSION']")
    public WebElement aboutUsPageOurMission;

    @FindBy (xpath = "//h3[normalize-space()='OUR VISION']")
    public WebElement AboutUsPageOurVision;

    @FindBy (xpath = "//div[@class='banner-text']")
    public WebElement aboutUsBanner;

}
