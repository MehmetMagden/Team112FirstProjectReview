package tests.Ibrahim;

import org.testng.annotations.Test;

public class US_013 extends TestMethods {

    /*
    As a user, I should be able to navigate to the "Destination" page.
    I should then verify that the destinations are visible and active on the page.
     */

    TestMethods testMethods = new TestMethods();

    @Test()
    public void TC1301userNavigatesAndVerifiesToDestinationPage() {

        test = extent.createTest("TC_13_01", "User navigates destinations page");
        testMethods.userNavigatesAndVerifiesToDestinationPage();
        test.pass("Verify, if User can access Destination page");

    }


    @Test
    public void TC1302userVerifiesDestinationPageVisibleAndActive() {

        test = extent.createTest("TC_13_02", "User verifies if destinations page is visible and active");
        testMethods.userNavigatesAndVerifiesToDestinationPage();
        test.info("User navigates to Destination page");
        testMethods.userVerifiesDestinationPageVisibleAndActive();
        test.pass("Verify, if destination page is visible and active");

    }
}
