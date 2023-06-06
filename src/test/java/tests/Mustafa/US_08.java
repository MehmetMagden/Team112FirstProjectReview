package tests.Mustafa;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_08 {

/*
TC_08_01	As a user I should access the main page.
            1) User opens a browser
			2) User navigates to the main page

TC_08_02	User can see the company's contact info after scrolling down to the bottom of the page.
            1) User scroll downs to the bottom of page
			2) User verifies that company's email is visible
			3) User verifies that company's phone number is visible
			4) User verifies that company's address is visible

        	I can click the contact icons/text.
            1) User can click the phone number to place a phone call
			2) User can click the address to open Google Maps
			3) User can click the email address to open an email app.
			4) User closes the browser.
 */
    BasePage basePage = new BasePage();
    Actions actions = new Actions(Driver.getDriver());
    @BeforeMethod
        public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookies();
        actions.sendKeys(Keys.END).perform();
    }
    @AfterMethod
        public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void TC_08_01_accessToHomepage() { // bu test gereksiz

        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = ConfigReader.getProperty("tripAndWayUrl");
        Assert.assertEquals(expectedURL,actualURL);
    }

    @Test
    public void TC_08_02_footerContactInfo() {

        Assert.assertTrue(basePage.footerContact.isDisplayed());

        Assert.assertTrue(basePage.footerAddress2.isEnabled());
        Assert.assertTrue(basePage.footerPhone.isEnabled());
        Assert.assertTrue(basePage.footerEmail.isEnabled());



//        boolean isAddressClickable = homePage.footerAddress.isEnabled() && homePage.footerAddress.isDisplayed();
//        Assert.assertFalse(isAddressClickable,"The Address in the Footer section is not a link");
//                ReusableMethods.waitFor(3);
//        boolean isPhoneClickable = homePage.footerPhone.isEnabled() && homePage.footerPhone.isDisplayed();
//        Assert.assertFalse(isPhoneClickable, "The Phone number in the Footer section is not a link");
//                ReusableMethods.waitFor(3);
//        boolean isEmailClickable = homePage.footerEmail.isEnabled() && homePage.footerEmail.isDisplayed();
//        Assert.assertFalse(isEmailClickable,"The Email address in the Footer section is not a link");
//                ReusableMethods.waitFor(3);
    }
}
