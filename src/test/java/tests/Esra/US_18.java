package tests.Esra;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_18 {
    BasePage basePage=new BasePage();
    RegistrationPage registrationPage=new RegistrationPage();
    @Test
    public void pozitiveRegistarationTest(){
        Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
        basePage.registrationButton.click();
        basePage.acceptCookiesButton.click();
        Faker faker= new Faker();

        registrationPage.registrationNameBox.sendKeys(faker.name().firstName());

        registrationPage.registrationEmailBox.sendKeys(faker.internet().emailAddress());

        registrationPage.registrationPasswordBox.sendKeys(ConfigReader.getProperty("userRegistrationValidPassword"));

        ReusableMethods.waitFor(2);

        registrationPage.makeRegistrationButton.click();

        Assert.assertTrue(registrationPage.loginButton.isDisplayed());
        Driver.quitDriver();

}

/*
Test with invalid password
 */
@Test
    public void NegativeRegistrationTest(){
    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
    basePage.registrationButton.click();
    basePage.acceptCookiesButton.click();
    Faker faker= new Faker();

    registrationPage.registrationNameBox.sendKeys(faker.name().firstName());

    registrationPage.registrationEmailBox.sendKeys(faker.internet().emailAddress());

    registrationPage.registrationPasswordBox.sendKeys(ConfigReader.getProperty("userRegistrationInvalidPassword"));

    ReusableMethods.waitFor(2);
    basePage.acceptCookies();

    registrationPage.makeRegistrationButton.click();

    Assert.assertTrue(registrationPage.makeRegistrationButton.isDisplayed());
    Driver.quitDriver();


}

@Test
    public void NegativeRegistrationTest01(){
    Driver.getDriver().get(ConfigReader.getProperty("tripAndWayUrl"));
    basePage.registrationButton.click();
    basePage.acceptCookiesButton.click();
    Faker faker= new Faker();

    registrationPage.registrationNameBox.sendKeys(faker.name().firstName());

    registrationPage.registrationEmailBox.sendKeys(ConfigReader.getProperty("userRegistrationInvalidEmailAddress"));

    registrationPage.registrationPasswordBox.sendKeys(ConfigReader.getProperty("userRegistrationValidPassword"));

    ReusableMethods.waitFor(2);
    basePage.acceptCookies();

    registrationPage.makeRegistrationButton.click();

    Assert.assertTrue(registrationPage.makeRegistrationButton.isDisplayed());
    Driver.quitDriver();


}



}
