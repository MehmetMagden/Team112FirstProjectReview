package tests.Ibrahim;

import org.testng.annotations.Test;
import utilities.TestBaseRapor;

public class US_013 extends TestBaseRapor {

    /*
    As a user, I should be able to navigate to the "Destination" page.
    I should then verify that the destinations are visible and active on the page.
     */

    TestMethods testMethods = new TestMethods();

    @Test()
    public void TC1301userNavigatesAndVerifiesToDestinationPage() {
        testMethods.TC1301userNavigatesAndVerifiesToDestinationPage();
    }

    @Test()
    public void TC1302userVerifiesDestinationPageVisibleAndActive() {
        testMethods.TC1302userVerifiesDestinationPageVisibleAndActive();
    }
}
