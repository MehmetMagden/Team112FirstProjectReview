package tests.Elcin;

import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ContactPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;

public class US017 {

    ContactPage contactPage = new ContactPage();
    BasePage basePage = new BasePage();

    Actions actions = new Actions(Driver.getDriver());

    @Test(priority = 1)
    public void TC017_01_contactPageAccessable() {
        contactPage = new ContactPage();
        basePage = new BasePage();

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();
        String expectedUrl = ConfigReader.getProperty("contactUrl");
        System.out.println(expectedUrl);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl);
        ReusableMethods.waitFor(3);
        Driver.quitDriver();
    }

    @Test
    public void TC17_02_01_SuccsesfulMessageSubmit() {  //PASSED
        contactPage = new ContactPage();
        basePage = new BasePage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();

        contactPage.contactUsNameSearchBox.sendKeys("Elcin" + Keys.TAB);
        actions.sendKeys("902165221591" + Keys.TAB)
                .sendKeys("a1234321bc@gmail.com" + Keys.TAB)
                .sendKeys("Message box worked" + Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        js.executeScript("window.scrollBy(0, -500)");
        Assert.assertTrue(contactPage.messageSuccesfullySent.isDisplayed());
        System.out.println(contactPage.messageSuccesfullySent.getText());

        Driver.getDriver().quit();
    }

    @Test
    public void TC017_02_02shouldNotBeAbleToSubmitMessageWithDigitsInsertedInTheNameTextBox() { //??????????
        contactPage = new ContactPage();
        basePage = new BasePage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();

        contactPage.contactUsNameSearchBox.sendKeys("1133" + Keys.TAB);
        actions.sendKeys("902165221591" + Keys.TAB)
                .sendKeys("a1234321bc@gmail.com" + Keys.TAB)
                .sendKeys("Message box worked" + Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        ReusableMethods.waitFor(1);
        js.executeScript("window.scrollBy(0, -300)");
        String expectedMessage = " ";
        String actualMessage = contactPage.messageSuccesfullySent.getText();
        System.out.println(actualMessage);

        Assert.assertTrue(!contactPage.messageSuccesfullySent.isDisplayed());


        Driver.getDriver();
    }

    @Test
    public void TC017_02_02shouldNotBeAbleToSubmitAMessageWithNothingInsertedInTheNameTextBox() {
        contactPage = new ContactPage();

        basePage = new BasePage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();

        contactPage.contactUsNameSearchBox.sendKeys(" " + Keys.TAB);
        actions.sendKeys("902165221591" + Keys.TAB)
                .sendKeys("a1234321bc@gmail.com" + Keys.TAB)
                .sendKeys("Message box worked" + Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        ReusableMethods.waitFor(1);
        js.executeScript("window.scrollBy(0, -300)");
        String expectedMessage = "Name can not be empty";
        String actualMessage =contactPage.nameBoxWarningEmpty.getText();
        System.out.println(actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage);





    }

    @Test
    public void TC017_02_03contactPageMessageSubmitWithWrongTypeDataOnPhoneTextBox() {  //passed
        contactPage = new ContactPage();
        contactPage = new ContactPage();
        basePage = new BasePage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();

        contactPage.contactUsNameSearchBox.sendKeys("Elcin" + Keys.TAB);
        actions.sendKeys("abcds" + Keys.TAB)
                .sendKeys("a1234321bc@gmail.com" + Keys.TAB)
                .sendKeys("Message box worked" + Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        ReusableMethods.waitFor(1);
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, -300)");
        String expectedMessage = "Your phone number must enter your phone number with the country code and 12 digits and can only contain numbers.";
        String actualMessage = contactPage.incorrectPhoneNumberWarning.getText();
        System.out.println(actualMessage);

        Assert.assertTrue(contactPage.incorrectPhoneNumberWarning.isDisplayed());


        Driver.quitDriver();
    }

    @Test
    public void TC017_02_04shouldNotBeAbleToSubmitAMessageWithContactNumberLessThan12DigitPhoneNumber() {  //passed

        contactPage = new ContactPage();
        basePage = new BasePage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();

        contactPage.contactUsNameSearchBox.sendKeys("Elcin" + Keys.TAB);
        actions.sendKeys("90216522" + Keys.TAB)
                .sendKeys("a1234321bc@gmail.com" + Keys.TAB)
                .sendKeys("Message box worked" + Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        ReusableMethods.waitFor(1);
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, -300)");

        String expectedMessage = "Your phone number must enter your phone number with the country code and 12 digits and can only contain numbers.";
        String actualMessage = contactPage.incorrectPhoneNumberWarning.getText();
        System.out.println(actualMessage);

        Assert.assertTrue(contactPage.incorrectPhoneNumberWarning.isDisplayed());

        Driver.quitDriver();

    }
    @Test
    public void TC017_02_05shouldNotBeAbleToSubmitAMessageWithIncorrectEmailFormat() {

        contactPage = new ContactPage();
        basePage = new BasePage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();

        contactPage.contactUsNameSearchBox.sendKeys("Elcin");
        contactPage.contactUsPhoneTextBox.sendKeys("902165221591");
        contactPage.contactUsEmailTextBox.sendKeys("a1234321bcgmail.com");
        contactPage.contactUsMessageTextBox.sendKeys("Message box worked");
        actions.sendKeys(Keys.ENTER).perform();


        ReusableMethods.waitFor(1);
        js.executeScript("window.scrollBy(0, -1000)");
        ReusableMethods.waitFor(5);

        Assert.assertFalse(!contactPage.messageSuccesfullySent.isDisplayed());

        Driver.quitDriver();
    }


    @Test
    public void TC017_02_06shouldNotBeAbleToSendEmpytMessage() {  //passed
        contactPage = new ContactPage();
        basePage = new BasePage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();

        contactPage.contactUsNameSearchBox.sendKeys("Elcin"+Keys.TAB);
        actions.sendKeys("902165221591"+Keys.TAB)
                .sendKeys("a1234321bc@gmail.com"+ Keys.TAB)
                .sendKeys("  "+Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        ReusableMethods.waitFor(1);
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, -300)");
        String expectedMessage="Message can not be empty";
        String actualMessage=contactPage.messageTextBoxWarning.getText();
        System.out.println(actualMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        Driver.getDriver().quit();


    }

    @Test
    public void TC017_03contactPageContactInformationsAreVisible() {   //passed
        ContactPage contactPage = new ContactPage();
        BasePage basePage = new BasePage();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));

        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();
        ReusableMethods.waitFor(1);

        js.executeScript("window.scrollBy(0, 500)");
        ReusableMethods.waitFor(2);

        String expectedAddress = "3153 Foley Street";
        String actualAddress = contactPage.contactInfoActualAddress.getText();
        Assert.assertTrue(actualAddress.contains(expectedAddress));

        String expectedEmailAddress = "info@tripandway.com";
        String actualEmailAddress = contactPage.contactInfoActualEmailAddress.getText();
        Assert.assertTrue(actualEmailAddress.contains(expectedEmailAddress));


        String expectedPhoneNumber = "Office 1: 202-456-3789";
        String actualPhoneNumber = contactPage.contactInformationActualPhoneNumber.getText();
        Assert.assertTrue(actualPhoneNumber.contains(expectedPhoneNumber));

        String expectedMapWord = "Address in Map";
        System.out.println(expectedMapWord);
        String actualMapWord = contactPage.contactInformationAddressMap.getText();
        System.out.println(actualMapWord);
        Assert.assertTrue(actualMapWord.contains(expectedMapWord));
        Driver.quitDriver();

 }
    }
































