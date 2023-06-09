package tests.Muhammed;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.ServicesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_012 extends TestBaseRapor {

        BasePage basePage= new BasePage();
        ServicesPage servicesPage= new ServicesPage();
        @Test
        public void US012_TC01ServicePageAndItems(){
                ServicesPage servicesPage1 = new ServicesPage();

                Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
                String ActualURL = Driver.getDriver().getCurrentUrl();
                String ExpectingURL = "https://qa.tripandway.com/";
                Assert.assertTrue(ActualURL.contains(ExpectingURL));
                //User access to home page

                basePage.acceptCookies();
                ReusableMethods.waitFor(2);
                ServicesPage.HeaderServicesButton.click();
                Assert.assertTrue(ServicesPage.ServiceItems.isDisplayed());
                Assert.assertTrue(ServicesPage.ServiceInternationalTOurItem.isDisplayed());
                Assert.assertTrue(ServicesPage.ServiceAdventureTourItem.isDisplayed());
                Assert.assertTrue(ServicesPage.ServiceCultureTourItem.isDisplayed());
                Assert.assertTrue(ServicesPage.ServiceBussinessTOurItem.isDisplayed());
                Assert.assertTrue(ServicesPage.ServiceHealthTOurItem.isDisplayed());
                Assert.assertTrue(ServicesPage.ServiceReligiousTOurItem.isDisplayed());
                ReusableMethods.waitFor(2);

                Assert.assertTrue(ServicesPage.ServiceInternationalTOurItem.isEnabled());
                Assert.assertTrue(ServicesPage.ServiceAdventureTourItem.isEnabled());
                Assert.assertTrue(ServicesPage.ServiceCultureTourItem.isEnabled());
                Assert.assertTrue(ServicesPage.ServiceBussinessTOurItem.isEnabled());
                Assert.assertTrue(ServicesPage.ServiceHealthTOurItem.isEnabled());
                Assert.assertTrue(ServicesPage.ServiceReligiousTOurItem.isEnabled());

        }



}
