package pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.ConfigReader;
import utils.DriverFactory;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class BaseTest {

    private WebDriver driver;

    //PageObjects

    LoginPage login;
    InventoryPage inventory;
    SideMenuPage sideMenu;
    CartPage cart;
    CheckoutStepOnePage checkoutStepOnePage;
    CheckoutStepTwoPage checkoutStepTwoPage;
    CheckoutComplete checkoutComplete;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver = DriverFactory.intitializDriver();
        login = new LoginPage(driver);
        inventory = new InventoryPage(driver);
        sideMenu = new SideMenuPage(driver);
        cart = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutComplete = new CheckoutComplete(driver);

        DriverFactory.launchUrl(ConfigReader.get("baseUrl"));
    }

    @AfterMethod(alwaysRun = true) // Este parametro es para que siempre se ejecute desde una test suite
    public void tearDown(){
        driver.quit();
    }
}
