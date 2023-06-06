package tests.Mustafa;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;

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

TC_08_03	I can click the contact icons/text.
            1) User can click the phone number to place a phone call
			2) User can click the address to open Google Maps
			3) User can click the email address to open an email app.
			4) User closes the browser.
 */
    HomePage homePage = new HomePage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void TC_08_01_accessToHomepage() {
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));

        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = ConfigReader.getProperty("tripAndWayUrl");
        Assert.assertEquals(expectedURL,actualURL);
    }

    @Test
    public void TC_08_02_footerContactInfo() {
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl")); // go to homepage

        jse.executeScript("arguments[0].scrollIntoView();", homePage.footerContact); // scroll down to Footer
        // or with: jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Assert.assertTrue(homePage.footerContact.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void TC_08_03_footerContactClick(){
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl")); // go to homepage
        jse.executeScript("arguments[0].scrollIntoView();", homePage.footerContact); // scroll down to Footer

        boolean isAddressClickable = homePage.footerAddress.isEnabled() && homePage.footerAddress.isDisplayed();
        Assert.assertFalse(isAddressClickable,"The Address in the Footer section is not a link");
                ReusableMethods.waitFor(3);
        boolean isPhoneClickable = homePage.footerPhone.isEnabled() && homePage.footerPhone.isDisplayed();
        Assert.assertFalse(isPhoneClickable, "The Phone number in the Footer section is not a link");
                ReusableMethods.waitFor(3);
        boolean isEmailClickable = homePage.footerEmail.isEnabled() && homePage.footerEmail.isDisplayed();
        Assert.assertFalse(isEmailClickable,"The Email address in the Footer section is not a link");
                ReusableMethods.waitFor(3);

        Driver.closeDriver();
    }
}
