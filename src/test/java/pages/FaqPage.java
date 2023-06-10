package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FaqPage {

    public FaqPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath = "//ul[@id='menu']//a[normalize-space()='FAQ']")
    public WebElement faqHeaderLink;

     @FindBy (xpath = "//h1[normalize-space()='FAQ']")
     public WebElement faqBannerText;


    @FindBy (xpath = "(//button[@type='button'])[2]")
    public WebElement faqQuestionOne;

    @FindBy (xpath = "(//button[@type='button'])[3]")
    public WebElement faqQuestionTwo;

//    @FindBy (xpath = "(//button[@type='button'])[4]")
//    public WebElement faqQuestionThree;

    @FindBy (xpath = "//button[normalize-space()='How do I make a reservation?']")
    public WebElement faqQuestionThree;
    @FindBy (xpath = "(//button[@type='button'])[5]")
    public WebElement faqQuestionFour;

    @FindBy (xpath = "(//button[@type='button'])[6]")
    public WebElement faqQuestionFive;

    @FindBy (xpath = "(//button[@type='button'])[7]")
    public WebElement faqQuestionSix;

    @FindBy (xpath = "(//button[@type='button'])[8]")
    public WebElement faqQuestionSeven;

    @FindBy (xpath = "(//button[@type='button'])[9]")
    public WebElement faqQuestionEight;
    @FindBy (xpath = "(//button[@type='button'])[10]")
    public WebElement faqQuestionNine;
    @FindBy (xpath = "(//button[@type='button'])[11]")
    public WebElement faqQuestionTen;

    @FindBy (xpath = "//div[@class='accordion-body']")
    public WebElement faqText;

}
