package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {


    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

   @FindBy(xpath = "//button[text()='ACCEPT']")
   public WebElement cookiesAcceptButton;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    public WebElement loginButtonHomePage;

    @FindBy(xpath = "//input[@name='traveller_email']")
    public WebElement loginPageEmailAddressTextBox;

    @FindBy(xpath = "//input[@name='traveller_password']")
    public WebElement loginPagePasswordBox;

    @FindBy(xpath = "//button[@name='form1']")
    public WebElement loginPageLoginButton;






    }

