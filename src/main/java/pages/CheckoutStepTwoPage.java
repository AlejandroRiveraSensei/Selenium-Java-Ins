package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage{


    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    private final By finishBtn = By.id("finish");

    public void clickFinish(){
        click(finishBtn);
    }

}
