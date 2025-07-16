package practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import utils.OpenBrowser;
import org.openqa.selenium.TakesScreenshot;

public class Practisemama {

    public static void main(String[] args) {


	WebDriver driver = new ChromeDriver();
	WebDriverManager.chromedriver().setup();
	JavascriptExecutor js = (JavascriptExecutor) driver;

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
	driver.manage().window().maximize();
	//driver.navigate().refresh();
	
	//driver.findElement(By.tagName("h1"));
	
	WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
	
	Select sl = new Select(dropdown);
	
	List<WebElement> dropdown_options = sl.getOptions();
	
	for(WebElement option: dropdown_options ) {
		
		String text = option.getText();
		
		if(text.equals("Option3")) {
			
			option.click();
			break;
		}
	}
	
	String current_windowhandle = driver.getWindowHandle();
	
	driver.findElement(By.xpath("//a[@id='opentab']")).click();
	
	Set<String> windowhandles = driver.getWindowHandles();
	
	for(String handle: windowhandles) {
		
		if(!current_windowhandle.equals(handle)) {
			
			driver.switchTo().window(handle);
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
			
			By element = By.xpath("(//a[contains(text(), 'Home')])[1]");
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
			
			driver.getTitle();
			
			break;
		}
	}
	
	driver.switchTo().window(current_windowhandle);
	
/*	Actions an = new Actions(driver);
	
	WebElement ele = driver.findElement(By.id("mousehover"));
	
	an.moveToElement(ele).build().perform();
	
	WebElement clickbtn = driver.findElement(By.xpath("//a[contains(text(), 'Reload')]"));
		
	
	js.executeAsyncScript("arguments[0].click();", clickbtn);*/
	
	driver.findElement(By.id("autocomplete")).sendKeys("india");
	
	List<WebElement> list_ofcountries = driver.findElements(By.cssSelector(".ui-menu-item"));
	
	for(WebElement country: list_ofcountries) {
		
		String country_name = country.getText();
		if(country_name.equalsIgnoreCase("India")) {
			
			country.click();
		}
	}
	
	driver.findElement(By.id("name")).sendKeys("Dragon");
	driver.findElement(By.id("name")).sendKeys("returns");

	driver.findElement(By.id("alertbtn")).click();
	driver.switchTo().alert().accept();
	
	driver.findElement(By.id("confirmbtn")).click();
	driver.switchTo().alert().dismiss();
	
	WebElement frame = driver.findElement(By.id("courses-iframe"));
	driver.switchTo().frame(frame);
	WebElement course = driver.findElement(By.xpath("//a[contains(text(), 'JavaScript')]"));
	
	js.executeScript("arguments[0].scrollIntoView(true); arguments[0].click();", course);
	
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	File destination = new File("target/screenshot.png");
	try {
		FileUtils.copyFile(screenshot, destination);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2))
			.ignoring(NoSuchElementException.class);
	//driver.quit();
	
	WebElement ele = wait.until(d -> d.findElement(By.id("sampleid")));
	
	

    }	
	
	
	
}

	


