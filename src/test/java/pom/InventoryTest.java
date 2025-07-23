package pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.UserData;

public class InventoryTest extends BaseTest{

    @Test(groups = "e2e")
    public void addProductTest(){
        // Step 1: Login
        login.login(UserData.getUsername("standard"),UserData.getPassword("standard"));

        //Step 2: Click add to cart
        inventory.clickAddToCart();

        //Validar que el badge counter contega "1"
        Assert.assertEquals(inventory.getTextBadgeCounter(),"1");

    }

    @Test
    public void removeProductTest(){
        //Step 1: Login
        login.login(UserData.getUsername("standard"),UserData.getPassword("standard"));

        //Step 2: Click Add Product
        inventory.clickAddToCart();

        //Step 3: Click Remove
        inventory.clickRemove();

        //Validar que la lista del nodo este vacia
        Assert.assertFalse(inventory.badgeCounterIsDisplayed());
    }

    @Test
    public void removeProductTest2(){
        //Step 1: Login
        login.login(UserData.getUsername("standard"),UserData.getPassword("standard"));

        //Step 2: Click Add Product
        inventory.clickAddToCart();

        //Step 2: Click Add Product
        inventory.clickAddToCart();

        //Step 3: Click Remove
        inventory.clickRemove();

        //Step 3: Click Remove
        inventory.clickRemove();

        //Validar que la lista del nodo este vacia
        Assert.assertFalse(inventory.badgeCounterIsDisplayed());
    }

    @Test
    public void removeProductTest3(){
        //Step 1: Login
        login.login(UserData.getUsername("standard"),UserData.getPassword("standard"));

        //Step 2: Click Add Product
        inventory.clickAddToCart();

        //Step 2: Click Add Product
        inventory.clickAddToCart();

        //Step 3: Click Remove
        inventory.clickRemove();

        //Step 3: Click Remove
        inventory.clickRemove();

        //Validar que la lista del nodo este vacia
        Assert.assertFalse(inventory.badgeCounterIsDisplayed());
    }
}
