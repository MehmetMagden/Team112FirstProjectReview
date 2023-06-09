package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ServicesPage {

    public ServicesPage() {
        PageFactory.initElements(Driver.getDriver(), this);


    }


    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/services'])[2]")
    public static WebElement HeaderServicesButton;


    @FindBy(xpath = "(//div[@class='row'])")
    public static WebElement ServiceItems;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/service/international-tour'])")
    public static WebElement ServiceInternationalTOurItem;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/service/adventure-tour'])")
    public static WebElement ServiceAdventureTourItem;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/service/culture-tour'])")
    public static WebElement ServiceCultureTourItem;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/service/bussiness-tour'])")
    public static WebElement ServiceBusinessTOurItem;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/service/health-tour'])")
    public static WebElement ServiceHealthTOurItem;

    @FindBy(xpath = "(//a[@href='https://qa.tripandway.com/service/religious-tour'])")
    public static WebElement ServiceReligiousTOurItem;




}
