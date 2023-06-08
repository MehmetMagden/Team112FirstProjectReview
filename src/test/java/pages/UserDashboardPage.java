package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserDashboardPage {

    public UserDashboardPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Payment History")
    public WebElement paymentHistory;


    @FindBy(xpath = "//iframe[@title='PayPal']")                   //iframe[@aria-hidden='true']
    public WebElement iFrame;

    @FindBy(xpath = "//input[@id='card_number']")               // @FindBy(xpath = "//input[@autocompletetype='cc-number']")
    public WebElement creditCard;




}
