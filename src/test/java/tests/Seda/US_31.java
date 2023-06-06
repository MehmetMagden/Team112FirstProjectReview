package tests.Seda;

import org.testng.annotations.BeforeTest;
import utilities.ConfigReader;
import utilities.Driver;

import java.awt.dnd.DragGestureEvent;

public class US_31 {

    /*
    I should be able to login admin dashboard.

   I should be able to verify that in the Packages Section, I can add a new package and confirm that

   I should be able to confirm that the added package can be edited.

  */

 @BeforeTest
    public void setUp (){
     Driver.getDriver().get(ConfigReader.getProperty(""));


 }




}
