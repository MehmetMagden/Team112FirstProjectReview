package tests.Mustafa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import pages.PackagesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

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
			8) User should see "Payment is successful" message.
*/
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    PackagesPage packagesPage = new PackagesPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl")); // navigate to homepage
        basePage.acceptCookies();
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
    @Test
    public void TC_24_01_customerLogin(){

        loginPage.loginPageLoginButton2.click();
        loginPage.loginPageEmailAddressTextBox.sendKeys(ConfigReader.getProperty("userLoginEmailCorrect"));
        loginPage.loginPagePasswordBox.sendKeys(ConfigReader.getProperty("userLoginPasswordCorrect"));
        ReusableMethods.waitFor(2);
        loginPage.loginPageLoginButton.click();

        String expectedText = "Dashboard";
        String actualText = loginPage.userDashboard.getText();
        Assert.assertTrue(actualText.contains(expectedText));

    }
    @Test
    public void TC_24_02_selectPackageAndPay(){

        // Log in to user account
        loginPage.loginPageLoginButton2.click();
        loginPage.loginPageEmailAddressTextBox.sendKeys(ConfigReader.getProperty("userLoginEmailCorrect"));
        loginPage.loginPagePasswordBox.sendKeys(ConfigReader.getProperty("userLoginPasswordCorrect"));
        ReusableMethods.waitFor(2);
        loginPage.loginPageLoginButton.click();

        packagesPage.packagesHeaderLink2.click(); // navigate to Packages page.


        ReusableMethods.waitFor(3);
        basePage.acceptCookies();
        ReusableMethods.waitFor(5);

        jse.executeScript("window.scrollBy(0,550)");   // Sonunda bu calisti!
        ReusableMethods.waitFor(3);

        packagesPage.buenosAiresPackageInPackagesPage.click();

        WebElement totalPersonsDropDown = Driver.getDriver().findElement(By.xpath("//select[@id='numberPerson']"));
        Select select = new Select(totalPersonsDropDown);
        select.selectByValue("2");
        ReusableMethods.waitFor(3);

        WebElement bookYourSeatButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-info btn-lg']"));
        bookYourSeatButton.click();
        ReusableMethods.waitFor(3);

        WebElement payButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        payButton.click();
        ReusableMethods.waitFor(3);


        WebElement cardNumberBox = Driver.getDriver().findElement(By.xpath("/html[1]/body[1]/div[3]/form[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        actions.click(cardNumberBox)
                .sendKeys("4242424242424242")
                .sendKeys(Keys.TAB)
                .sendKeys("1224")
                .sendKeys(Keys.TAB)
                .sendKeys("111")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


        String actualMessage = Driver.getDriver().switchTo().alert().getText();
        String expectedMessage = "Payment is successful";
        Assert.assertTrue(actualMessage.contains(expectedMessage));

    }
}