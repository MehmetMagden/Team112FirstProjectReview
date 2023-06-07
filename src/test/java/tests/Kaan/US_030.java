package tests.Kaan;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_030 {
    AdminPage adminPage = new AdminPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void TC_30_01_adminLogin() {

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayAdminURL"));
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();

        String expectedTitle = "Admin Panel";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        adminPage.adminDestinationsTab.click();
        adminPage.addAdminDestinations.click();

        adminPage.addDestinationsName.sendKeys("Costa del Hudderfield"+ Keys.TAB);
        actions.sendKeys("Slug"+ Keys.TAB).perform();
        actions.sendKeys("Heading"+ Keys.TAB).perform();
        actions.sendKeys("Short Description"+ Keys.TAB).perform();
        actions.sendKeys("Package Heading"+ Keys.TAB).perform();
        actions.sendKeys("Package Subheading"+ Keys.TAB).perform();
        actions.sendKeys("Detail Heading"+ Keys.TAB).perform();
        actions.sendKeys("Detail Subheading"+ Keys.TAB).perform();



        WebElement uploadPhoto = adminPage.addDestinationsUploadImage;
        String filePath = System.getProperty("user.home")+"C:\\Users\\Admin\\IdeaProjects\\com.tripandway\\src\\test\\java\\utilities\\blog_photo.jpg";
        uploadPhoto.sendKeys(filePath);

    }




    }
