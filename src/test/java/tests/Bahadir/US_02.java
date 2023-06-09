

    package tests.Bahadir;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutUsPage;
import pages.BasePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

    public class US_02 extends TestBaseRapor {

        BasePage homeHeaderMenu = new BasePage();
        AboutUsPage aboutUsPage = new AboutUsPage();

        @Test
        public void homeHeaderMenu() {

            extentTest=extentReports.createTest("TC_02_01","user views homepage");

            BasePage homeHeaderMenu = new BasePage();

            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));


            String expectedWordHomeHeaderMenu = "HOME";
            String actualWordHomeHeaderMenu = homeHeaderMenu.homePageHomeButton.getText();

            extentTest.pass("User can see homeHeaderButton");
            Assert.assertTrue(homeHeaderMenu.homePageHomeButton.isDisplayed());


            homeHeaderMenu.homePageHomeButton.click();
            extentTest.info("homeHeaderButton is clickable");
            Assert.assertTrue(homeHeaderMenu.homePageHomeButton.isEnabled());


        }

        @Test
        public void servicesHeaderMenu() {

            extentTest=extentReports.createTest("TC_02_02","user views homepage");

            BasePage homeHeaderMenu = new BasePage();


            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));


            String expectedWordServicesHeaderMenu = "SERVICES";
            String actualServicesHeaderMenu = homeHeaderMenu.homePageServicesButton.getText();

            extentTest.pass("User can see servicesHeaderButton");
            Assert.assertTrue(homeHeaderMenu.homePageServicesButton.isDisplayed());

            homeHeaderMenu.homePageServicesButton.click();

            String expectedWordServicesAfterServices = "SERVICES";
            String actualWordServicesAfterServices = homeHeaderMenu.servicesAfterHeaderService.getText();

            extentTest.info("Services button on servicesHeaderButton  is clickable");
            Assert.assertTrue(actualWordServicesAfterServices.contains(expectedWordServicesAfterServices));

            Driver.closeDriver();

        }

        @Test
        public void packagesHeaderMenu() {

            extentTest=extentReports.createTest("TC_02_03","user views homepage");

            BasePage homeHeaderMenu = new BasePage();

            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));


            String expectedWordPackagesHeaderMenu = "PACKAGES";
            String actualPackagesHeaderMenu = homeHeaderMenu.homePagePackagesButton.getText();

            extentTest.pass("User can see packagesHeaderButton");
            Assert.assertTrue(homeHeaderMenu.homePagePackagesButton.isDisplayed());

            homeHeaderMenu.homePagePackagesButton.click();

            String expectedWordPackagesAfterPackages = "PACKAGES";
            String actualWordPackagesAfterPackages = homeHeaderMenu.packagesAfterHeaderPackages.getText();

            extentTest.info("Services button on packagesHeaderButton  is clickable");
            Assert.assertTrue(actualWordPackagesAfterPackages.contains(expectedWordPackagesAfterPackages));

            Driver.closeDriver();

        }

        @Test
        public void aboutUsHeaderMenu() {


            extentTest=extentReports.createTest("TC_02_04","user views homepage");

            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));


            String expectedWordAboutUsHeaderMenu = "ABOUT US";
            String actualWordAboutUsHeaderMenu = homeHeaderMenu.homePageAboutUsButton.getText();

            extentTest.pass("User can see aboutUsHeaderButton");
            Assert.assertTrue(homeHeaderMenu.homePageAboutUsButton.isDisplayed());

            homeHeaderMenu.homePageAboutUsButton.click();

            String expectedWordAfterAboutUs = "OUR MISSION";
            String actualWordAfterAbuUs = aboutUsPage.aboutUsPageOurMission.getText();

            extentTest.info("Services button on aboutUsHeaderButton is clickable");
            Assert.assertTrue(actualWordAfterAbuUs.contains(expectedWordAfterAboutUs));

            Driver.closeDriver();


        }

        @Test
        public void faqHeaderMenu() {

            extentTest=extentReports.createTest("TC_02_05","user views homepage");

            BasePage homeHeaderMenu = new BasePage();

            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));


            String expectedWordFaqHeaderMenu = "FAQ";
            String actualFaqHeaderMenu = homeHeaderMenu.homePageFaqButton.getText();

            extentTest.pass("User can see faqHeaderButton");
            Assert.assertTrue(homeHeaderMenu.homePageFaqButton.isDisplayed());

            homeHeaderMenu.homePageFaqButton.click();

            String expectedWordFaqAfterFaq = "FAQ";
            String actualWordFaqAfterFaq = homeHeaderMenu.faqAfterHeaderFaq.getText();

            extentTest.info("Services button on blogHeaderButton is clickable");
            Assert.assertTrue(actualWordFaqAfterFaq.contains(expectedWordFaqAfterFaq));

            Driver.closeDriver();

        }

        @Test
        public void blogHeaderMenu() {

            extentTest=extentReports.createTest("TC_02_06","user views homepage");

            BasePage homeHeaderMenu = new BasePage();

            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));


            String expectedWordBlogHeaderMenu = "BLOG";
            String actualBlogHeaderMenu = homeHeaderMenu.homePageBlogButton.getText();

            extentTest.pass("User can see blogHeaderButton");
            Assert.assertTrue(homeHeaderMenu.homePageBlogButton.isDisplayed());

            homeHeaderMenu.homePageBlogButton.click();

            String expectedWordBlogAfterBlog = "BLOG";
            String actualWordBlogAfterBlog = homeHeaderMenu.blogAfterHeaderBlog.getText();

            extentTest.info("Services button on blogHeaderButton is clickable");
            Assert.assertTrue(actualWordBlogAfterBlog.contains(expectedWordBlogAfterBlog));

            Driver.closeDriver();

        }








    }





