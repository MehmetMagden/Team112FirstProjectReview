package tests.Ibrahim;

import org.testng.annotations.Test;
import utilities.TestBaseRapor;

public class US_032 extends TestBaseRapor {

    /*
    After logging in as an admin,
    I should be able to verify that I can access the Orders section and
    view all the orders placed.
     */

    TestMethods testMethods = new TestMethods();

    @Test()
    public void TC3201userNavigatesAndVerifiesToAdminPage() {
        testMethods.TC3201userNavigatesAndVerifiesToAdminPage();
    }

    @Test
    public void TC3202userAccessAndVerifiesOrdersSection() {
        testMethods.TC3202userAccessAndVerifiesOrdersSection();
    }

    @Test
    public void TC3203userViewsAndVerifiesAllPlacedOrder() {
        testMethods.TC3203userViewAndVerifiesAllPlacedOrder();
    }
}
