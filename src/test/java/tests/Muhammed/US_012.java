package tests.Muhammed;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.ServicesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;



public class US_012 extends TestBaseRapor {


        @BeforeMethod
        public void setUp() {
                Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));

        }
        @AfterMethod
        public void tearDown() {Driver.closeDriver();

        }


        @Test
        public void US012_TC01ServicePageAndItems() {

                BasePage basePage = new BasePage();
                ServicesPage servicesPage = new ServicesPage();
                ServicesPage servicesPage1 = new ServicesPage();


                String ActualURL = Driver.getDriver().getCurrentUrl();
                String ExpectingURL = "https://qa.tripandway.com/";
                Assert.assertTrue(ActualURL.contains(ExpectingURL));
                //User access to home page

        }
        @Test
        public void US012_TC02ServicePageAndItemsCheck(){


                BasePage basePage = new BasePage();
                ServicesPage servicesPage = new ServicesPage();
                ServicesPage servicesPage1 = new ServicesPage();



              //  basePage.acceptCookies();
                ReusableMethods.waitFor(3);
                ServicesPage.HeaderServicesButton.click();
                Assert.assertTrue(ServicesPage.ServiceItems.isDisplayed());
                Assert.assertTrue(ServicesPage.ServiceInternationalTOurItem.isDisplayed());
                Assert.assertTrue(ServicesPage.ServiceAdventureTourItem.isDisplayed());
                Assert.assertTrue(ServicesPage.ServiceCultureTourItem.isDisplayed());
                ReusableMethods.waitFor(3);
              Assert.assertTrue(ServicesPage.ServiceBusinessTOurItem.isDisplayed());

                ReusableMethods.waitFor(3);

                Assert.assertTrue(ServicesPage.ServiceInternationalTOurItem.isEnabled());
                Assert.assertTrue(ServicesPage.ServiceAdventureTourItem.isEnabled());
                Assert.assertTrue(ServicesPage.ServiceCultureTourItem.isEnabled());
                Assert.assertTrue(ServicesPage.ServiceBusinessTOurItem.isEnabled());
                Assert.assertTrue(ServicesPage.ServiceHealthTOurItem.isEnabled());
                Assert.assertTrue(ServicesPage.ServiceReligiousTOurItem.isEnabled());
                ReusableMethods.waitFor(5);

        }



}
