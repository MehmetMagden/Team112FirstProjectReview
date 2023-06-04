package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactPage {


    public ContactPage(){
    PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//input[@placeholder='Name']")
    public WebElement contactUsNameSearchBox ;

    @FindBy(xpath = "//input[@name='visitor_phone']")
    public WebElement contactUsPhoneTextBox;

    @FindBy(xpath = "(//input[@placeholder='Email Address'])[1]")
    public  WebElement contactUsEmailTextBox;

    @FindBy(xpath = "//textarea[@name='visitor_message']")
    public WebElement contactUsMessageTextBox;

    @FindBy(xpath = "//button[text()='Submit']")
    public WebElement contactUsMessageSubmitButton;

    @FindBy(xpath = "//input[@title='Your phone number must enter your phone number with the country code and 12 digits and can only contain numbers.']")
    public WebElement incorrectPhoneNumberMessage;


   @FindBy(xpath = "//div[@class='toast-message']")
   public WebElement contactUsMessageSuccessfulySentMessage;

    @FindBy(xpath = "(//div[@class='contact-text'])[1]")
    public  WebElement contactInformationAddressDetails;

    @FindBy(xpath = "(//div[@class='contact-text'])[2]")
    public WebElement contactInformationEmailAddress;

    //@FindBy(xpath = "(//div[@class='contact-text'])[3]")
   // public WebElement contactInformationPhoneNumber;

    @FindBy(xpath = "//p[text()='Office 1: 202-456-3789']")
    public  WebElement contactInformationPhoneNumber;

    @FindBy(xpath = "//div[@class='map-area']")
    public WebElement contactInformationAddressMap;



    }

