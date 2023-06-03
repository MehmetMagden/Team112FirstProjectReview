package tests.Elcin;

import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US027 {


    @Test
    public  void adminDashboardFeatures(){
        AdminPage adminPage=new AdminPage();

        Driver.getDriver().get(ConfigReader.getProperty("adminLogInUrl"));







}





}
