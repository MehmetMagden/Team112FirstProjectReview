package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomeBase {

    public HomeBase(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//button[text()='ACCEPT']")
    public WebElement acceptCookiesButton;

    @FindBy (xpath = "(//a[text()='Destinations'])[2]")
    public WebElement homePageDestinationsButton;



}
