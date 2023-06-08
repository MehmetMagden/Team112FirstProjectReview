package tests.Esra;

import java.util.Set;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_33 extends TestBaseRapor {
  // After logging in as an admin,
  // I should be able to verify that I can access the Orders section and view the details of any
  // specific order.
  BasePage basePage = new BasePage();
  AdminPage adminPage = new AdminPage();

  @BeforeMethod
  public void setUp() {
    Driver.getDriver()
        .get(ConfigReader.getProperty("adminLogInUrl")); // Navigate to Admin Log in page
  }

  @AfterMethod
  public void tearDown() {
    Driver.closeDriver();
  }

  @Test
  public void adminCheckOrdersDetailsTest() {
    extentTest =
        extentReports.createTest(
            "TC3301",
            "Verify that admin can access the Orders section and view the details of any specific order.");

    adminPage.adminLoginEmailAdressTextBox.sendKeys(
        ConfigReader.getProperty("adminLoginEmailValid"));
    adminPage.adminLogInPasswordTextBox.sendKeys(
        ConfigReader.getProperty("adminLoginPasswordValid"));
    adminPage.adminLogInButton.click();
    adminPage.adminDashboardOrderButton.click();
    ReusableMethods.waitFor(2);

    String firstPageWH = Driver.getDriver().getWindowHandle();
    adminPage.adminOrderDetailButton.click();
    ReusableMethods.waitFor(2);
    Set<String> allWH = Driver.getDriver().getWindowHandles();
    String secondWinddowHandleValue = "";
    for (String eachWH : allWH) {
      if (!eachWH.equals(firstPageWH)) {
        secondWinddowHandleValue = eachWH;
      }
    }
    Driver.getDriver().switchTo().window(secondWinddowHandleValue);

    Assert.assertTrue(adminPage.adminOrderPageOrderInformationElement.isDisplayed());
    extentTest.pass(
        "Admin can access the Orders section and view the details of any specific order. ");
  }
}
