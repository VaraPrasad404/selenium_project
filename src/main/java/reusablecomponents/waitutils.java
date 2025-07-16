package reusablecomponents;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitutils {
	
	
	public static void waitforeletobeclickable(WebDriver driver, WebElement ele) {
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(ele));
		
	}
	
public static void waitforeletobevisible(WebDriver driver, WebElement ele) {
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}

public static void acceptalert(WebDriver driver) {
	
	Alert alert = driver.switchTo().alert();
	alert.accept();
	
}

}
