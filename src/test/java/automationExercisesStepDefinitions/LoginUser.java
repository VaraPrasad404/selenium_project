package automationExercisesStepDefinitions;

import Pages.HomePAge;
import io.cucumber.java.en.When;


public class LoginUser {
	
	 

	
	HomePAge hp = new HomePAge();
	
	
	@When("Enter correct {string} and {string}")
	public void enter_email_password(String email, String password) {
		
		hp.enter_loginemail_password(email, password);
	}

}
