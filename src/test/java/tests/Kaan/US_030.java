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

        adminPage.adminPagePackagesTab.click();
        adminPage.addPackages.click();


        adminPage.addPackagesFirstTab.sendKeys("Name"+ Keys.TAB);
        actions.sendKeys("Slug"+ Keys.TAB).perform();

        WebElement fileUpload = adminPage.addPackagesUploadImage;
        String filePath =  System.getProperty("user.home") + "/Desktop/Wise Quarter/project_sample_file.jpeg";
        fileUpload.sendKeys(filePath);


        adminPage.addPackagesDescription.sendKeys("Description");
        actions.sendKeys("Short Description"+ Keys.TAB).perform();
        actions.sendKeys("Location" + Keys.TAB).perform();
        actions.sendKeys("Location22" + Keys.TAB).perform();

        ReusableMethods.waitFor(2);

        actions.sendKeys("2023/06/28" + Keys.TAB).perform();
        ReusableMethods.waitFor(2);
        actions.sendKeys("2023/07/28" + Keys.TAB).perform();
        ReusableMethods.waitFor(2);
        actions.sendKeys("2023/05/28" + Keys.TAB).perform();
        actions.sendKeys("Map" + Keys.TAB).perform();
        actions.sendKeys("Itenary" + Keys.TAB).perform();
        actions.sendKeys("Price" + Keys.TAB).perform();
        actions.sendKeys("Policy" + Keys.TAB).perform();
        actions.sendKeys("Terms" + Keys.TAB).perform();

        WebElement isFeatured = adminPage.addPackagesIsFeatured;
        Select selectFeatured = new Select(isFeatured);
        ReusableMethods.waitFor(2);
        selectFeatured.selectByValue("Yes");

        WebElement destination = adminPage.addPackagesDestination;
        Select selectDestination = new Select(destination);
        ReusableMethods.waitFor(2);
        selectDestination.selectByVisibleText("Istanbul, Turkey");

        Driver.quitDriver();


    }




    }
