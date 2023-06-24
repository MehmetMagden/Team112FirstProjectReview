package tests.Kaan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_030 {
    AdminPage adminPage = new AdminPage();
    Actions actions = new Actions(Driver.getDriver());

//**** to create a report from this class we should extend it to TestBaseRapor class
//**** it test methods should start with " extentTest = extentReports.createTest("TC0314", "description");
//**** for each step we entered excel file there should be extentTest.info explaining
//**** for each assertion we should enter info with extentTest.pass code
// you did it at second user story, I did not see it when I was checking this class  :D

   /*
   After logging in as an admin,
   I should be able to verify that in the Destinations section,
   I can add a new destination and confirm that the added destination can be edited
    */

    @Test
    public void TC_30_01_adminLoginAddAndEditPackageTest() {


        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();

        String expectedTitle = "Admin Panel";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        adminPage.adminDestinationsTab.click();
        adminPage.addAdminDestinations.click();


        adminPage.addDestinationsName.sendKeys("Costa del Huddersfield"+ Keys.TAB);
//**** there is no perform() code at the end
        actions.sendKeys("Slug"+ Keys.TAB)
               .sendKeys("Heading"+ Keys.TAB)
               .sendKeys("Short Description"+ Keys.TAB);

        adminPage.addDestinationsName.sendKeys("Costa del Huddersfield"+ Keys.TAB);
        actions.sendKeys("hey"+ Keys.TAB)
               .sendKeys("now"+ Keys.TAB)
               .sendKeys("get up"+ Keys.TAB)

               .sendKeys("Package Heading"+ Keys.TAB)
               .sendKeys("Package Subheading"+ Keys.TAB)
               .sendKeys("Detail Heading"+ Keys.TAB)
               .sendKeys("Detail Subheading"+ Keys.TAB)
               .sendKeys().perform();

        WebElement uploadPhoto = adminPage.addDestinationsUploadImage;
        String filePath = System.getProperty("user.home")+"\\IdeaProjects\\com.tripandway\\src\\test\\java\\utilities\\Sample_Image.jpg";
        uploadPhoto.sendKeys(filePath);

        adminPage.destinationsSubmitButton.click();

        String expectedWarningMessage = "Destination is added successfully!";
        String addDestinationsSubmitMessage = adminPage.warningMessage.getText();
        Assert.assertEquals(addDestinationsSubmitMessage, expectedWarningMessage);

//**** to scroll somewhere in the page I prefer using a webelement instead of using numbers. If we use numbers it may not work on different computers
        js.executeScript("window.scrollBy(0,10000)");
        adminPage.editDestinationButton.click();

       adminPage.addDestinationsName.clear();
        adminPage.addDestinationsName.sendKeys("Bolu Abant"+Keys.TAB);
        js.executeScript("window.scrollBy(0,10000)");
       adminPage.destinationsSubmitButton.click();


        String expectedWarningMessage2 = "Destination is updated successfully!";
        String editDestinationsSubmitMessage = adminPage.warningMessage.getText();
        Assert.assertEquals(editDestinationsSubmitMessage, expectedWarningMessage2);

        js.executeScript("window.scrollBy(0,10000)");
        ReusableMethods.waitFor(3);
        Driver.closeDriver();










    }




    }
