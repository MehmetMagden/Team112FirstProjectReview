package tests.Seda;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import pages.PackagesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class US_31 extends MethodBase {

    /*
    I should be able to Log in admin dashboard.

    I should be able to verify that in the Packages Section, I can add a new package and confirm that

    I should be able to confirm that the added package can be edited.
  */
    AdminPage adminPage = new AdminPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    Faker faker = new Faker();

    @Test
    public void TC_31_01_AddPackagesToAdminDashboard() {

        extentTest = extentReports.createTest("TC31",
                     "User Adds New Packages to Admin Page Packages");
        testMethod.logInAdminPageToNavigate();

        adminPage.adminPagePackagesTab.click();
        adminPage.addPackages.click();

        actions.sendKeys(adminPage.addPackagesFirstTab, faker.name().name() + Keys.TAB)
               .sendKeys(faker.name().fullName() + Keys.TAB).perform();

        WebElement fileUpload = adminPage.addPackagesUploadImage;
        String filePath = System.getProperty("user.home") +
                         "\\IdeaProjects\\com.tripandway\\src\\test\\java\\utilities\\Sample_Image.jpg";
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

        testMethod.warningMessagesCheck("Package is added successfully!" ,
                                         adminPage.warningMessage.getText());
        extentTest.pass("Verifies that user successfully can add a new Packages");

    }

   @Test
    public void TC31_02_editAddedPackagesTest(){

       extentTest = extentReports.createTest("TC31_01",
                                             "If user can edit the added packages");
       testMethod.logInAdminPageToNavigate();

       adminPage.adminPagePackagesTab.click();
       actions.sendKeys(Keys.END);
       adminPage.addedPackagesEditing.click();

       adminPage.addPackagesFirstTab.sendKeys(" EditedName");
       adminPage.addPackagesSubmitButton.click();

       testMethod.warningMessagesCheck("Package is updated successfully!" ,
                                        adminPage.warningMessage.getText());
       extentTest.pass("Verifies user can edit the added page");
   }

    @Test
    public void TC31_03_negativePriceFormatTest() {

        extentTest = extentReports.createTest("TC31_01",
                         "If user can input non-numerical character to price field and submit the packages");
        testMethod.logInAdminPageToNavigate();

        adminPage.adminPagePackagesTab.click();

        adminPage.addPackages.click();

        actions.sendKeys(adminPage.addPackagesFirstTab, faker.name().name() + Keys.TAB)
                .sendKeys(faker.name().fullName() + Keys.TAB).perform();

        WebElement fileUpload = adminPage.addPackagesUploadImage;
        String filePath = System.getProperty("user.home") +
                          "\\IdeaProjects\\com.tripandway\\src\\test\\java\\utilities\\Sample_Image.jpg";
        fileUpload.sendKeys(filePath);

        adminPage.addPackagesStartDate.sendKeys("2023/06/28" + Keys.TAB);
        ReusableMethods.waitFor(2);
        actions.sendKeys("2023/07/28" + Keys.TAB).perform();
        ReusableMethods.waitFor(2);
        actions.sendKeys("2023/05/28" + Keys.TAB).perform();

        adminPage.addPackagesPriceTab.sendKeys(ConfigReader.getProperty("incorrectPriceFormat"));

        ReusableMethods.waitFor(2);

        adminPage.addPackagesSubmitButton.click();

        ReusableMethods.waitFor(2);

        Assert.assertTrue(adminPage.addPackagesSubmitButton.isDisplayed());
        extentTest.fail("Verifies that user can submit the form with incorrect PRICE format");

    }

    @Test
    public void TC31_04_negativeDateFormatEntryTest(){

        extentTest = extentReports.createTest("TC31_01",
                "If user can input incorrect date format to dates field and submit the packages");
        testMethod.logInAdminPageToNavigate();

        adminPage.adminPagePackagesTab.click();

        adminPage.addPackages.click();

        actions.sendKeys(adminPage.addPackagesFirstTab, faker.name().name() + Keys.TAB)
                .sendKeys(faker.name().fullName() + Keys.TAB).perform();

        WebElement fileUpload = adminPage.addPackagesUploadImage;
        String filePath = System.getProperty("user.home") +
                "\\IdeaProjects\\com.tripandway\\src\\test\\java\\utilities\\Sample_Image.jpg";
        fileUpload.sendKeys(filePath);

        ReusableMethods.waitFor(2);
        adminPage.addPackagesStartDate.sendKeys(ConfigReader.getProperty("incorrectDateFormat") + Keys.TAB);
        ReusableMethods.waitFor(2);
        actions.sendKeys(ConfigReader.getProperty("incorrectDateFormat") + Keys.TAB).perform();
        ReusableMethods.waitFor(2);
        actions.sendKeys(ConfigReader.getProperty("incorrectDateFormat") + Keys.TAB).perform();

        adminPage.addPackagesPriceTab.sendKeys("1000");

        ReusableMethods.waitFor(2);

        adminPage.addPackagesSubmitButton.click();

        ReusableMethods.waitFor(2);

        Assert.assertFalse(adminPage.addPackagesSubmitButton.isDisplayed());
        extentTest.fail("Verifies that user can submit the form with incorrect DATE format");
    }

    @Test
    public void TC31_05_negativeDateEntryLogicTest(){
        extentTest = extentReports.createTest("TC31_01",
                "If user can input dates without any logic");
        testMethod.logInAdminPageToNavigate();

        adminPage.adminPagePackagesTab.click();

        adminPage.addPackages.click();

        actions.sendKeys(adminPage.addPackagesFirstTab, faker.name().name() + Keys.TAB)
                .sendKeys(faker.name().fullName() + Keys.TAB).perform();

        WebElement fileUpload = adminPage.addPackagesUploadImage;
        String filePath = System.getProperty("user.home") +
                "\\IdeaProjects\\com.tripandway\\src\\test\\java\\utilities\\Sample_Image.jpg";
        fileUpload.sendKeys(filePath);

        adminPage.addPackagesStartDate.sendKeys("2023/07/28" + Keys.TAB);
        ReusableMethods.waitFor(2);
        actions.sendKeys("2023/06/28" + Keys.TAB).perform();
        ReusableMethods.waitFor(2);
        actions.sendKeys("2023/09/28" + Keys.TAB).perform();

        adminPage.addPackagesPriceTab.sendKeys(ConfigReader.getProperty("1000"));

        ReusableMethods.waitFor(2);

        adminPage.addPackagesSubmitButton.click();

        ReusableMethods.waitFor(2);

        Assert.assertTrue(adminPage.addPackagesSubmitButton.isDisplayed());
        extentTest.fail("Verifies that user can submit the form as START Date is later then END DATE");

    }
}



