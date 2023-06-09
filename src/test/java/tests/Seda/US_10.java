package tests.Seda;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;

public class US_10 extends MethodBase{

     /*
      As a user, I should be able to verify that I can view the terms and conditions page of the website.

     */

    BasePage basePage = new BasePage();
    @Test
    public void TC10_termsConditionPage(){

        testMethod.endOfTheHomePage();

        basePage.termsConditions.click();

        String expectedText = "TERMS AND CONDITIONS";
        String actualText = basePage.termsCondiotionsBanner.getText();
        Assert.assertTrue(actualText.contains(expectedText));



    }


}
