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

    @FindBy (xpath = "(//a[@class='dropdown-item'])[3]")
    public WebElement adminLogoutButton;

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

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement addPackagesSubmitButton;

   @FindBy (xpath = "//tbody/tr[8]/td[7]/a[1]/i[1]")
   public WebElement addedPackagesEditing;

    @FindBy (xpath = "//input[@name='seo_title']")
    public WebElement getAddPackagesTitle;

    @FindBy (xpath = "//input[@name='p_price']")
    public WebElement addPackagesPriceTab;

    @FindBy(xpath = "//a[text()='Detail']")
    public WebElement adminOrderDetailButton;

    @FindBy(xpath = "//h6[text()='Order Information']")
    public WebElement adminOrderPageOrderInformationElement;

    @FindBy(xpath = "(//span[normalize-space()='Destinations'])[1]")
    public WebElement adminDestinationsTab;
    @FindBy (xpath = "(//a[normalize-space()='Add New'])[1]")
    public WebElement addAdminDestinations;

    @FindBy(xpath = "//*[text()='Blog Section']")
    public WebElement adminPanelBlogSectionButton;


    @FindBy(xpath = "//*[text()='Categories']")
    public WebElement adminPanelBlogSectionCategoriesButton;

    @FindBy(xpath = "//*[text()=' Add New']")
    public WebElement blogSectionCategoriesAddNewButton;

    @FindBy(xpath = "//input[@name='category_name']")
    public WebElement addCategoryNameBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement addCategorySubmitButton;

    @FindBy(xpath = "//div[@id='toast-container']")
    public WebElement addCategorySuccessfulAlert;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement categoriesSearchBox;


    @FindBy(xpath = "//tbody/tr/td[4]/a[1]")
    public WebElement categoriesActionEditButton;


    @FindBy(xpath = "//tbody/tr/td[4]/a[2]")
    public WebElement categoriesActionDeleteButton;


    @FindBy(xpath = "//button[@type='submit']")
    public WebElement editCategoryUpdateButton;


    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement editCategorySuccessfulAlert;


    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement categoriesDeletedSuccessfulAlert;

    @FindBy(xpath = "(//i[@class='fas fa-edit'])[8]")
     public WebElement editDestinationButton;
}

