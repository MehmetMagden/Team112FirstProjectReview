package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlogPages {

    public BlogPages(){
        PageFactory.initElements(Driver.getDriver(),this);


    }


}
