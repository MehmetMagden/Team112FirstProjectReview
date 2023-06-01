package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AboutUsPage {

    public AboutUsPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }

}
