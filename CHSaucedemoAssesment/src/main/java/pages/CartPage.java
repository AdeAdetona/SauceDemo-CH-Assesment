package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ASSESMENT.Constants;

public class CartPage {
	
	
WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@ id='contents_wrapper']/div/div[2]/a")
	WebElement CartButton;
	
	@FindBy(xpath="//button[@class='btn_secondary cart_button']")
	WebElement RemoveFromCart;
	
	@FindBy(xpath="//a[text()='CHECKOUT']")
	WebElement CHECKOUT;
	
	@FindBy(xpath="//a[text()='Continue Shopping']")
	WebElement CONTINUESHOPPING;
	
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
	
	
	
	public void clickCartButton() {
		CartButton.click();
  }
	public void ClickRemoveFromCart() {
		RemoveFromCart.click();
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
	public void ClickCHECKOUT() {
		CHECKOUT.click();
		
		
	}
	
	public void ClickCONTINUESHOPPING() {
		CONTINUESHOPPING.click();
	}
	

}
