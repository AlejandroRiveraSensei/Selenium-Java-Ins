package pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.UserData;

public class LoginTests extends BaseTest{

    @Test(groups = "e2e")
    public void loginBlocked(){
        login.login("locked_out_user", "secret_sauce");
        Assert.assertEquals(login.getErrorMessage(),"Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void loginInvalidUser(){
        login.login("incorrect", "secret_sauce");
        Assert.assertEquals(login.getErrorMessage(),"Epic sadface: and password do not match any user in this service");
    }

    @Test
    public void loginSuccess(){
        login.login(UserData.getUsername("standard"), UserData.getPassword("standard"));
        Assert.assertEquals(inventory.getTitleText(),"Products");
    }

    @Test
    public void loginEmptyFields(){
        login.login("", "");
        Assert.assertTrue(login.getErrorMessage().contains("Username is required"));
    }

    @Test
    public void logout(){
        login.login("standard_user", "secret_sauce");
        sideMenu.logout();
        Assert.assertEquals(login.getCurrentURL(),"https://www.saucedemo.com/");
    }

}
