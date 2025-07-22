package linear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        Map<Object,Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        prefs.put("profile.password_manager_leak_detection",false);
        options.setExperimentalOption("prefs",prefs);

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void addProductTest(){

        //Step 1: Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Step 2:
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //Validar que el text del icono del carrito de compras sea '1'
        String actualCount = driver.findElement(By.className("shopping_cart_badge")).getText();
        String expectedCount = "1";

        Assert.assertEquals(actualCount,expectedCount);
    }

    @Test
    public void removeProduct(){
        //Step 1: Login
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Step 2: Click Add Product
        driver.findElement(By.xpath("//*[@class = 'btn btn_primary btn_small btn_inventory ']")).click();

        //Step 2: Click Remove
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        //Ejemplo find elements
        List<WebElement> prodList = driver.findElements((By.className("inventory_item_name")));
        System.out.println(prodList.size());
        String thirdProd = prodList.get(2).getText();
        System.out.println(thirdProd);

        //Validar que la lista del nodo este vacia
        boolean badgeVisible = driver.findElements((By.className("shopping_cart_badge"))).isEmpty();
        Assert.assertTrue(badgeVisible);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
