package pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.sql.Time;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReader.get("timeout"))));
    }

    //Explicit waits
    protected WebElement waitForElementVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForElementClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //Common Actions
    protected void click(By locator){
        try{
            waitForElementClickable(locator).click();
        }catch (ElementClickInterceptedException e){
            throw new RuntimeException("Unable to click on the element: " + locator, e);
        }
    }

    protected void type(By locator, String text){
        try {
            WebElement element = waitForElementVisible(locator);
            element.clear();
            element.sendKeys(text);
        }catch(InvalidElementStateException e){
            throw new RuntimeException("Unable to type into the element: " + locator, e);
        }

    }

    protected String getText(By locator){
        return waitForElementVisible(locator).getText();
    }

    protected String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    protected boolean isElementDisplayed(By locator){
        try {
            return waitForElementVisible(locator).isDisplayed();
        } catch (TimeoutException e){
            return false;
        }
    }
}
