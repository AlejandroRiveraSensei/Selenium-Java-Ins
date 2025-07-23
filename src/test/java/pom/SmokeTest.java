package pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.UserData;

public class SmokeTest extends BaseTest{


    @Test
    public void loginSuccess(){
        login.login(UserData.getUsername("standard"), UserData.getPassword("standard"));
        Assert.assertEquals(inventory.getTitleText(),"Products");

    }

}
