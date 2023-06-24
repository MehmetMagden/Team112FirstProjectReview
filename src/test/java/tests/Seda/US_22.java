package tests.Seda;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_22 extends MethodBase {


    /*
         As a user, I should be able to verify that
         I can change my password after logging in, and if I forget my password,
         I can retrieve it through the "Forgot Password" link.

         */
    LoginPage loginPage = new LoginPage();
    AdminPage adminPage = new AdminPage();

    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void TC_022_01_UpdatePasswordAfterLogin() {

        extentTest = extentReports.createTest("TC22",
                "User update the password through user dashboard");
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        loginPage.cookiesAcceptButton.click();

        loginPage.loginPageLoginButton2.click();
        loginPage.loginPageEmailAddressTextBox.sendKeys(ConfigReader.getProperty("userLogInPasswordUpdateEmail"));
//**** normally  password should had been taken from configuration.properties file. but as they say: if it works, don't touch it :D
// or if it has to be changed everytime we can create  a random password from faker class
        loginPage.loginPagePasswordBox.sendKeys("Seda1234568.");
        ReusableMethods.waitFor(2);
        loginPage.loginPageLoginButton.click();

        loginPage.updateLoginPassword.click();
        ReusableMethods.waitFor(1);
        loginPage.enterNewPassword.sendKeys("Seda1234569."); // please update below password the given one here
                                                                      // once you need to run the test again
        ReusableMethods.waitFor(2);
        loginPage.updateNewPassword.click();
        ReusableMethods.waitFor(2);

       testMethod.warningMessagesCheck("Password is updated successfully", adminPage.warningMessage.getText());
       extentTest.pass("Verifies that user can change the passpord through user dashboard");

    }

      @Test
      public void TC22_01_forgetPasswordActivity () {


          extentTest = extentReports.createTest("TC22_01",
                  "User retrieve it through the 'Forgot Password' link");
          Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
          loginPage.cookiesAcceptButton.click();

          loginPage.loginPageLoginButton2.click();

          loginPage.forgetPassword.click();
          loginPage.forgetPasswordEmailBox.sendKeys(ConfigReader.getProperty("userLogInPasswordUpdateEmail"));
          loginPage.forgetPasswordSubmit.click();

          ReusableMethods.waitFor(2);

          testMethod.warningMessagesCheck("Please check your email to get password reset information",
                                          adminPage.warningMessage.getText());
          extentTest.pass("Verifies that user can reach the account through Forget Password Link");

      }

}
