package tests.Elcin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Elcin {


    @FindBy(xpath = "(//div[@data-wow-delay='0.4s'])[2]")
    public WebElement footerRecentPosts;

    @FindBy(xpath = "(//a)[154]")
    public WebElement recentPostsFirstLink;


    @FindBy(xpath = "(//a)[155]")
    public WebElement recentPostsSecondLink;



    @FindBy(xpath = "(//a)[156]")
    public WebElement recentPostsThirdLink;

    @FindBy(xpath = "(//a)[157]")
    public WebElement recentPostsFourthLink;


    @FindBy(xpath = "(//a)[158]")
    public WebElement recentPostsFifthLink;

    @FindBy (xpath = "//h3[text()='Comments']")
    public WebElement recentPostsLinkExpectedWord;

    @FindBy(xpath = "(//h3)[5]")
    public WebElement recentPostsSecondAndThirdExpectedWord;

    @FindBy(xpath ="(//h3)[3]")
    public WebElement getRecentPostsFourthAndFifthLinkExpectedWord;
















}
