package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private final By userNameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMsg = By.xpath("//*[@data-test = 'error']");

    public void login(String username, String password){
        type(userNameInput, username);
        type(passwordInput, password);
        click(loginBtn);
        new InventoryPage(driver);
    }

    public String getErrorMessage(){
        return getText(errorMsg);
    }

    public String getCurrentURL(){
        return getCurrentUrl();
    }
}
