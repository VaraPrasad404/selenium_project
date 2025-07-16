package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productspage extends BasePage {
	
	public Productspage() {
		
		super();
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(xpath="//div[@class='single-products']")
	private List<WebElement> allproducts;
	
	@FindBy(xpath="//div[@class='single-products']/div/p")
	private List<WebElement> productnames;
	
	@FindBy(xpath="//div[@class='single-products']/div/h2")
	private List<WebElement> productcost;

	
	public int getproductscount() {
		
		int total_products = allproducts.size();		
		
		return total_products;
	}
	
	public List<WebElement> getproductname(){
		
		return productnames;
	}
	
	public List<WebElement> getproductcost(){
		return productcost;
	}
}



