package tests.Ibrahim;


import org.testng.annotations.Test;

public class US_028 extends TestMethods {

    /*
    After logging in as an admin,
    I should be able to verify that in the Blog Section,
    I can add a new category to the Categories section
    and confirm that the added category can be edited.
     */

    TestMethods testMethods = new TestMethods();

    @Test
    public void TC2801userNavigatesAndVerifiesToAdminPage() {

        test = extent.createTest("TC_28_01", "User navigates admin dashboard page");
        testMethods.userNavigatesAndVerifiesToAdminPage();
        test.pass("Verify, if user can access admin dashboard page");

    }

    @Test
    public void TC2802userNavigatesAndVerifiesToCategoriesPageInBlogSection() {

        test = extent.createTest("TC_28_02", "User navigates Categories page in Blog section and verifies");
        testMethods.userNavigatesAndVerifiesToAdminPage();
        test.info("User navigates to admin dashboard page");
        testMethods.userNavigatesAndVerifiesToCategoriesPageInBlogSection();
        test.pass("Verify, if user can access Categories page in Blog section");

    }

    @Test
    public void TC2803userAddsNewCategoryAndVerifiesInCategorySection() {

        test = extent.createTest("TC_28_03", "User adds new category and verifies");
        testMethods.userNavigatesAndVerifiesToAdminPage();
        test.info("User navigates to admin dashboard page");
        testMethods.userNavigatesAndVerifiesToCategoriesPageInBlogSection();
        test.info("User navigates to categories page");
        testMethods.userAddsNewCategoryAndVerifiesInCategorySection();
        test.pass("Verify, if user can add new category");

    }

    @Test
    public void TC2804userEditsToAddedCategoryAndVerifiesInCategorySection() {

        test = extent.createTest("TC_28_04", "User edits the added category");
        testMethods.userNavigatesAndVerifiesToAdminPage();
        test.info("User navigates to admin dashboard page");
        testMethods.userNavigatesAndVerifiesToCategoriesPageInBlogSection();
        test.info("User navigates to categories page");
        testMethods.userEditsToAddedCategoryAndVerifiesInCategorySection();
        test.pass("Verify, if user can edit the added category");

    }

    @Test
    public void TC2805userDeletesToAddedCategoryAndVerifiesInCategorySection() {

        test = extent.createTest("TC_28_05", "User deletes the added category");
        testMethods.userNavigatesAndVerifiesToAdminPage();
        test.info("User navigates to admin dashboard page");
        testMethods.userNavigatesAndVerifiesToCategoriesPageInBlogSection();
        test.info("User navigates to categories page");
        testMethods.userDeletesToAddedCategoryAndVerifiesInCategorySection();
        test.pass("Verify, if user can delete the added category");

    }
}
