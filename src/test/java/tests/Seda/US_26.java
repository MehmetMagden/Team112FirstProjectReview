package tests.Seda;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.TestBaseRapor;

public class US_26 extends MethodBase {

    /*
    I should be able to verify that I can access the administration panel of the website using admin credentials
     and view the admin dashboard.
     */

    AdminPage adminPage = new AdminPage();
   // MethodBase testMethod = new MethodBase();

    @Test
    public void navigateTheAdminDashboard() {

        extentTest = extentReports.createTest("TC26",
                                              "User Navigates To Admin Dashboard to navigate Admin Panel");

       testMethod.logInAdminPageToNavigate();

       Assert.assertTrue(adminPage.adminDashboardVisibility.isDisplayed());
       extentTest.pass("Verifies that user can see Admin Panel items in the page");

    }
}
