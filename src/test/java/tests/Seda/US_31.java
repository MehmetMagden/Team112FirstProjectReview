package tests.Seda;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import com.sun.source.tree.AssertTree;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.dnd.DragGestureEvent;
import java.security.Key;
import java.time.Duration;


public class US_31 {

    /*
    I should be able to Log in admin dashboard.

   I should be able to verify that in the Packages Section, I can add a new package and confirm that

   I should be able to confirm that the added package can be edited.

  */

    AdminPage adminPage = new AdminPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void TC_31_AddPackagesToAdminDashboard() {

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();

        String expectedTitle = "Admin Panel";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        adminPage.adminPagePackagesTab.click();
        adminPage.addPackages.click();

       actions.sendKeys(adminPage.addPackagesFirstTab, "Name" + Keys.TAB)
              .sendKeys("Slug" + Keys.TAB).perform();

        WebElement fileUpload = adminPage.addPackagesUploadImage;
        //String filePath =  System.getProperty("user.home") + "/Desktop/Wise Quarter/project_sample_file.jpeg";
        String filePath = System.getProperty("user.home") + "\\IdeaProjects\\com.tripandway\\src\\test\\java\\utilities\\Sample_Image.jpg";
        fileUpload.sendKeys(filePath);

        actions.sendKeys(adminPage.addPackagesDescription, "Description")
                .sendKeys("Short Description" + Keys.TAB)
                .sendKeys("Location" + Keys.TAB)
                .sendKeys("Deneme" + Keys.TAB).perform();

        ReusableMethods.waitFor(2);

        actions.sendKeys("2023/06/28" + Keys.TAB).perform();
        ReusableMethods.waitFor(2);
        actions.sendKeys("2023/07/28" + Keys.TAB).perform();
        ReusableMethods.waitFor(2);
        actions.sendKeys("2023/05/28" + Keys.TAB)
                .sendKeys("Map" + Keys.TAB)
                .sendKeys("Itinerary" + Keys.TAB)
                .sendKeys("Price" + Keys.TAB)
                .sendKeys("Policy" + Keys.TAB)
                .sendKeys("Terms" + Keys.TAB).perform();

        WebElement isFeatured = adminPage.addPackagesIsFeatured;
        Select selectFeatured = new Select(isFeatured);
        ReusableMethods.waitFor(2);
        selectFeatured.selectByVisibleText("Yes");

        WebElement destination = adminPage.addPackagesDestination;
        Select selectDestination = new Select(destination);
        ReusableMethods.waitFor(2);
        selectDestination.selectByVisibleText("Istanbul, Turkey");

        actions.sendKeys(adminPage.getAddPackagesTitle, "Title")
                .sendKeys("Meta Description" + Keys.TAB).perform();

        adminPage.addPackagesSubmitButton.click();

        String expectedWarningMessage = "Package is added successfully!";
        String submitWarningMessage = adminPage.warningMessage.getText();
        Assert.assertEquals(submitWarningMessage, expectedWarningMessage);

    }

    @Test
    public void TC31_01NegativePriceFormatTest() {

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();

        adminPage.adminPagePackagesTab.click();
        adminPage.addPackages.click();

        adminPage.addPackagesFirstTab.sendKeys("Name" + Keys.TAB);
        actions.sendKeys("Slug" + Keys.TAB).perform();

        WebElement fileUpload = adminPage.addPackagesUploadImage;
        String filePath = System.getProperty("user.home") + "\\IdeaProjects\\com.tripandway\\src\\test\\java\\utilities\\Sample_Image.jpg";
        fileUpload.sendKeys(filePath);

        ReusableMethods.waitFor(3);

        jse.executeScript("window.scrollBy(0,800)");

        adminPage.addPackagesStartDate.sendKeys("2023/06/28" + Keys.TAB);
        ReusableMethods.waitFor(2);
        actions.sendKeys("2023/07/28" + Keys.TAB).perform();
        ReusableMethods.waitFor(2);
        actions.sendKeys("2023/05/28" + Keys.TAB).perform();

        jse.executeScript("window.scrollBy(0,650)");

        WebElement priceField =  adminPage.addPackagesPriceTab;

        priceField.sendKeys("ABDCHskh");

        ReusableMethods.waitFor(2);

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(priceField.getAttribute("value").matches("\\d+"),
                "Price field should only contain numeric Value");

        adminPage.addPackagesSubmitButton.click();

        ReusableMethods.waitFor(2);

        String expectedWarningMessage = "Error Message";
        String actualWarningMessage = adminPage.warningMessage.getText();
        softAssert.assertEquals(actualWarningMessage , expectedWarningMessage, "Non-numeric characters should not be accepted");

        softAssert.assertAll();

    }

   @Test
    public void editAddedPackagesTest(){

       Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
       adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
       adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
       adminPage.adminLogInButton.click();

       adminPage.adminPagePackagesTab.click();
       actions.sendKeys(Keys.END);
       adminPage.addedPackagesEditing.click();

       adminPage.addPackagesFirstTab.sendKeys(" EditedName");
       adminPage.addPackagesSubmitButton.click();

       String expectedWarningMessage = "Package is updated successfully!";
       String submitWarningMessage = adminPage.warningMessage.getText();
       Assert.assertEquals(submitWarningMessage, expectedWarningMessage);
   }

}
