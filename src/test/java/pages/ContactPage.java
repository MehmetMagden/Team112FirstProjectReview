package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactPage {


    public ContactPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='Name']")
    public WebElement contactUsNameSearchBox;

    @FindBy(xpath = "//input[@name='visitor_phone']")
    public WebElement contactUsPhoneTextBox;

    @FindBy(xpath = "(//input[@placeholder='Email Address'])[1]")
    public WebElement contactUsEmailTextBox;

    @FindBy(xpath = "//textarea[@name='visitor_message']")
    public WebElement contactUsMessageTextBox;

   // @FindBy(xpath = "/html/body/div[7]/div/div[2]/div[1]/div/form/div/button")
   // public WebElement messageSubmitButton;

    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement submitButton;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public  WebElement getSubmitButton2;

    @FindBy(xpath = "//button[@class='wpcc-btn']")  //MSezgin 2ndCookies
    public WebElement acceptButtonContactPage;

    @FindBy(className = "toast.success")
    public WebElement warningMessage;
    @FindBy(xpath = "//input[@title='Your phone number must enter your phone number with the country code and 12 digits and can only contain numbers.']")
    public WebElement incorrectPhoneNumberMessage;

    @FindBy(className = "toastr.success")
    public WebElement messageSent;

 //   @FindBy(xpath = "//div[@class='toast-message']")
 //   public WebElement contactUsMessageSuccessfulySentMessage;


//-------Contact Informations---------------//
    @FindBy(xpath = "(//div[@class='contact-text'])[1]")
    public WebElement contactInformationAddressDetails;

    @FindBy(xpath = "//p[text()='3153 Foley Street']")
    public WebElement contactInfoActualAddress;

    @FindBy(xpath = "(//div[@class='contact-text'])[2]")
    public WebElement contactInformationEmailAddress;

    //@FindBy(xpath = "(//div[@class='contact-text'])[3]")
    // public WebElement contactInformationPhoneNumber;

    @FindBy(xpath = "//p[text()='Office 1: 202-456-3789']")
    public WebElement contactInformationActualPhoneNumber;

    @FindBy(xpath = "(//p[text()='info@tripandway.com'])[2]")
    public WebElement contactInfoActualEmailAddress;


    @FindBy(xpath = "//h4[text()='Address in Map']")
    public WebElement contactInformationAddressMap;


    @FindBy(xpath = "//html/body/div[7]/div/div[2]/div[1]/div/form/div/button")
    public WebElement submitButtonContactPage;



}

