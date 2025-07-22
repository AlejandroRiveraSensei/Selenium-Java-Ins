package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideMenuPage extends BasePage{

    public SideMenuPage(WebDriver driver) {
        super(driver);
    }

    private final By burgerMenu = By.id("react-burger-menu-btn");
    private final By logoutBtn = By.id("logout_sidebar_link");

    public void logout(){
        click(burgerMenu);
        click(logoutBtn);
    }
}
