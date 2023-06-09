package tests.Mustafa;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.BlogPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_29 {
    /*
    TC_29_01	I should be able to log in to the admin dashboard.
                1) User opens browser
				2) User navigates the admin page
				3) Url Should be same with the test data
				4) User writes admin email address to Email Address Box
				5) User writes admin password to Password Box
				6) User clicks the Login Button
				7) User should see admin dashboard main page
				8) Url Should be same with the test data
	TC_29_02	I should be able to verify that I can add a new blog post in the Blogs section under the Blog Section menu item.
	            1) User should see the "Blog Section" in the left banner
				2) User clicks "Blog Section" button
				3) User should see the "Blogs" button
				4) User clicks the "Blogs" button
				5) User should see "Blogs" page
				6) Url Should be same with the test data
				7) User should see the "Add New" button
				8) User clicks the "Add New" button
				9) User should see "Add Blog" page
				10) Url Should be same with the test data
				11) User writes blog name in the "Blog Name" box
				12) User types the content of the blog in "Blog Content" box
				13) User types a short content in "Blog Short Content" box
				14) User uploads a photo under "Blog Photo" section.
				15) User selects a category from drop-down menu (SKIPPED)
				16) User selects Show Comment from drop-down menu (SKIPPED)
				17) User clicks the "Submit" button
				18) User should see the added blog post on the Blogs page.
	TC_29_03	I should be able to confirm that the added blog post can be edited.
	            1) User should see the "Edit Button" next to the added post.
				2) User clicks the "Edit Button"
				3) User should see "Edit Blog" page
				4) Actual Url Should contain the test data
				5) User edits the blog post name in the "Blog Name" box
				6) User clicks the "Update" button
				7) User should see "Blogs" page
				8) User should see the message "Blog is updated successfully!"
				9) User closes the browser
     */

    AdminPage adminPage = new AdminPage();
    LoginPage loginPage = new LoginPage();
    BlogPage blogPage = new BlogPage();
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl")); // Navigate to Admin Log in page
    }
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void TC_29_01_createBlogAsAdmin () {
        loginPage.loginAsAdmin();
        Assert.assertTrue(adminPage.adminDashboardVisibility.isDisplayed());  // Check if admin Dashboard is visible?

        blogPage.blogSection.click(); // Click Blog Section on the left menu
        blogPage.blogs.click(); // Click Blogs under "Blog Section".
        blogPage.blogsAddNewButton.click(); // Clicks Add New button under "Blogs" section.
        blogPage.blogTitle.sendKeys(faker.number().digits(2) + " New Blog Entry"); // Navigates to Blog Title and adds a random title.
        blogPage.blogContent.sendKeys("New Blog Content entry is provided."); // Navigates to Blog content and adds some content.
        blogPage.blogShortContent.sendKeys("Blog short content is provided!"); // Navigates to Blog short content and adds some content.

        WebElement chooseFile = blogPage.blogPhotoUpload;
        String filePath =  System.getProperty("user.home") + "\\IdeaProjects\\com.tripandway\\src\\test\\java\\utilities\\Sample_Image.jpg";
        chooseFile.sendKeys(filePath);

        blogPage.submitNewBlog.click(); // Submits the new blog entry.

        String expectedText = "New Blog Entry";
        Assert.assertTrue(blogPage.newBlogEntryCheck.getText().contains(expectedText));

        System.out.println(blogPage.newBlogEntryCheck.getText());

        ReusableMethods.waitFor(3);

    }

    @Test
    public void TC_29_02_editBlogEntry(){

        loginPage.loginAsAdmin();
        blogPage.blogSection.click(); // Click Blog Section on the left menu
        blogPage.blogs.click(); // Click Blogs under "Blog Section".

        blogPage.editBlog.click(); // 7th blog will be edited. If it doesn't work, try 8th or 9th etc.
        blogPage.blogTitle.sendKeys("    EDITED   ");
        blogPage.updateButton.click();
        ReusableMethods.waitFor(2);

        String actualMessage = adminPage.warningMessage.getText();
        String expectedMessage = "Blog is updated successfully!";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

}
