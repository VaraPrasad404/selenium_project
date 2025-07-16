package reusablecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class hoverover {
	
	public static void hoverovertoele(WebDriver driver, WebElement ele) {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).build().perform();
		
	}

}
