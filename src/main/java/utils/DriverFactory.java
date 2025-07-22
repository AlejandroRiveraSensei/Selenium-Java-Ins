package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    // ThreadLocal ensures each thread gets its own WebDriver instance
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThread.get();
    }


    public static WebDriver intitializDriver(){

        ChromeOptions options = new ChromeOptions();
        Map<String,Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        prefs.put("profile.password_manager_leak_detection",false);
        options.setExperimentalOption("prefs",prefs);
        // Correr chrome en background
        //options.addArguments("--headless=new");


        WebDriver driver = new ChromeDriver(options);
        driverThread.set(driver);
        //getDriver().manage().window().maximize();
        return getDriver();
    }

    public static void launchUrl(String url){
        getDriver().get(url);
    }
}
