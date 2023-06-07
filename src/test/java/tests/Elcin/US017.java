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
    public void TC17_02_01_SuccsesfulMessageSubmit() {  // Waiting for message box locater problem to be resolved-Ali Temur
        contactPage = new ContactPage();
        basePage = new BasePage();
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));


        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();
        contactPage.contactUsNameSearchBox.sendKeys("Elcin Kinsiz");
        contactPage.contactUsPhoneTextBox.sendKeys("902166167567");
        contactPage.contactUsEmailTextBox.sendKeys("elcin@hotmail.com");
        contactPage.contactUsMessageTextBox.sendKeys("Testing Contact Form Features");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,1000)");

        actions.moveToElement(contactPage.getSubmitButton2).perform();
        contactPage.submitButton.click();
        ReusableMethods.waitFor(10);


       // String actualMessage=contactPage.messageSent.getText();
       // System.out.println(actualMessage);

      //  Assert.assertEquals(actualMessage,"Message is sent successfully! Admin will contact you soon");
     //

    }

    // JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    //  String messageText = (String) js.executeScript("return document.getElementById('messageElementId').innerText");
    //  System.out.println("Mesaj: " + messageText);

    //  String alert=Driver.getDriver().switchTo().alert().getText();
    //  System.out.println("Is There a Alert"+alert);

    //WAITING TO HEAR FROM DEVELOPER FOR TAGS ON THE MOVING ELEMENTS POP UP MESSAGES for tasks TC17_02_02 to 06 ALI TEMUR


    @Test
    public void TC017_02_02contactPageMessageSubmitWithWrongTypeOfInputDataInNameTextBox() {
        contactPage = new ContactPage();
        basePage = new BasePage();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();

        //js.executeScript("window.scrollBy(0, 500)");
        contactPage.contactUsNameSearchBox.sendKeys("1234 ");

        contactPage.contactUsPhoneTextBox.sendKeys("902166167567");

        contactPage.contactUsEmailTextBox.sendKeys("elcin@hotmail.com");

        contactPage.contactUsMessageTextBox.sendKeys("Testing Contact Form Features");

        actions.click(contactPage.submitButton).perform();



        ReusableMethods.waitFor(10);

        Driver.quitDriver();
    }

    @Test
    public void TC017_02_03contactPageMessageSubmitWithWrongTypeDataOnPhoneTextBox() {
        contactPage = new ContactPage();
        basePage = new BasePage();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();
        ReusableMethods.waitFor(2);
        js.executeScript("window.scrollBy(0, 500)");
        contactPage.contactUsNameSearchBox.sendKeys("Elcin ");
        ReusableMethods.waitFor(2);
        contactPage.contactUsPhoneTextBox.sendKeys("abcd");
        ReusableMethods.waitFor(2);
        contactPage.contactUsEmailTextBox.sendKeys("elcin@hotmail.com");
        ReusableMethods.waitFor(2);
        contactPage.contactUsMessageTextBox.sendKeys("Testing Contact Form Features");
        ReusableMethods.waitFor(1);
        actions.click(contactPage.submitButton).perform();
        ReusableMethods.waitFor(1);
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, -300)");
        ReusableMethods.waitFor(10);
        Assert.assertFalse(contactPage.incorrectPhoneNumberMessage.isDisplayed());


        Driver.quitDriver();
    }

    @Test
    public void TC017_02_04contactPageMessageSubmitWithLessThan12DigitPhoneNumberOnPhoneTextBox() {
        contactPage = new ContactPage();
        basePage = new BasePage();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();
        ReusableMethods.waitFor(2);
        js.executeScript("window.scrollBy(0, 500)");
        contactPage.contactUsNameSearchBox.sendKeys("Elcin ");
        ReusableMethods.waitFor(2);
        contactPage.contactUsPhoneTextBox.sendKeys("66167567");
        ReusableMethods.waitFor(2);
        contactPage.contactUsEmailTextBox.sendKeys("elcin@hotmail.com");
        ReusableMethods.waitFor(2);
        contactPage.contactUsMessageTextBox.sendKeys("Testing Contact Form Features");
        ReusableMethods.waitFor(1);
        actions.click(contactPage.submitButton).perform();
        ReusableMethods.waitFor(1);
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, -300)");
        ReusableMethods.waitFor(10);
        Assert.assertTrue(contactPage.incorrectPhoneNumberMessage.isDisplayed());

        Driver.quitDriver();

    }

    @Test
    public void TC017_02_05contactPageMessageSubmitWithWrongTypeInputDataOnEmailTextBox() {  // Waiting for message box locater problem to be resolved-Ali Temur
        contactPage = new ContactPage();
        basePage = new BasePage();
        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();
        ReusableMethods.waitFor(2);
        contactPage.contactUsNameSearchBox.sendKeys("Elcin ");
        ReusableMethods.waitFor(2);
        contactPage.contactUsPhoneTextBox.sendKeys("902166167567");
        ReusableMethods.waitFor(2);
        contactPage.contactUsEmailTextBox.sendKeys("elcinhotmail.com");
        ReusableMethods.waitFor(2);
        contactPage.contactUsMessageTextBox.sendKeys("Testing Contact Form Features");
        ReusableMethods.waitFor(2);
        actions.moveToElement(contactPage.submitButton).perform();
        ReusableMethods.waitForClickablility(contactPage.submitButton, 3);
    }

    @Test
    public void TC017_02_06contactPageMessageSubmitWithBlankInputOnMessageTextBox() {  // Waiting for message box locater problem to be resolved-Ali Temur
        contactPage = new ContactPage();
        basePage = new BasePage();
        Actions actions = new Actions(Driver.getDriver());
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();
        ReusableMethods.waitFor(2);
        js.executeScript("window.scrollBy(0, 500)");
        contactPage.contactUsNameSearchBox.sendKeys("Elcin ");
        ReusableMethods.waitFor(2);
        contactPage.contactUsPhoneTextBox.sendKeys("902166167567");
        ReusableMethods.waitFor(2);
        contactPage.contactUsEmailTextBox.sendKeys("elcin@hotmail.com");
        ReusableMethods.waitFor(2);
        contactPage.contactUsMessageTextBox.sendKeys("  ");
        ReusableMethods.waitFor(1);
        actions.click(contactPage.submitButton).perform();
        ReusableMethods.waitFor(1);
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, -300)");
        ReusableMethods.waitFor(10);


    }

    @Test
    public void TC017_03contactPageContactInformationsAreVisible() {
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
































