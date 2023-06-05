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
    public WebElement registrationNameBox;

    @FindBy(xpath = "//input[@name='traveller_email']")
    public WebElement registrationEmailBox;

    @FindBy(xpath = "//input[@name='traveller_password']")
    public  WebElement registrationPasswordBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement makeRegistrationButton;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;
}
