package tests.Ayse;


import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.PackagesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_03 {
    HomePage homePage = new HomePage();
    BasePage basePage=new BasePage();

    //User should be able to see the functions about hero area in the body section of the Home page
    @Test
    public void userCanSeeTheFunctionsAboutHeroArea() {

        homePage = new HomePage();
        basePage=new BasePage();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(5);
        basePage.acceptCookiesButton.click();
        homePage.exploreTheWorldArea.isDisplayed();
        ReusableMethods.waitFor(3);
        homePage.readMoreButtonUnderExploreTheWorldAreaText.isDisplayed();
        ReusableMethods.waitFor(3);
        homePage.sliderOnRightSideOfHeroArea.isDisplayed();
        ReusableMethods.waitFor(3);
        homePage.sliderOnLeftSideOfHeroArea.isDisplayed();
        ReusableMethods.waitFor(3);
        homePage.theWorldIsSoBeautifulAreaOnHomepage.isDisplayed();
        ReusableMethods.waitFor(3);
        homePage.readMoreButtonUnderTheWorldIsSoBeautifulText.isDisplayed();
        ReusableMethods.waitFor(3);
        homePage.salinaIslandAreaOnHomepage.isDisplayed();
        ReusableMethods.waitFor(3);
        homePage.readMoreButtonUnderSalinaIslandAreaText.isDisplayed();
        Driver.closeDriver();

    }
//User should be able to see the functions about "Our Services" section in the body section of the Homepage
    @Test
    public void userCanSeeTheFunctionsAboutOurServicesSection(){

        //1)User should access to the homepage
        homePage = new HomePage();
        basePage=new BasePage();
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(5);
        basePage.acceptCookiesButton.click();
        ReusableMethods.waitFor(5);

        //2)User should scroll the page until see the text of "Our Services" on the homepage
        ReusableMethods.waitForVisibility(homePage.ourServicesAreaOnHomepage,15);
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(homePage.ourServicesAreaOnHomepage).perform();


        //3)User should see"Our Services" text on the homepage
        //4)User should see text under the "Our Services" text on the homepage
        //5)User should see International Tour element on homepage
        //6)User should see Adventure Tour element on homepage
        //7)User should see Culture Tour element on homepage
        //8)User should see Bussiness Tour element on homepage
        //9)User should see Health Tour element on homepage
        //10)User should see Religious Tour element on homepage
        //11)User should close the page

    }
}
