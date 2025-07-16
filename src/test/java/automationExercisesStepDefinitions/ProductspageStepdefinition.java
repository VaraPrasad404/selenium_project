package automationExercisesStepDefinitions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebElement;

import Pages.Productspage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.ExcelWriter;
import utils.Product;

public class ProductspageStepdefinition {
	
	Productspage pdt = new Productspage();
    List<Product> productList = new ArrayList<>();

	

	
	@And ("Get the products count")
	public void products_count() {
		
		pdt.getproductscount();
		
	}
	
	@Then ("Print each product name and cost")
	public void productnames_cost() {
		List<WebElement> nameElements = pdt.getproductname();
		List<WebElement> priceElements = pdt.getproductcost();
		
		for(int i=0;i<nameElements.size();i++) {
			
			String name = nameElements.get(i).getText().trim();
			String costText = priceElements.get(i).getText().replaceAll("[^0-9]", "");
			int cost = Integer.parseInt(costText);
			
			productList.add(new Product(name, cost));
			
		}
		
		
	}
	

	@And ("Sort the products list as per cost in ascending order")
	public void sort_products_ascorder() {
		
        productList.sort(Comparator.comparing(Product::getPrice));
        
        System.out.println("Sorted by price:");
        for (Product p : productList) {
            System.out.println(p.getName() + " - Rs. " + p.getPrice());
        }
        
        String filepath = "target/SortedProducts.xlsx";
        ExcelWriter.writeProductsToExcel(productList, filepath);

	}


}
