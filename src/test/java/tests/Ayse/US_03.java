package tests.Ayse;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.PackagesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_03 {
   private HomePage homePage = new HomePage();
    private BasePage basePage=new BasePage();

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        ReusableMethods.waitFor(2);


    }


    //User should be able to see the functions about hero area in the body section of the Home page
    @Test(priority = 2)
    public void userCanSeeTheFunctionsAboutHeroArea() {

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


    }
//User should be able to see the functions about "Our Services" section in the body section of the Homepage
    @Test(priority = 1)
    public void userCanSeeTheFunctionsAboutOurServicesSection(){

        //1)User should access to the homepage
        basePage.acceptCookiesButton.click();
        ReusableMethods.waitFor(5);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top)", homePage.ourServicesAreaOnHomepage);

      homePage.ourServicesAreaOnHomepage.isDisplayed();




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

    @AfterMethod
    public void tearDown(){

        Driver.closeDriver();

    }
}
