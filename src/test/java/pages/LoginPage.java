package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.logging.XMLFormatter;

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

    //PAYMENT HİSTORY
    //paymentHistoryButton=(//a[normalize-space()='Payment History'])[1]
    //viewAllPaymentElement=(//div[@class='detail-dashboard table-responsive mt_30'])[1]

    @FindBy(xpath = "(//a[normalize-space()='Payment History'])[1]")
    public WebElement paymentHistoryButtonInUserLoginPage;

    @FindBy(xpath = "(//div[@class='detail-dashboard table-responsive mt_30'])[1]")
    public WebElement viewAllPaymentElementInPaymentElementOnLoginPage;

    @FindBy(xpath = "//div/a[text()='Login']")
    public WebElement loginPageLoginButton2;   // alternative to the one above

    @FindBy(xpath = "//li/a[text()='Dashboard']")
    public WebElement userDashboard;

    @FindBy(linkText = "Logout")
    public WebElement logOutButton;


//===============Profile Edition========================//

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/traveller/profile-change'])")
    public WebElement UpdateProfile;
    @FindBy(xpath= "(//input[@type='text'])")
    public WebElement Name;
    @FindBy(xpath= "(//button[@type='submit'])")
    public WebElement Submit;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement adminLoginEmailAdressTextBox;


    @FindBy(xpath = "//input[@id='password']")
    public WebElement adminLogInPasswordTextBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement adminLogInButton;

    // METHODS for quick login as a user or as an admin:

    public void loginAsUser() {
        loginPageLoginButton2.click();
        String username = ConfigReader.get("userLoginEmailCorrect");
        String password = ConfigReader.get("userLoginPasswordCorrect");
        loginPageEmailAddressTextBox.sendKeys(username);
        loginPagePasswordBox.sendKeys(password);
        loginPageLoginButton.click();
    }

    public void loginAsAdmin() {
        String username = ConfigReader.get("adminLoginEmailValid");
        String password = ConfigReader.get("adminLoginPasswordValid");
        adminLoginEmailAdressTextBox.sendKeys(username);
        adminLogInPasswordTextBox.sendKeys(password);
        adminLogInButton.click();

    }

    @FindBy (xpath = "//a[normalize-space()='Update Password']")
    public  WebElement updateLoginPassword;

    @FindBy (xpath = "//input[@name='password']")
    public  WebElement enterNewPassword;

    @FindBy (xpath = "//button[@type='submit']")
    public  WebElement updateNewPassword;

}

