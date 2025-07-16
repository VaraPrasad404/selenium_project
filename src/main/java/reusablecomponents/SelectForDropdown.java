package reusablecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectForDropdown {
	
	public static void select_byvisibletext(WebElement dropdownElement, String visibleText) {
		
		Select select = new Select(dropdownElement);
		select.selectByVisibleText(visibleText);
		
		
	}

}
