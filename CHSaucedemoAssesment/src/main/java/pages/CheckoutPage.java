package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ASSESMENT.Constants;

public class CheckoutPage {
	
WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='first-name']")
	WebElement Fname;
	
	
	@FindBy(xpath="//input[@id='last-name']")
	WebElement Lname;
	
	@FindBy(xpath="//input[@id='postal-code']")
	WebElement PostCode;
	
	@FindBy(xpath="//a[text()='CANCEL']")
	WebElement CANCEL;
	
	@FindBy(xpath="//input[@value='CONTINUE']")
	WebElement CONTINUE;
	
	@FindBy(xpath="//a[text()='CHECKOUT']")
	WebElement CHECKOUT;
	
	@FindBy(xpath="//div[@ id='contents_wrapper']/div/div[2]/a")
	WebElement CartButton;
	
	@FindBy(xpath="//a[text()='FINISH']")
	WebElement FINISH;
	
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
	
	public void enterFirstname(String user) {
		Fname.sendKeys(user);
	}
	public void enterLastname(String user) {
		Lname.sendKeys(user);
	}
	public void enterPostCode(String user) {
		PostCode.sendKeys(user);
	}
	public void ClickCANCEL(String user) {
		CANCEL.click();
	}
	
	public void ClickCONTINUE(String user) {
	CONTINUE.click();
	}
	
     public void Checkout(String Firstname, String Lastname, String Postcode) {
		
		/***
		 * 
		 * This function allow the user to enter first name, Last name, and Post code
		 * then click Continue button
		 * 
		 */
		
		Fname.sendKeys(Firstname);
		Lname.sendKeys(Lastname);
		PostCode.sendKeys(Postcode);
		
		CONTINUE.click();
		
     }
		
     public void CancelCheckout(String Firstname, String Lastname, String Postcode) {
 		
 		/***
 		 * 
 		 * This function allow the user to enter first name, Last name, and Post code
 		 * then click Cancel button
 		 * 
 		 */
 		
 		Fname.sendKeys(Firstname);
 		Lname.sendKeys(Lastname);
 		PostCode.sendKeys(Postcode);
 		
 		CANCEL.click();
 		
      }
     public void addToCartButtons() throws Exception{
 		
 		
 		/**
 		 * 
 		 * Add all items to basket and confirm count
 		 * 
 		 */
 	
 	    //driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
 		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
 		//driver.findElement(By.xpath("//input[@id='login-button']")).click();
    	username.sendKeys(Constants.STANDARDUSER);
   		password.sendKeys(Constants.PASSWORD);
   		loginbutton.click();
 		
 		List<WebElement> addToCartButtons = driver
 			.findElements(By
 					.xpath("//div[@id='contents_wrapper']/div[2]/div/div/div/div/div[3]/button"));
 	
 	int cartCount = addToCartButtons.size();
 	for (int i = 0; i<cartCount; i++) {
 		Thread.sleep(1000);
 		addToCartButtons.get(i).click();
 	}
 	}
 	
     public void clickCartButton() {
 		CartButton.click();
		
		
	}
     public void ClickCHECKOUT() {
 		CHECKOUT.click();
 		
 		
 	}
     
     public void ClickFINISH() {
    		FINISH.click();
     }
 		
	

}
