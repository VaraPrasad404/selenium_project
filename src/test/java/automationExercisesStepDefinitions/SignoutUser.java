package automationExercisesStepDefinitions;

import org.junit.Assert;

import Pages.HomePAge;
import io.cucumber.java.en.Then;

public class SignoutUser {
	
	HomePAge hp = new HomePAge();
	
	@Then("Verify that user is navigated to login page")
	public void display_loginpage() {
		
		boolean loginpage_availability = hp.display_loginpage().isDisplayed();
		Assert.assertTrue(loginpage_availability);
		
	}

}
