package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DestinationsPage {


    public DestinationsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//div[@class='banner-text']")////h1[text()='Destinations']
    public WebElement destinationsImageWebElement;

    @FindBy (xpath = "//div[@class='col-md-4 col-xs-6 clear-three wow fadeIn']")
    public WebElement destinationsFirstPackageWebElement;

    @FindBy(xpath = "//div[@class='country-text']")//(//h2)[1]
    public WebElement titleEachDestinations;
}
