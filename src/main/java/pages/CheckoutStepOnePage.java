package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage{


    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    private final By continueBtn = By.id("continue");
    private final By fnError = By.xpath("//*[@data-test = 'error']");
    private final By nameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipCodeInput = By.id("postal-code");


    public void clickContinue(){
        click(continueBtn);
    }

    public String getFirstNameErrorText(){
        return getText(fnError);
    }

    public void fillPersonalDetails(){
        type(nameInput,"TestName");
        type(lastNameInput,"TestLN");
        type(zipCodeInput,"90210");
    }

}
