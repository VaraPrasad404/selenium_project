package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import reusablecomponents.SelectForDropdown;
import reusablecomponents.waitutils;

public class HomePAge extends BasePage {

	public HomePAge() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	WebElement signupbuttton;
	
	@FindBy(xpath = "//div[@id='slider-carousel']")
	WebElement homepageslider;
	
	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement username;
	
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement singupemail;
	
	@FindBy(id = "name")
	WebElement name;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "days")
	WebElement day_calendar_dropdown;
	
	@FindBy(id = "months")
	WebElement month_calendar_dropdown;
	
	@FindBy(id = "years")
	WebElement year_calendar_dropdown;
	
	@FindBy(id = "first_name")
	WebElement firstname;
	
	@FindBy(id = "last_name")
	WebElement lastname;
	
	@FindBy(id = "company")
	WebElement company;
	
	@FindBy(id = "address1")
	WebElement address;
	
	@FindBy(id = "address2")
	WebElement address2;
	
	@FindBy(id = "country")
	WebElement country_dropdown;
	
	@FindBy(id = "state")
	WebElement state;
	
	@FindBy(id = "city")
	WebElement city;
	
	@FindBy(id = "zipcode")
	WebElement zipcode;
	
	@FindBy(id = "mobile_number")
	WebElement mobile_number;
	
	@FindBy(id = "uniform-id_gender2")
	WebElement Mrs_gender;
	
	@FindBy(id = "uniform-id_gender1")
	WebElement Mr_gender;
	
	@FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    private WebElement loggedInAsLabel;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	private WebElement login_email;
	
	@FindBy(xpath="//input[@data-qa='login-password']")
	private WebElement login_password;
	
	@FindBy(xpath="//a[contains(text(),'Logged in as')]")
	private WebElement get_username;
	
	@FindBy(xpath="//*[text()='Login to your account']")
	private WebElement login_page;
	
	
	
	
	public WebElement getElementByText(String buttonText) {
		
	    String exactXpath = "//*[normalize-space(text()) = '" + buttonText + "']";
	    
	        WebElement ele = driver.findElement(By.xpath(exactXpath));
	        
	        waitutils.waitforeletobevisible(driver, ele);
	        
	        ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", ele
	            );
	        movetoElement(ele);
			return ele;     
	  
	}
	
	public WebElement selecttitleradiobtn(String title) {
		
		return driver.findElement(By.xpath("//input[@value='" +title+ "']"));
	}
	
	public String getLoggedInAsText() {
        return loggedInAsLabel.getText().trim();  // e.g., "Logged in as love"
    }
	
	public void home_page_displayed() {
		homepageslider.isDisplayed();
	}
	
	public void enter_username(String name) {
		username.sendKeys(name);
	}
	
	public void enter_email(String emailid) {
		singupemail.sendKeys(emailid);
	}
	
	
	public void enter_DOB(String day, String month, String year) {
		
		
		SelectForDropdown.select_byvisibletext(day_calendar_dropdown,day);
		SelectForDropdown.select_byvisibletext(month_calendar_dropdown, month);
		SelectForDropdown.select_byvisibletext(year_calendar_dropdown, year);
		
	}
	
	public void enter_user_details(String fname, String lname, String cmpany, String address1, String addressline2, String country,String phno, String city_name, String st, String zipcde) {
		
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(cmpany);
		address.sendKeys(address1);
		address2.sendKeys(addressline2);
		SelectForDropdown.select_byvisibletext(country_dropdown, country);
		state.sendKeys(st);
		city.sendKeys(city_name);
		zipcode.sendKeys(zipcde);
		mobile_number.sendKeys(phno);
		
	}
	
	public WebElement verify_loggedin_username() {
		String username1 = get_username.getText();
	    return driver.findElement(By.xpath("//a[contains(normalize-space(),'" + username1 + "')]"));
	}

	public void select_Mr_gender() {
		Mr_gender.click();
	}
	
	public void select_Mrs_gender() {
		Mrs_gender.click();
	}
	
	public void enter_password(String passwd) {
		password.sendKeys(passwd);
	}
	
	public void enter_loginemail_password(String email, String password) {
		login_email.sendKeys(email);
		login_password.sendKeys(password);
	}
	
	public WebElement display_loginpage() {
		return login_page;
		}
}
