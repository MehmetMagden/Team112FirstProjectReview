package tests.Ibrahim;

import org.testng.Assert;
import pages.AdminPage;
import pages.BasePage;
import pages.DestinationsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TestMethods {
    BasePage basePage = new BasePage();
    DestinationsPage destinationsPage = new DestinationsPage();
    AdminPage adminPage = new AdminPage();
    String actualTestData = "";
    String expectedTestData = "";
    String ordersAmount = "";

    public void userNavigatesAndVerifiesToDestinationPage () {

        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage = new BasePage();
        basePage.acceptCookiesButton.click();
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("tripAndWayUrl");
        Assert.assertEquals(actualTestData, expectedTestData);
        Assert.assertTrue(basePage.homePageDestinationsButton.isEnabled());
        basePage.homePageDestinationsButton.click();
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("destinationsUrl");
        Assert.assertEquals(actualTestData, expectedTestData);

    }

    public void userVerifiesDestinationPageVisibleAndActive() {

        destinationsPage = new DestinationsPage();
        Assert.assertTrue(destinationsPage.destinationsImageWebElement.isDisplayed());
        Assert.assertTrue(destinationsPage.destinationsFirstPackageWebElement.isEnabled());

    }

    public void userNavigatesAndVerifiesToAdminPage(){

        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));
        ReusableMethods.waitFor(2);
        adminPage = new AdminPage();
        adminPage.adminLoginEmailAdressTextBox.sendKeys(ConfigReader.getProperty("adminLoginEmailValid"));
        adminPage.adminLogInPasswordTextBox.sendKeys(ConfigReader.getProperty("adminLoginPasswordValid"));
        adminPage.adminLogInButton.click();
        ReusableMethods.waitFor(2);
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminDashboardUrl");
        Assert.assertEquals(actualTestData, expectedTestData);
        ordersAmount = adminPage.adminMainPageCompletedOrdersWebElement.getText();
        ReusableMethods.waitFor(2);

    }

    public void userAccessAndVerifiesOrdersSection() {

        adminPage = new AdminPage();
        adminPage.adminDashboardOrderButton.click();
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminOrdersPageUrl");
        Assert.assertEquals(actualTestData,expectedTestData);
        actualTestData = adminPage.viewOrdersWebElement.getText();
        expectedTestData = "View Orders";
        Assert.assertTrue(actualTestData.contains(expectedTestData));
        ReusableMethods.waitFor(2);

    }

    public void userViewAndVerifiesAllPlacedOrder() {

        adminPage = new AdminPage();
        Assert.assertTrue(adminPage.allOrdersWebElement.isDisplayed());
        actualTestData = adminPage.allOrdersWebElement.getText();
        Assert.assertTrue(actualTestData.contains(ordersAmount));
        ReusableMethods.waitFor(2);

    }


    public void userNavigatesAndVerifiesToSubscribersPage() {

        adminPage = new AdminPage();
        adminPage.subscriberButton.click();
        adminPage.allSubscribersButton.click();
        ReusableMethods.waitFor(2);
        actualTestData = Driver.getDriver().getCurrentUrl();
        expectedTestData = ConfigReader.getProperty("adminSubscribersPageUrl");
        Assert.assertEquals(actualTestData,expectedTestData);
        Assert.assertTrue(adminPage.viewSubscribersWebElement.isDisplayed());
        ReusableMethods.waitFor(2);

    }

    public void userAccessAndVerifiesAllNewsletterSubscribers() {

        adminPage = new AdminPage();
        Assert.assertTrue(adminPage.allSubscribersButton.isEnabled());
        ReusableMethods.waitFor(2);
        actualTestData = adminPage.allSubscribersWebElement.getText();
        expectedTestData ="Showing 1 to 10 of";
        Assert.assertTrue(actualTestData.contains(expectedTestData));
        ReusableMethods.waitFor(2);

    }
}