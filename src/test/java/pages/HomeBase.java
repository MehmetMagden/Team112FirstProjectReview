package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomeBase {

    public HomeBase(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

}
