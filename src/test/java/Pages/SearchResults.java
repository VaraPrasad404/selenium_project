package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResults {

	WebDriver driver;
	public SearchResults(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

		
	}
	
	@FindBy(xpath ="//*[contains(text(), 'Best seller')]")
	WebElement BestSeller;
	
	public void selectBestSellar() {
		
		BestSeller.click();
	}
	

}
