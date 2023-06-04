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
    public WatchEvent adminLoginEmailAdressTextBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement adminLogInPasswordTextBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement adminLogInButton;

    @FindBy (xpath = "//span[normalize-space()='General Settings']")
    public WebElement adminDashboardGeneralSettingsButton;

    @FindBy (xpath = "//button[@id='sidebarToggle']")
    public WebElement dropdownArrowSymbolButtonInAdminPage;

    @FindBy (xpath = "//a[normalize-space()='Visit Website']")
    public WebElement visitWebsiteButtonAtTheTopOfAdminPage;


    }

