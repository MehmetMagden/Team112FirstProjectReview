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

public class US_36 {
    AdminPage adminPage=new AdminPage();
    @Test
     public void userSendEmailsToAllSubscribers () {
        adminPage=new AdminPage();
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();
        ReusableMethods.waitFor(3);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,1000)");

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
       //8)User should see url is the same with the data


        //9)User should enter any subjects in the subject box
       adminPage.
        //10)User should enter any massage in the massage box
        //11) User should click send email button
        //12)User should see notification message after click send email button
        //13)User shoul close the page

        Driver.closeDriver();
    }

}
