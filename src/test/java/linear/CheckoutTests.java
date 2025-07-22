package linear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class CheckoutTests {

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
    public void checkoutNoData(){
        //Step 1: Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Step 2: Agregar un producto al carrito
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //Step 3: Click en el carrito
        driver.findElement((By.className("shopping_cart_link"))).click();

        //Step 4: Hacer el click en el boton
        driver.findElement(By.id("checkout")).click();

        //Step 5 Hacer click en Continue
        driver.findElement(By.id("continue")).click();

        WebElement errorText = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-test = 'error']")));

        String errorStringName = errorText.getText();

        Assert.assertEquals(errorStringName,"Error: First Name is required");

    }

    @Test
    public void e2e(){
        //Step 1: Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Step 2: Click en add to cart
        driver.findElement(By.xpath("//*[@data-test = 'add-to-cart-sauce-labs-backpack']")).click();

        //Step 3: Click en carrito de compras
        driver.findElement(By.xpath("//*[@data-test = 'shopping-cart-link']")).click();

        //Step 4: Click en Checkout
        driver.findElement(By.id("checkout")).click();

        //Step 5: Llenar el formulario y hacer Click en continue
        driver.findElement(By.id("first-name")).sendKeys("Adrian");
        driver.findElement(By.id("last-name")).sendKeys("Flores");
        driver.findElement(By.id("postal-code")).sendKeys("90210");
        driver.findElement(By.id("continue")).click();

        //Step 6: Hacer click en
        driver.findElement(By.xpath("//*[contains(text(),'Finish')]")).click();

        //Validar el text en pantalla
        //Ejemplo Fluent wait
        //Configurando condiciones
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // La espera maxima
                .pollingEvery(Duration.ofSeconds(5)) //Intervalo entre cada revision
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complete-header")));

        Assert.assertEquals(element.getText(),"Thank you for your order!");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
