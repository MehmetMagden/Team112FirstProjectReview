package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {


    public RegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//input[@name='traveller_name']")
    private WebElement registrationNameBox;

    @FindBy(xpath = "//input[@name='traveller_email']")
    private WebElement registrationEmailBox;

    @FindBy(xpath = "//input[@name='traveller_password']")
    private   WebElement registrationPasswordBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    // bu butona ait text daha unique oldugu icin text ile locate etmek daha iyi olabilir mi
    public WebElement makeRegistrationButton;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    @FindBy(className = "toast-message")
    public WebElement actualRegistrationMessage;

    public void fillInRegistrationForm(String name, String email, String password){
        registrationNameBox.sendKeys(name);
        registrationEmailBox.sendKeys(email);
        registrationPasswordBox.sendKeys(password);
    }

}
