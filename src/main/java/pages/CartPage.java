package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By checkoutBtn = By.id("checkout");

    public void clickCheckout(){
        click(checkoutBtn);
    }
}
