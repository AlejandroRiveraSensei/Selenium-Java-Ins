package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    private final By title = By.className("title");
    private final By addToCarBtn = By.id("add-to-cart-sauce-labs-backpack");
    private final By badgeCounter = By.className("shopping_cart_badge");
    private final By removeButton = By.id("remove-sauce-labs-backpack");
    private final By cartButton = By.className("shopping_cart_link");

    public String getTitleText(){
        return getText(title);
    }

    public void clickAddToCart(){
        click(addToCarBtn);
    }

    public String getTextBadgeCounter(){
        return getText(badgeCounter);
    }

    public void clickRemove(){
        click(removeButton);
    }

    public boolean  badgeCounterIsDisplayed(){
        return isElementDisplayed(badgeCounter);
    }

    public void clickCartButton(){
        click(cartButton);
    }
}
