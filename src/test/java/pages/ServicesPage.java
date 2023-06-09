package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ServicesPage {

    public ServicesPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }
    @FindBy(tagName = "//h1")
    public WebElement titleOfPackage;

    @FindBy(xpath = "//a[@href='https://qa.tripandway.com/service/international-tour']")
    public WebElement internationalTourButton;





}
