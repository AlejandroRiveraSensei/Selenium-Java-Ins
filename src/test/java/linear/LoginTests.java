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

import java.util.HashMap;
import java.util.Map;

public class LoginTests {

    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setUp(){
       driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void loginBlocked(){

        //Llenar el campo de Username
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        //LlEnar el campo de password
        driver.findElement((By.id("password"))).sendKeys("secret_sauce");
        //HAcer click en boton de Login
        driver.findElement(By.id("login-button")).click();

        //driver.findElement(By.cssSelector(("h3[data-test = 'error']")));
        String errorMsj = driver.findElement((By.xpath("//*[@data-test = 'error']"))).getText();
        System.out.println("El mensaje de error es: " + errorMsj);

        Assert.assertEquals(errorMsj,"Epic sadface: Sorry, this user has been locked out.");

    }

    @Test
    public void loginSuccess(){

        //Llenar el campo de Username
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        //Llenar el campo de password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Hacer click en boton de Login
        driver.findElement(By.id("login-button")).click();
        //Validar el text de productos
        String productText = driver.findElement((By.className("title"))).getText();

        boolean isEqual = productText.contains("Products");//El metodd contains() es un metodo de Java que verifica 2 Strings
        Assert.assertTrue(isEqual);
    }

    @Test
    public void loginIvalidUser(){

        //Llenar el campo de Username
        driver.findElement(By.id("user-name")).sendKeys("incorrect_user");
        //LLenar el campo de password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Hacer click en el boton de login
        driver.findElement((By.name("login-button"))).click();

        WebElement lblError = driver.findElement(By.xpath("//*[@data-test = 'error']"));
        lblError.getText();

        Assert.assertEquals(lblError.getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginEmpytPassword(){
        //HAcer en el boton de login
        driver.findElement(By.xpath("//*[@class = 'submit-button btn_action']")).click();

        String error = driver.findElement(By.xpath("//*[@data-test= 'error']")).getText();

        Assert.assertFalse(error.contains("Password is not required"));
    }

    @Test
    public void logoutTest() throws InterruptedException {

        //Handle Password Manager
        ChromeOptions options = new ChromeOptions();
        Map<Object,Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        prefs.put("profile.password_manager_leak_detection",false);
        options.setExperimentalOption("prefs",prefs);

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");

        //Step 1: Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Step 2: Click en boton de Menu
        driver.findElement(By.id("react-burger-menu-btn")).click();

        //wait for menu anumation
        Thread.sleep(1000);

        //Step 3: Click en logout
        driver.findElement((By.id("logout_sidebar_link"))).click();

        //Validar URL after logout
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/";
        Assert.assertEquals(actualURL,expectedURL);

        //Validar UserNanme input after logout
        boolean isUserNameDisplayed = driver.findElement(By.id("user-name")).isDisplayed();
        Assert.assertTrue(isUserNameDisplayed);

    }

}
