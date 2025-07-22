package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutComplete extends BasePage{

    public CheckoutComplete(WebDriver driver) {
        super(driver);
    }

    public boolean verifyTextInScreen(String stringToVerify){
        return isElementDisplayed(By.xpath("//*[contains(text(),'" + stringToVerify + "')]"));
    }
}
