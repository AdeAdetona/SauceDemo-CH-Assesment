package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	
	/***
	 * 
	 * POM - object oriented programming
	 * 
	 * Makes code easy to maintain, makes it reusable, make it scalable
	 * its save locators almost like variables so that you can reuse
	 *
	 * 
	 * 
	 */
	WebDriver driver;
	
	public Login_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement loginbutton;
	
	public void enterUsername(String user) {
		username.sendKeys(user);
	
	}
	public void enterPassword(String Pass) {
		password.sendKeys(Pass);
		
	}
	public void clickOnLoginButton() {
		loginbutton.click();
		
	}
	
	public void logIntoSauceDemo(String user, String Pass) {
		
		/***
		 * 
		 * This function allow the user to enter username and password
		 * then click login button
		 * 
		 */
		
		username.sendKeys(user);
		password.sendKeys(Pass);
		loginbutton.click();
	
		
	}
	
	

}
