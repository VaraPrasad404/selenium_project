package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import reusablecomponents.waitutils;


public class ContactUs extends BasePage{
	
	public ContactUs() {
		
		super();
		PageFactory.initElements( driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Email']")
	private WebElement contactus_email;
	
	@FindBy(xpath="//input[@placeholder='Subject']")
	private WebElement contactus_subject;
	
	@FindBy(xpath="//textarea[@data-qa='message']")
	private WebElement contactus_message_textbox;
	
	@FindBy(xpath="//input[@name='upload_file']")
	private WebElement contactus_upload_file;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement contactus_submitbtn;
	
	
	
	public void enter_email(String emailid) {
		waitutils.waitforeletobevisible(driver, contactus_email);
		contactus_email.sendKeys(emailid);
	}
	
	public void enter_subject(String subject) {
		contactus_subject.sendKeys(subject);
	}
	

	public void enter_message(String message) {
		contactus_message_textbox.sendKeys(message);
	}
	
	public WebElement uploadfile() {
		return contactus_upload_file;
	}
	
	public void click_submitbtn() {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contactus_submitbtn);
		waitutils.waitforeletobevisible(driver,contactus_submitbtn);
		contactus_submitbtn.click();

	}
	
	public void click_ok_btn() {
		waitutils.acceptalert(driver);
		WebElement sel = driver.findElement(By.xpath(""));
		
	}
	
}
