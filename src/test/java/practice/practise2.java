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
		
		List<String> tableData = new ArrayList<>();
		
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.w3schools.com/html/html_tables.asp");
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//table[@id='customers']/tbody/tr[1]/th")));
	
	/*List<WebElement> headers = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[1]/th"));
	
	for(WebElement header:headers) {
		
		System.out.println(header.getText());
	}*/
	
	List<WebElement> data = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
	
	for(int i=1; i<data.size();i++) {
		
		List<WebElement> columns = data.get(i).findElements(By.xpath("td[position()>1]"));
		
		for(WebElement col : columns) {
			
			tableData.add(col.getText());
		}
		
	}
	
	System.out.println(tableData);
	
	}
	

	
}
