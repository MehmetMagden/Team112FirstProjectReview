package tests.Ibrahim;

import org.testng.annotations.Test;


public class US_032 extends TestMethods {

    /*
    After logging in as an admin,
    I should be able to verify that I can access the Orders section and
    view all the orders placed.
     */

    TestMethods testMethods = new TestMethods();

    @Test()
    public void TC3201userNavigatesAndVerifiesToAdminPage() {

        test = extent.createTest("TC_32_01", "User navigates admin dashboard page");
        testMethods.userNavigatesAndVerifiesToAdminPage();
        test.pass("Verify, if user can access admin dashboard page");

    }

    @Test
    public void TC3202userAccessAndVerifiesOrdersSection() {

        test = extent.createTest("TC_32_02", "User navigates orders page");
        testMethods.userNavigatesAndVerifiesToAdminPage();
        test.info("User navigates to admin dashboard page");
        testMethods.userAccessAndVerifiesOrdersSection();
        test.pass("Verify, if user can access Orders Section");

    }

    @Test
    public void TC3203userViewsAndVerifiesAllPlacedOrder() {

        test = extent.createTest("TC_32_03", "User views and verifies all placed orders");
        testMethods.userNavigatesAndVerifiesToAdminPage();
        test.info("User navigates to admin dashboard page");
        testMethods.userAccessAndVerifiesOrdersSection();
        test.info("User navigates to orders page");
        testMethods.userViewAndVerifiesAllPlacedOrder();
        test.pass("Verify, if user can see All Placed Orders");

    }
}
