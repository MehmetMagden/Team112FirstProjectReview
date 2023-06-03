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

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement contactUsSubmitButton;

    @FindBy(xpath = "//input[@title='Your phone number must enter your phone number with the country code and 12 digits and can only contain numbers.']")
    public WebElement incorrectPhoneNumberMessage;



    }

