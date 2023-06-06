package tests.Ibrahim;

import org.testng.annotations.Test;
import utilities.TestBaseRapor;

public class US_035 extends TestBaseRapor {

    /*
    After logging in as an admin,
    I should be able to verify that I can access
    and view the list of all newsletter subscribers
     */

    TestMethods testMethods = new TestMethods();

    @Test
    public void TC3501userNavigatesAndVerifiesToAdminPage (){
        testMethods.TC3501userNavigatesAndVerifiesToAdminPage();
    }

    @Test public void TC3502userNavigatesAndVerifiesToSubscribersPage () {
        testMethods.TC3502userNavigatesAndVerifiesToSubscribersPage();
    }

    @Test public void TC3503userAccessAndVerifiesAllNewsletterSubscribers () {
        testMethods.TC3503userAccessAndVerifiesAllNewsletterSubscribers();
    }


}
