package tests.Mustafa;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Set;

public class US_24 {

/*
TC_24_01	I can log in as a customer/user.
            1) User open browser
			2) User navigates to the main page
			3) User clicks on THE Login link on the main page.
			4) User writes email address to Email Address Box
			5) User writes password to Password Box
			6) User clicks the Login Button. URL changed

TC_24_02	I can navigate to Packages page and select a package.
            1) User navigates to Packages page. URL changed.
			2) User selects/clicks a package of their choice. (Say Bangkok).
               User navigates to the corresponding page.

        	I can pay for my selected package
            1) User decides the number of people for the trip using the drop-down menu.
			2) User clicks "Book Your Seat" button.
			3) User clicks "Pay with Card"
			4) User enters card number in the corresponding field 4242424242424242
			5) User enters the expiry date of the card in the corresponding field: 11/24
			6) User enters the CCV number of the card in the corresponding field: 111
			7) User approves payment by clicking the Pay button
			8) User should see "Payment is successful!" message.
*/
    LoginPage loginPage = new LoginPage();
    UserDashboardPage userDashboardPage = new UserDashboardPage();
    BasePage basePage = new BasePage();
    PackagesPage packagesPage = new PackagesPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    AdminPage adminPage = new AdminPage();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.get("tripAndWayUrl")); // navigate to homepage
        basePage.acceptCookies();

    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
    @Test
    public void TC_24_01_customerLogin(){

        loginPage.loginAsUser();  // Log in to a user account

        String expectedText = "Dashboard";
        String actualText = loginPage.userDashboard.getText();
        Assert.assertTrue(actualText.contains(expectedText));

    }
    @Test
    public void TC_24_02_selectPackageAndPay(){

        loginPage.loginAsUser();  // Log in to a user account

        packagesPage.packagesHeaderLink2.click(); // navigate to Packages page.


//***** in coding, it is not advised to use hard-waits like "ReusableMethods.waitFor".
// instead we should use explicitly waits
//**** (but if is because of computer or connection problems it is acceptable)
        ReusableMethods.waitFor(1);
        basePage.acceptCookies();

//**** to scroll to somewhere I prefer using a webelement instead of using numbers, When we use numbers it may not work on other computers
        jse.executeScript("window.scrollBy(0,550)");   // Sonunda bu calisti!
        ReusableMethods.waitFor(1);

        packagesPage.buenosAiresPackageInPackagesPage.click();

        WebElement totalPersonsDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='numberPerson']"));
        Select select = new Select(totalPersonsDropDown);
        select.selectByValue("2");

        WebElement bookYourSeatButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-info btn-lg']"));
        bookYourSeatButton.click();

        WebElement payButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        payButton.click();

        Driver.getDriver().switchTo().frame("stripe_checkout_app");

 //**** using explicitly wait here makes your code professional :D    thank you
        ReusableMethods.waitForVisibility(userDashboardPage.creditCard,7);
        jse.executeScript("arguments[1].value = arguments[0]; ", ConfigReader.getProperty("creditCardNumber"), userDashboardPage.creditCard);
        userDashboardPage.creditCard.sendKeys(ConfigReader.getProperty("creditCardNumber"));

        actions.sendKeys(Keys.TAB + ConfigReader.getProperty("expiryDate"))
                .sendKeys((Keys.TAB + ConfigReader.getProperty("CVC")))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

    //  Driver.getDriver().switchTo().defaultContent();

        String actualMessage = adminPage.warningMessage.getText(); // Chrome's Save Card prompt ruins the test!!
        String expectedMessage = "Payment is successful!";
        Assert.assertEquals(actualMessage, expectedMessage);



    }
}