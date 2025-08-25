package practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practise2 {

	public static void main(String args[]) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		String header = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr/th[1]")).getText();
		
		List<WebElement> values = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td[1]"));
		
		for(WebElement value: values) {
			
			System.out.println(value.getText());
		}
		
	}
	

	
}
