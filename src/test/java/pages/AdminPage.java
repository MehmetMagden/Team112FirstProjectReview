package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.nio.file.WatchEvent;

public class AdminPage {
    public  AdminPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//input[@id='email']")
    public WebElement adminLoginEmailAdressTextBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement adminLogInPasswordTextBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement adminLogInButton;

    @FindBy (xpath = "//span[normalize-space()='General Settings']")
    public WebElement adminDashboardGeneralSettingsButton;

    @FindBy (xpath = "//span[text()='Page Settings']")
    public  WebElement adminDashboardPageSettingsButton;

    @FindBy(xpath = "//span[text()='Payment Settings']")
    public WebElement adminDashboardPaymentSettingsButton;

    @FindBy(xpath = "//span[text()='Dynamic Pages']")
    public WebElement adminDashboardDynamicPagesButton;

    @FindBy(xpath = "//span[text()='Language']")
    public WebElement adminDashboardLanguageButton;

    @FindBy(xpath = "//span[text()='Website Section']")
    public WebElement adminDashboardWebsiteSectionButton;

    @FindBy(xpath = "//span[text()='Email Template']")
    public  WebElement adminDashBoardEmailTemplateButton;

    @FindBy (xpath = "//button[@id='sidebarToggle']")
    public WebElement dropdownArrowSymbolButtonInAdminPage;

    @FindBy (xpath = "//a[normalize-space()='Visit Website']")
    public WebElement visitWebsiteButtonAtTheTopOfAdminPage;

    @FindBy(id ="userDropdown")
    public WebElement adminDropDownButton;
    @FindBy(className= "dropdown-item")
    public WebElement changeAdminPassword;


    }

