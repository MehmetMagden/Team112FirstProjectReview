package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlogPage {

    public BlogPage(){PageFactory.initElements(Driver.getDriver(),this);}

    // Blog Section -> Blogs Locators ==========================||||||||
    @FindBy(linkText = "Blog Section")
    public WebElement blogSection;

    @FindBy(linkText = "Blogs")
    public WebElement blogs;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement blogsAddNewButton;

    @FindBy(xpath = "//input[@name='blog_title']")
    public WebElement blogTitle;

    @FindBy(xpath = "//div[@class='note-editable card-block']")
    public WebElement blogContent;

    @FindBy(xpath = "//textarea[@name='blog_content_short']")
    public WebElement blogShortContent;

    @FindBy(xpath = "//input[@name='blog_photo']")
    public WebElement blogPhotoUpload;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitNewBlog;

    @FindBy(xpath = "//td[contains(text(),'New Blog Entry')]")
    public WebElement newBlogEntryCheck;

    @FindBy(xpath = "(//a[@class='btn btn-warning btn-sm'])[8]")
    public WebElement editBlog;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement updateButton;

    @FindBy(xpath = "//td[contains(text(),'EDITED')]")
    public WebElement updateBlogCheck;

    // =========================================================||||||||


}
