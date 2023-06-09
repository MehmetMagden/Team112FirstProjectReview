package tests.Elcin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.BasePage;
import pages.ContactPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US017 {


    ContactPage contactPage = new ContactPage();

    BasePage basePage = new BasePage();

    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC017_01_contactPageAccessable() { //done
        //extentTest = extentReports.createTest("TC017_01", "User should be able to access to Contact page");
        contactPage = new ContactPage();
        basePage = new BasePage();

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookies();
        basePage.homePageContactButton.click();
        String expectedUrl = ConfigReader.getProperty("contactUrl");
        System.out.println(expectedUrl);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(actualUrl, expectedUrl);
        //extentTest.pass("User can successfuly access to contact page");
        ReusableMethods.waitFor(3);

    Driver.getDriver().quit();


}
    @Test
    public void TC17_02_01_SuccsesfulMessageSubmit() { //done
        // extentTest = extentReports.createTest("TC017_02_01", "User can send a message to admin by inputing requested data type");
        contactPage = new ContactPage();
        basePage = new BasePage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);
        basePage.acceptCookies();
        basePage.homePageContactButton.click();
        contactPage.contactUsNameSearchBox.sendKeys("Elcin" + Keys.TAB);
        actions.sendKeys("00902165221591" + Keys.TAB)
                .sendKeys("a1234321bc@gmail.com" + Keys.TAB)
                .sendKeys("Message box worked" + Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        js.executeScript("window.scrollBy(0, -500)");
        Assert.assertTrue(contactPage.messageSuccesfullySent.isDisplayed());
        //extentTest.pass("User able to send a message by inputing requested data in requested format");
        System.out.println(contactPage.messageSuccesfullySent.getText());
        Driver.getDriver().quit();
    }
   /*
    @Test //Test cannot be completed with automation due to lack of tag on moving alert. Test carried out manualy and user cannot send
    message when diget inserted in name box.

    public void TC017_02_02shouldNotBeAbleToSubmitMessageWithDigitsInsertedInTheNameTextBox() {
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
        String expectedMessage = "Message is sent successfully! Admin will contact you soon";
        String actualMessage = contactPage.messageSuccesfullySent.getText();
        System.out.println(actualMessage);

        Assert.assertTrue(!contactPage.messageSuccesfullySent.isDisplayed());




   */

        @Test
        public void TC017_02_02shouldNotBeAbleToSubmitAMessageWithNothingInsertedInTheNameTextBox () {
            //extentTest = extentReports.createTest("TC017_02_02", "User should't be able to send a message without inserting a name in the name text box");
            contactPage = new ContactPage();
            basePage = new BasePage();
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
            ReusableMethods.waitFor(2);
            basePage.acceptCookies();
            basePage.homePageContactButton.click();

            contactPage.contactUsNameSearchBox.sendKeys("" + Keys.TAB);
            actions.sendKeys("00902165221591" + Keys.TAB)
                    .sendKeys("a1234321bc@gmail.com" + Keys.TAB)
                    .sendKeys("Message box worked" + Keys.TAB).perform();
            js.executeScript("window.scrollBy(0, 500)");
            contactPage.submitButton.sendKeys(Keys.ENTER);

            ReusableMethods.waitFor(2);
            js.executeScript("window.scrollBy(0, -500)");
            String expectedMessage = "Name can not be empty";
            System.out.println(expectedMessage);
            String actualMessage=contactPage.warningMessage.getText();
             System.out.println(actualMessage);
             Assert.assertEquals(actualMessage,expectedMessage);
          //  extentTest.pass("User shouln't be able send a message with empyt name text box");


            Driver.getDriver().quit();
        }

        @Test
        public void TC017_02_03contactPageMessageSubmitWithWrongTypeDataOnPhoneTextBox () {  //done
         //   extentTest = extentReports.createTest("TC017_02_03", "User should't be able to send a message by entering other than digits in the phone text box");
            contactPage = new ContactPage();
            basePage = new BasePage();
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
            ReusableMethods.waitFor(2);
            basePage.acceptCookies();
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
           // extentTest.pass("User shouln't be able send a message by entereing data other than digits in the phone text box");


            Driver.quitDriver();
        }

        @Test
        public void TC017_02_04shouldNotBeAbleToSubmitAMessageWithContactNumberLessThan12DigitPhoneNumber () {  //done
          //  extentTest = extentReports.createTest("TC017_02_04", "User should't be able to send a message with insurting less than 12 digits in the phone text box");
            contactPage = new ContactPage();
            basePage = new BasePage();
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
            ReusableMethods.waitFor(2);
            basePage.acceptCookies();
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
          //  extentTest.pass("User shouln't be able send a message with a telephone number less than 12 digits insurted in the phone text box");

            Driver.quitDriver();

        }

        @Test
        public void TC017_02_05shouldNotBeAbleToSubmitAMessageWithIncorrectEmailFormat () { //BUG Done
          //  extentTest = extentReports.createTest("TC017_02_05", "User should't be able to send a message if email address does not contain @ symbol");
            contactPage = new ContactPage();
            basePage = new BasePage();
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
            ReusableMethods.waitFor(2);
            basePage.acceptCookies();
            basePage.homePageContactButton.click();

            contactPage.contactUsNameSearchBox.sendKeys("Elcin" + Keys.TAB);
            actions.sendKeys("00902165221591" + Keys.TAB)
                    .sendKeys("a1234321bcgmail.com" + Keys.TAB)
                    .sendKeys("Message box worked" + Keys.TAB)
                    .sendKeys(Keys.ENTER).perform();
            js.executeScript("window.scrollBy(0, -500)");
            Assert.assertFalse(contactPage.messageSuccesfullySent.isDisplayed());
          //  extentTest.fail("User shouln't be able send a message if email address doesn't contain @ symboll");
            System.out.println(contactPage.messageSuccesfullySent.getText());


            Driver.quitDriver();
        }
        @Test
        public void TC017_02_06shouldNotBeAbleToSubmitAMessageWithIncorrectEmailFotrmat () { //BUG Done
          //  extentTest = extentReports.createTest("TC017_02_06", "User should't be able to send a message if email address does not contain .com symbol");
            contactPage = new ContactPage();
            basePage = new BasePage();
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
            ReusableMethods.waitFor(2);
            basePage.acceptCookies();
            basePage.homePageContactButton.click();

            contactPage.contactUsNameSearchBox.sendKeys("Elcin" + Keys.TAB);
            actions.sendKeys("00902165221591" + Keys.TAB)
                    .sendKeys("a1234321bcgmail@hhh" + Keys.TAB)
                    .sendKeys("Message box worked" + Keys.TAB)
                    .sendKeys(Keys.ENTER).perform();
            js.executeScript("window.scrollBy(0, -500)");
            Assert.assertFalse(contactPage.messageSuccesfullySent.isDisplayed());
          //  extentTest.fail("User shouln't be able send a message if email address doesn't contain .com symboll");
            System.out.println(contactPage.messageSuccesfullySent.getText());


            Driver.quitDriver();
        }

        @Test
        public void TC017_02_07shouldNotBeAbleToSendEmpytMessage () {  //done
          //  extentTest = extentReports.createTest("TC017_02_07", "User should't be able to send a message with empty message in the message text box");
            contactPage = new ContactPage();
            basePage = new BasePage();
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
            ReusableMethods.waitFor(2);
            basePage.acceptCookies();
            basePage.homePageContactButton.click();

            contactPage.contactUsNameSearchBox.sendKeys("Elcin" + Keys.TAB);
            actions.sendKeys("902165221591" + Keys.TAB)
                    .sendKeys("a1234321bc@gmail.com" + Keys.TAB)
                    .sendKeys("  " + Keys.TAB)
                    .sendKeys(Keys.ENTER).perform();

            ReusableMethods.waitFor(1);
            js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("window.scrollBy(0, -300)");
            String expectedMessage = "Message can not be empty";
            String actualMessage = contactPage.messageTextBoxWarning.getText();
            System.out.println(actualMessage);
            Assert.assertTrue(actualMessage.contains(expectedMessage));
           // extentTest.pass("User shouln't be able send a message with empyt message text box");

            Driver.getDriver().quit();


        }
        @Test
        public void TC017_03contactPageContactInformationsAreVisible () {   //done
            ContactPage contactPage = new ContactPage();
            BasePage basePage = new BasePage();
            Actions actions = new Actions(Driver.getDriver());
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));

            basePage.acceptCookies();
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



