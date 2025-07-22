package pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.UserData;

public class CheckoutTests extends BaseTest{

     @Test(groups = "e2e")
    public void checkoutNoData(){
         //Step 1: Login
         login.login(UserData.getUsername("standard"),UserData.getPassword("standard"));

         //Step 2: Agregar un producto al carrito
         inventory.clickAddToCart();

         //Step 3: Click en el carrito
         inventory.clickCartButton();

         //Step 4: Hacer el click en el boton checkout
         cart.clickCheckout();

         //Step 5 Hacer click en Continue
         checkoutStepOnePage.clickContinue();

         //Validate Error: Error: First Name is required
         Assert.assertEquals(checkoutStepOnePage.getFirstNameErrorText(),"Error: First Name is required");
     }

    @Test(groups = "e2e")
    public void E2ETest(){
        //Step 1: Login
        login.login(UserData.getUsername("standard"),UserData.getPassword("standard"));

        //Step 2: Agregar un producto al carrito
        inventory.clickAddToCart();

        //Step 3: Click en el carrito
        inventory.clickCartButton();

        //Step 4: Hacer el click en el boton checkout
        cart.clickCheckout();

        //Step 5: Hacer click en Continue
        checkoutStepOnePage.fillPersonalDetails();
        checkoutStepOnePage.clickContinue();

        //Step 6: Hacer click en Finish
        checkoutStepTwoPage.clickFinish();

        //Validate Error: Error: First Name is required
        Assert.assertTrue(checkoutComplete.verifyTextInScreen("Thank you for your order"));
        Assert.assertTrue(checkoutComplete.verifyTextInScreen("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));

    }
}
