package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SetupCheckTest {

    @BeforeMethod
    public void voidSetUp(){

    }

    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();//Crear un webdriver

        driver.get("https://www.saucedemo.com/");

        System.out.println("Page title: " + driver.getTitle());

        driver.quit(); //Cerrar mi ventana
    }

    @AfterMethod
    public void tearDown(){

    }
}
