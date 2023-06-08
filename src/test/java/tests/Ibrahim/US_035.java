package tests.Ibrahim;

import org.testng.annotations.Test;

public class US_035 extends TestMethods {

    /*
    After logging in as an admin,
    I should be able to verify that I can access
    and view the list of all newsletter subscribers
     */

    TestMethods testMethods = new TestMethods();

    @Test
    public void TC3501userNavigatesAndVerifiesToAdminPage() {

        test = extent.createTest("TC_35_01", "User navigates admin dashboard page");
        testMethods.userNavigatesAndVerifiesToAdminPage();
        test.pass("Verify, if user can access admin dashboard page");

    }

    @Test
    public void TC3502userNavigatesAndVerifiesToSubscribersPage() {

        test = extent.createTest("TC_35_02", "User navigates Subscribers page");
        testMethods.userNavigatesAndVerifiesToAdminPage();
        test.info("User navigates to admin dashboard page");
        testMethods.userNavigatesAndVerifiesToSubscribersPage();
        test.pass("Verify, if user can access Subscribers page");

    }

    @Test
    public void TC3503userAccessAndVerifiesAllNewsletterSubscribers() {

        test = extent.createTest("TC_35_03", "User navigates All Newsletter Subscribers page");
        testMethods.userNavigatesAndVerifiesToAdminPage();
        test.info("User navigates to admin dashboard page");
        testMethods.userNavigatesAndVerifiesToSubscribersPage();
        test.info("User navigates to Subscribers page");
        testMethods.userAccessAndVerifiesAllNewsletterSubscribers();
        test.pass("Verify, if user can access All Subscribers");

    }
}
