

    package tests.Bahadir;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AboutUsPage;
import pages.BasePage;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.Driver;

    public class US02 {

        BasePage homeHeaderMenu = new BasePage();
        AboutUsPage aboutUsPage = new AboutUsPage();

        @Test
        public void homeHeaderMenu() {

            BasePage homeHeaderMenu = new BasePage();

            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));


            String expectedWordHomeHeaderMenu = "HOME";
            String actualWordHomeHeaderMenu = homeHeaderMenu.homePageHomeButton.getText();

            Assert.assertTrue(homeHeaderMenu.homePageHomeButton.isDisplayed());


            homeHeaderMenu.homePageHomeButton.click();

            Assert.assertTrue(homeHeaderMenu.homePageHomeButton.isEnabled());


        }

        @Test
        public void servicesHeaderMenu() {

            BasePage homeHeaderMenu = new BasePage();


            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));


            String expectedWordServicesHeaderMenu = "SERVICES";
            String actualServicesHeaderMenu = homeHeaderMenu.homePageServicesButton.getText();

            Assert.assertTrue(homeHeaderMenu.homePageServicesButton.isDisplayed());

            homeHeaderMenu.homePageServicesButton.click();

            String expectedWordServicesAfterServices = "SERVICES";
            String actualWordServicesAfterServices = homeHeaderMenu.servicesAfterHeaderService.getText();

            Assert.assertTrue(actualWordServicesAfterServices.contains(expectedWordServicesAfterServices));

            Driver.closeDriver();

        }

        @Test
        public void packagesHeaderMenu() {

            BasePage homeHeaderMenu = new BasePage();

            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));


            String expectedWordPackagesHeaderMenu = "PACKAGES";
            String actualPackagesHeaderMenu = homeHeaderMenu.homePagePackagesButton.getText();

            Assert.assertTrue(homeHeaderMenu.homePagePackagesButton.isDisplayed());

            homeHeaderMenu.homePagePackagesButton.click();

            String expectedWordPackagesAfterPackages = "PACKAGES";
            String actualWordPackagesAfterPackages = homeHeaderMenu.packagesAfterHeaderPackages.getText();

            Assert.assertTrue(actualWordPackagesAfterPackages.contains(expectedWordPackagesAfterPackages));

            Driver.closeDriver();

        }

        @Test
        public void aboutUsHeaderMenu() {

            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));


            String expectedWordAboutUsHeaderMenu = "ABOUT US";
            String actualWordAboutUsHeaderMenu = homeHeaderMenu.homePageAboutUsButton.getText();

            Assert.assertTrue(homeHeaderMenu.homePageAboutUsButton.isDisplayed());

            homeHeaderMenu.homePageAboutUsButton.click();

            String expectedWordAfterAboutUs = "OUR MISSION";
            String actualWordAfterAbuUs = aboutUsPage.aboutUsPageOurMission.getText();

            Assert.assertTrue(actualWordAfterAbuUs.contains(expectedWordAfterAboutUs));

            Driver.closeDriver();


        }

        @Test
        public void faqHeaderMenu() {

            BasePage homeHeaderMenu = new BasePage();

            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));


            String expectedWordFaqHeaderMenu = "FAQ";
            String actualFaqHeaderMenu = homeHeaderMenu.homePageFaqButton.getText();

            Assert.assertTrue(homeHeaderMenu.homePageFaqButton.isDisplayed());

            homeHeaderMenu.homePageFaqButton.click();

            String expectedWordFaqAfterFaq = "FAQ";
            String actualWordFaqAfterFaq = homeHeaderMenu.faqAfterHeaderFaq.getText();

            Assert.assertTrue(actualWordFaqAfterFaq.contains(expectedWordFaqAfterFaq));

            Driver.closeDriver();

        }

        @Test
        public void blogHeaderMenu() {

            BasePage homeHeaderMenu = new BasePage();

            Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));


            String expectedWordBlogHeaderMenu = "BLOG";
            String actualBlogHeaderMenu = homeHeaderMenu.homePageBlogButton.getText();

            Assert.assertTrue(homeHeaderMenu.homePageBlogButton.isDisplayed());

            homeHeaderMenu.homePageBlogButton.click();

            String expectedWordBlogAfterBlog = "BLOG";
            String actualWordBlogAfterBlog = homeHeaderMenu.blogAfterHeaderBlog.getText();

            Assert.assertTrue(actualWordBlogAfterBlog.contains(expectedWordBlogAfterBlog));

            Driver.closeDriver();

        }








    }





