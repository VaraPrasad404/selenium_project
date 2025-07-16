package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import utils.OpenBrowser;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = OpenBrowser.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public void movetoElement(WebElement element) {
    	Actions ac = new Actions(driver);
    	ac.moveToElement(element).build().perform();
    }
}