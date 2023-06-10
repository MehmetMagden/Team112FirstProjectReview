package tests.Ayse;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_36 extends TestBaseRapor {
    AdminPage adminPage=new AdminPage();
    @Test
     public void userSendEmailsToAllSubscribers () {
        adminPage=new AdminPage();
        extentTest=extentReports.createTest("US36TC01","User as a admin should send emails all subscribers");
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();
        extentTest.info("Admin can access admin page ");
        ReusableMethods.waitFor(3);

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(adminPage.subscriberButton).perform();
        adminPage.subscriberButton.click();
        ReusableMethods.waitFor(3);
        actions.moveToElement(adminPage.sendEmailToSubcribersButton).perform();
        ReusableMethods.waitFor(3);
        adminPage.sendEmailToSubcribersButton.click();
        ReusableMethods.waitFor(2);
       String expectedSendEmailSubscribersUrl="https://qa.tripandway.com/admin/subscriber/send-email";
       String actualSendEmailSubscribersUrl=Driver.getDriver().getCurrentUrl();
       Assert.assertTrue(actualSendEmailSubscribersUrl.equals(expectedSendEmailSubscribersUrl));
       extentTest.pass("As a admin, user can access sebd email section ");
        adminPage.subjectBoxInSendEmailSection.sendKeys("Site Güncel Duyuru");
        adminPage.messageBoxInSendEmailSection.sendKeys("Kıymetli site fanlarımız, site ile ilgili yeniliklerden haberdar olacaksınız");
        adminPage.sendEmailButton.click();
        String warningMessageText=adminPage.warningMessage.getText();
        Assert.assertEquals(warningMessageText,"Email is sent successfully to all subscribers!");
        extentTest.pass("As a user, admin can send all subscribers email successfully");

        Driver.closeDriver();
    }

}
