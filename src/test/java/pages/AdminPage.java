package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
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

    @FindBy(xpath = "//span[text()='Order']")
    public WebElement adminDashboardOrderButton;

    @FindBy(xpath = "//span[text()='Email Template']")
    public  WebElement adminDashBoardEmailTemplateButton;

    @FindBy (xpath = "//button[@id='sidebarToggle']")
    public WebElement dropdownArrowSymbolButtonInAdminPage;

    @FindBy (xpath = "//a[normalize-space()='Visit Website']")
    public WebElement visitWebsiteButtonAtTheTopOfAdminPage;



    @FindBy(xpath = "(//span[normalize-space()='Order'])[1]")
    public WebElement orderButtonInAdminPanelOnAdminPage;

    @FindBy(xpath = "(//span[normalize-space()='Subscriber'])[1]")
    public WebElement subscriberButtonInAdminPanelOnAdminPage;

    @FindBy(xpath = "(//tr[@role='row'])[2]")
    public WebElement firstInvoiceInViewOrders;

    @FindBy (tagName = "h6")
    public WebElement viewOrdersWebElement;

    @FindBy (id = "dataTable_info")
    public WebElement allOrdersWebElement;

    @FindBy (xpath = "(//div[@class='h5 mb-0 font-weight-bold text-gray-800'])[7]")
    public WebElement adminMainPageCompletedOrdersWebElement;

    @FindBy (xpath = "//span[text()='Subscriber']")
    public WebElement subscriberButton;

    @FindBy (xpath = "//a[text()='All Subscribers']")
    public WebElement allSubscribersButton;

    @FindBy (xpath = "//h6[text()='View Subscribers']")
    public WebElement viewSubscribersWebElement;

    @FindBy (id = "dataTable_info")
    public WebElement allSubscribersWebElement;

    @FindBy (xpath = "//a[text()='Send Email to Subscribers']")
    public WebElement sendEmailToSubcribersButton;

    @FindBy (xpath = "(//div[@class='row dashboard-page'])[1]")
    public WebElement adminDashboardVisibility;

    @FindBy(id ="userDropdown")
    public WebElement adminDropDownButton;

    @FindBy(className= "dropdown-item")
    public WebElement changeAdminPassword;
    @FindBy(xpath = "m-0 mt-2 font-weight-bold text-primary")
    public WebElement editAdminProfile;



    @FindBy(xpath = "(//div[@role='textbox'])[1]")
    public WebElement messageBoxInSendEmailSection;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement subjectBoxInSendEmailSection;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement allSubscribersButtonInSendEmailSection;

    @FindBy(xpath = "//button[text()='Send Email']")
    public WebElement sendEmailButton;

    @FindBy(className = "toast-message")
    public WebElement warningMessage;

    @FindBy (xpath = "(//span[normalize-space()='Packages'])[1]")
    public WebElement adminPagePackagesTab;

    @FindBy (xpath = "(//a[normalize-space()='Add New'])[1]")
    public WebElement addPackages;

    @FindBy (xpath = "(//input[@name='p_name'])[1]")
    public WebElement addPackagesFirstTab;

    @FindBy (xpath = "(//input[@type='file'])[1]")
    public WebElement addPackagesUploadImage;

    @FindBy (xpath = "(//div[@role='textbox'])[1]")
    public WebElement addPackagesDescription;

    @FindBy (xpath = "//input[@id='datepicker']" )
    public  WebElement addPackagesStartDate;

    @FindBy (xpath = "//input[@name='p_end_date']" )
    public  WebElement addPackagesEndDate;

    @FindBy (xpath = "//input[@id='datepicker2']" )
    public  WebElement addPackagesLastBooking;

    @FindBy (xpath = "(//select[@name='p_is_featured'])[1]")
    public WebElement addPackagesIsFeatured;

    @FindBy (xpath = "//select[@name='destination_id']")
    public WebElement addPackagesDestination;

    @FindBy (xpath ="(//textarea[@name='p_map'])[1]" )
    public WebElement addPackagesMap;

    @FindBy(xpath = "//a[text()='Detail']")
    public WebElement adminOrderDetailButton;

    @FindBy(xpath = "//h6[text()='Order Information']")
    public WebElement adminOrderPageOrderInformationElement;

    @FindBy(xpath = "(//span[normalize-space()='Destinations'])[1]")
    public WebElement adminDestinationsTab;
    @FindBy (xpath = "(//a[normalize-space()='Add New'])[1]")
    public WebElement addAdminDestinations;

    @FindBy (xpath = "(//input[@name='d_name'])[1]")
    public WebElement addDestinationsName;

    @FindBy (xpath = "(//input[@type='file'])[1]")
    public WebElement addDestinationsUploadImage;



    }

