package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ServicesPage {

    public ServicesPage(){
        PageFactory.initElements(Driver.getDriver(),this);


    }

}
