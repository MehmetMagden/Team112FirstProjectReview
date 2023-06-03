package tests.Elcin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ElcinPages {

    public ElcinPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@data-wow-delay='0.4s'])[2]")
    public WebElement footerRecentPosts;

    @FindBy(xpath = "(//a[text()='Contact'])[2]")
    public WebElement homePageContactButton;

    //(//a[@href='https://qa.tripandway.com/category/city-guide'])[2]

    @FindBy (xpath = "(//a)[145]")
    public WebElement recentPostsFirstLink;

    @FindBy (xpath = "(//a[@href='https://qa.tripandway.com/category/city-guide'])[2]")
    public WebElement recentPostsLinkCommonExpectedText;
















}
