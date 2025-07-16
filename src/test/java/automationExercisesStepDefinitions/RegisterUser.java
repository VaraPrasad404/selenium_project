package automationExercisesStepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import Pages.HomePAge;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterUser {
	
	HomePAge hp = new HomePAge();
	
	@Given("Launch the browser and access automation excercise site")
	public void launch_the_browser_and_access_automation_excercise_site() {
	    // Write code here that turns the phrase above into concrete actions
	}
	@Then("Verify that home page is visible successfully")
	public void verify_that_home_page_is_visible_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		hp.home_page_displayed();
		
	}
	@When("Click on {string} button")
	public void click_on_button(String string) {
		
		hp.getElementByText(string).click();
	    // Write code here that turns the phrase above into concrete actions
	}
	@Then("Verify {string} is visible")
	public void verify_is_visible(String string) {
		Assert.assertTrue(hp.getElementByText(string).isDisplayed());
	    // Write code here that turns the phrase above into concrete actions
	}
	@When("Enter {string} and {string}")
	public void enter_username_email(String username, String email) {
		hp.enter_username(username);
		hp.enter_email(email);
		
	}
	@Then("Verify that the {string} is visible")
	public void verify_that_is_visible(String string) {
	    // Write code here that turns the phrase above into concrete actions
		hp.getElementByText(string).isDisplayed();
	}
	
	@When("Fill details: {string}, {string}, {string}, {string}, {string}")
	public void fill_basic_details(String title, String name, String email, String password, String dob) {
	    // registrationPage.fillBasicDetails(title, name, email, password, dob);
		//hp.getElementByText(title).click();
		if(title.equalsIgnoreCase("Mrs.")) {
			hp.select_Mrs_gender();
		}else if(title.equalsIgnoreCase("Mr.")) {
			hp.select_Mr_gender();
		}
		hp.enter_password(password);
		String[] dobparts = dob.split("-");
		String day = dobparts[0];
		String month = dobparts[1];
		String year = dobparts[2];
		
		hp.enter_DOB(day, month, year);
		
	}
    @And ("Click {string} button")
    public void click_btn(String btn){
    	hp.getElementByText(btn).click();
    }

	
	@When("Fill details: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void fill_address_details(String firstName, String lastName, String company, String address, String address2,
	                                 String country, String state, String city, String zipcode, String mobileNumber) {
	    // registrationPage.fillAddressDetails(firstName, lastName, company, address, address2, country, state, city, zipcode, mobileNumber);
		hp.enter_user_details(firstName, lastName, company, address, address2, country, state, city, zipcode, mobileNumber);
		}
	@And("Select checkbox {string}")
	public void select_newsletter_checkbox(String string) {
	    // registrationPage.selectNewsletterCheckbox();
		hp.getElementByText(string).click();
	}
	
	@And("Click {string}")
	public void click_create_account_button(String string) {
	    // registrationPage.clickCreateAccountButton();
		hp.getElementByText(string).click();
	}
	
	@Then("Verify that 'Logged in as username' is visible")
	public void verify_logged_in_as_username_is_visible() {
	    WebElement ele = hp.verify_loggedin_username();
	    Assert.assertTrue(ele.isDisplayed());
	}

}
