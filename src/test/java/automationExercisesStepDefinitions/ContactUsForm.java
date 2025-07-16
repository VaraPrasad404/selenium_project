package automationExercisesStepDefinitions;

import Pages.ContactUs;
import Pages.HomePAge;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class ContactUsForm {
	
	HomePAge hp = new HomePAge();
	
	ContactUs cu = new ContactUs();
	
	@When("Enter {string}, {string}, {string} and {string}")
	public void submit_contactusform(String name, String email, String subject, String message) {
		hp.enter_username(name);
		cu.enter_email(email);
		cu.enter_subject(subject);
		cu.enter_message(message);
	}
	
	@And("Upload file")
	public void upload_file() {
		
		String filepath = System.getProperty("user.dir")+ "/ExtentReport_ 20250413_190832/test-output/spark/Index.html";
		cu.uploadfile().sendKeys(filepath);
	}
	
	@When ("Click Submit button")
	public void submitfile() {
		cu.click_submitbtn();
	}
	@And ("Click OK button")
	public void clickokbtn(){

		cu.click_ok_btn();
	}
	@Then("Verify success message {string} is visible")
	public void verify_successmsg_visible(String msg) {
		
		Assert.assertTrue(hp.getElementByText(msg).isDisplayed());

		
		
	}
	@And ("Click {string} button and verify that landed to home page successfully")
	public void click_home_btn(String homebtn) {
		hp.getElementByText(homebtn).click();
	}

}
