package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.logging.XMLFormatter;

public class LoginPage {


    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[normalize-space()='Login']")
    public WebElement loginButtonHomePage;

    @FindBy(xpath = "//input[@name='traveller_email']")
    public WebElement loginPageEmailAddressTextBox;

    @FindBy(xpath = "//input[@name='traveller_password']")
    public WebElement loginPagePasswordBox;

    @FindBy(xpath = "//button[@name='form1']")
    public WebElement loginPageLoginButton;

    @FindBy(xpath = "//div/a[text()='Login']")
    public WebElement loginPageLoginButton2;   // alternative to the one above

    @FindBy(xpath = "//li/a[text()='Dashboard']")
    public WebElement userDashboard;

    @FindBy(linkText = "Logout")
    public WebElement logOutButton;






    }

