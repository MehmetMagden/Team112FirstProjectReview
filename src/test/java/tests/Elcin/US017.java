package tests.Elcin;

import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
    public void TC017_01cotactPageShouldBeAccessable() {
        contactPage = new ContactPage();
        basePage = new BasePage();

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();
        String expectedUrl = ConfigReader.getProperty("cotactUrl");
        System.out.println(expectedUrl);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl);
        ReusableMethods.waitFor(3);
        Driver.quitDriver();
    }

    @Test
    public void TC17_02_01contactPageSuccsesfulMessageSubmit() {  // Waiting for message box locater problem to be resolved-Ali Temur
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
        contactPage.contactUsMessageTextBox.sendKeys("Testing Contact Form Features");
        ReusableMethods.waitFor(10);
        actions.click(contactPage.contactUsMessageSubmitButton).perform();
        ReusableMethods.waitFor(5);
        js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0, -300)");
        ReusableMethods.waitFor(5);
       //WAITING FOR DEVELOPER TO GIVE TAG NAME FOR SUBMISSION EMAIL


        Driver.getDriver().quit();

    }

    // JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    //  String messageText = (String) js.executeScript("return document.getElementById('messageElementId').innerText");
    //  System.out.println("Mesaj: " + messageText);

    //  String alert=Driver.getDriver().switchTo().alert().getText();
    //  System.out.println("Is There a Alert"+alert);

    //WAITING TO HEAR FROM DEVELOPER FOR TAGS ON THE MOVING ELEMENTS POP UP MESSAGES-ALI TEMUR
    @Test
    public void TC017_02_02contactPageMessageSubmitWithWrongTypeOfInputDataInNameTextBox() {
        contactPage = new ContactPage();
        basePage = new BasePage();
        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();
        ReusableMethods.waitFor(2);
        contactPage.contactUsNameSearchBox.sendKeys("2345");
        ReusableMethods.waitFor(2);
        contactPage.contactUsPhoneTextBox.sendKeys("902166167567");
        ReusableMethods.waitFor(2);
        contactPage.contactUsEmailTextBox.sendKeys("elcin@hotmail.com");
        ReusableMethods.waitFor(2);
        contactPage.contactUsMessageTextBox.sendKeys("Testing Contact Form Features");
        ReusableMethods.waitFor(2);
        actions.moveToElement(contactPage.contactUsMessageSubmitButton).perform();
        ReusableMethods.waitForClickablility(contactPage.contactUsMessageSubmitButton, 3);


        Driver.quitDriver();
    }

    @Test
    public void TC017_02_03contactPageMessageSubmitWithWrongTypeInputDataOnPhoneTextBox() {
        contactPage = new ContactPage();
        basePage = new BasePage();
        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();
        ReusableMethods.waitFor(2);
        contactPage.contactUsNameSearchBox.sendKeys("Elcin ");
        ReusableMethods.waitFor(2);
        contactPage.contactUsPhoneTextBox.sendKeys("ElcinKinsiz");
        ReusableMethods.waitFor(2);
        contactPage.contactUsEmailTextBox.sendKeys("elcin@hotmail.com");
        ReusableMethods.waitFor(2);
        contactPage.contactUsMessageTextBox.sendKeys("Testing Contact Form Features");
        ReusableMethods.waitFor(2);
        actions.moveToElement(contactPage.contactUsMessageSubmitButton).perform();
        ReusableMethods.waitForClickablility(contactPage.contactUsMessageSubmitButton, 3);

        Assert.assertFalse(contactPage.incorrectPhoneNumberMessage.isDisplayed());


        Driver.quitDriver();
    }
    @Test
    public void TC017_02_04contactPageMessageSubmitWithLessThan12DigitPhoneNumberOnPhoneTextBox() {
        contactPage = new ContactPage();
        basePage = new BasePage();
        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();
        ReusableMethods.waitFor(2);
        contactPage.contactUsNameSearchBox.sendKeys("Elcin ");
        ReusableMethods.waitFor(2);
        contactPage.contactUsPhoneTextBox.sendKeys("21261525");
        ReusableMethods.waitFor(2);
        contactPage.contactUsEmailTextBox.sendKeys("elcin@hotmail.com");
        ReusableMethods.waitFor(2);
        contactPage.contactUsMessageTextBox.sendKeys("Testing Contact Form Features");
        ReusableMethods.waitFor(2);
        actions.moveToElement(contactPage.contactUsMessageSubmitButton).perform();
        ReusableMethods.waitForClickablility(contactPage.contactUsMessageSubmitButton, 3);
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
        actions.moveToElement(contactPage.contactUsMessageSubmitButton).perform();
        ReusableMethods.waitForClickablility(contactPage.contactUsMessageSubmitButton, 3);
    }

        @Test
        public void TC017_02_06contactPageMessageSubmitWithWrongTypeInputDataOnMessageTextBox()
        {  // Waiting for message box locater problem to be resolved-Ali Temur
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
            contactPage.contactUsMessageTextBox.sendKeys(" ");
            ReusableMethods.waitFor(2);
            actions.moveToElement(contactPage.contactUsMessageSubmitButton).perform();
            ReusableMethods.waitForClickablility(contactPage.contactUsMessageSubmitButton, 3);



        }
        @Test
        public void TC017_03contactPageContactInformationsAreVisible(){
        ContactPage contactPage=new ContactPage();
        BasePage basePage=new BasePage();
        Actions actions=new Actions(Driver.getDriver());

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();
        actions.moveToElement(contactPage.contactInformationAddressDetails).perform();
        Assert.assertTrue(contactPage.contactInformationAddressDetails.isDisplayed());

        actions.moveToElement(contactPage.contactInformationEmailAddress).perform();
        Assert.assertTrue(contactPage.contactInformationEmailAddress.isDisplayed());

        //actions.moveToElement(contactPage.contactInformationPhoneNumber).perform();
        // Assert.assertTrue(contactPage.contactInformationPhoneNumber.isDisplayed());

        actions.moveToElement(contactPage.contactInformationAddressMap).perform();
        Assert.assertTrue(contactPage.contactInformationAddressMap.isDisplayed());




       Driver.quitDriver();


        }


        }





























