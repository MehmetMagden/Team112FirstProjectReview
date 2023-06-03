package tests.Elcin;

import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ContactPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US017 {

    ContactPage contactPage=new ContactPage();
    BasePage basePage=new BasePage();

    @Test(priority = 1)
    public void cotactPageShouldBeAccessable() {
        contactPage=new ContactPage();
        basePage=new BasePage();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);

        basePage.acceptCookiesButton.click();

        basePage.homePageContactButton.click();

        String expectedUrl = ConfigReader.getProperty("contactUsExpectedUrl");
        System.out.println(expectedUrl);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl);
        ReusableMethods.waitFor(3);
        Driver.quitDriver();
    }

    @Test
    public void contactPageSuccsesfulMessageSubmit(){

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.acceptCookiesButton.click();
        basePage.homePageContactButton.click();
        ReusableMethods.waitFor(2);
        contactPage.contactUsNameSearchBox.sendKeys("Elcin ");
        ReusableMethods.waitFor(2);
        contactPage.contactUsPhoneTextBox.sendKeys("902166167567");
        ReusableMethods.waitFor(2);
        contactPage.contactUsEmailTextBox.sendKeys("elcin@hotmail.com");
        ReusableMethods.waitFor(2);
        contactPage.contactUsMessageTextBox.sendKeys("Bu bizim ilk projemiz");
        ReusableMethods.waitFor(2);
        ReusableMethods.waitForVisibility(contactPage.contactUsSubmitButton,15);
        ReusableMethods.waitFor(3);
        ReusableMethods.waitForClickablility(contactPage.contactUsSubmitButton,15);
        ReusableMethods.waitFor(5);
     


        // JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
      //  String messageText = (String) js.executeScript("return document.getElementById('messageElementId').innerText");
      //  System.out.println("Mesaj: " + messageText);

        //  String alert=Driver.getDriver().switchTo().alert().getText();
      //  System.out.println("AYSE"+alert);


        Driver.quitDriver();
    }


    @Test
    public void contactPageMessageSubmitWithWrongTypeOfInputDataInNameTextBox() {
        contactPage = new ContactPage();
        basePage = new BasePage();
        ReusableMethods.waitFor(2);

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));

        basePage.acceptCookiesButton.click();

        basePage.homePageContactButton.click();
        ReusableMethods.waitFor(2);

        contactPage.contactUsNameSearchBox.sendKeys("1234 ");
        ReusableMethods.waitFor(5);

        contactPage.contactUsPhoneTextBox.sendKeys("902166167556");
        ReusableMethods.waitFor(2);

        contactPage.contactUsEmailTextBox.sendKeys("elcin@hotmail.com" );
        ReusableMethods.waitFor(2);

        contactPage.contactUsMessageTextBox.sendKeys("Bu bizim ilk projemiz" );
        ReusableMethods.waitFor(2);

        contactPage.contactUsSubmitButton.click();
        ReusableMethods.waitForClickablility(contactPage.contactUsSubmitButton,15);


        Driver.quitDriver();
    }
        @Test
        public void contactPageMessageSubmitWithWrongTypeInputDataOnPhoneTextBox(){
            contactPage=new ContactPage();
            basePage=new BasePage();
            ReusableMethods.waitFor(2);

            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));

            basePage.acceptCookiesButton.click();

            basePage.homePageContactButton.click();
            ReusableMethods.waitFor(2);

            contactPage.contactUsNameSearchBox.sendKeys("Elcin Kinsiz ");
            ReusableMethods.waitFor(5);

            contactPage.contactUsPhoneTextBox.sendKeys("abcd12");
            ReusableMethods.waitFor(10);

            contactPage.contactUsEmailTextBox.sendKeys("elcin@hotmail.com");
            ReusableMethods.waitFor(2);

            contactPage.contactUsMessageTextBox.sendKeys("Bu bizim ilk projemiz");
            ReusableMethods.waitFor(2);

            Assert.assertTrue(contactPage.incorrectPhoneNumberMessage.isDisplayed());

            Driver.quitDriver();





    }




}
