package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ASSESMENT.Constants;

public class InventoryPage {

	
	
WebDriver driver;
	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id=\'item_4_title_link\']")
	WebElement SL_Backpack;
	
	@FindBy(xpath="//a[@id=\'item_0_title_link\']")
	WebElement SL_BikeLight;
	
	
	@FindBy(xpath="//a[@id=\'item_1_title_link\']")
	WebElement SL_BoltTshirt;
	
	@FindBy(xpath="//a[@id=\'item_5_title_link\']")
	WebElement SL_FleeceJacket;
	
	
	@FindBy(xpath="//a[@id=\'item_2_title_link\']")
	WebElement SL_Onesie;
	
	@FindBy(xpath="//a[@id=\'item_3_title_link\']")
	WebElement SL_TTT;
	
	@FindBy(xpath="//button[@class='btn_primary btn_inventory']")
	WebElement ADDTOCART;
	
	@FindBy(xpath="//div[@id='contents_wrapper']/div[2]/div/div/div/div/div[3]/button]")
	WebElement ADDALLTOCART;
	
	@FindBy(xpath="//div[@ id='contents_wrapper']/div/div[2]/a")
	WebElement CartButton;
	
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
	
	
	
	
	public void clickOnSauceLabBackPack() {
		SL_Backpack.click();
	}
	public void clickOnSauceLabBikeLight() {
			SL_BikeLight.click();
	}
	public void clickOnSauceLabBoltTshirt() {
		SL_BoltTshirt.click();
	}
	public void clickOnSauceLabFleecejacket() {
		SL_FleeceJacket.click();
	}
	public void clickOnSauceLabOnesie() {
		SL_Onesie.click();
	}
	public void clickOnSauceLabTTT() {
		SL_TTT.click();
	}
	public void clickADDTOCART() {
		ADDTOCART.click();
		
		
	}
	public void clickADDITEMTOCART() {
		ADDALLTOCART.click();
		
		
	}
	public void ADDSLbackToCart() {
		
		//driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		//driver.findElement(By.xpath("//input[@id='login-button']")).click();
		username.sendKeys(Constants.STANDARDUSER);
		password.sendKeys(Constants.PASSWORD);
		loginbutton.click();
		SL_Backpack.click();
		ADDTOCART.click();
		
	}
	
      public void ADDSLBIKELIGHT() {
		
		//driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		//driver.findElement(By.xpath("//input[@id='login-button']")).click();
    	username.sendKeys(Constants.STANDARDUSER);
  		password.sendKeys(Constants.PASSWORD);
  		loginbutton.click();
		SL_BikeLight.click();
		ADDTOCART.click();
}
      
      public void ADDSLTTT() {
  		
  		//driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
  		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
  		//driver.findElement(By.xpath("//input[@id='login-button']")).click();
    	username.sendKeys(Constants.STANDARDUSER);
  		password.sendKeys(Constants.PASSWORD);
  		loginbutton.click();
  		SL_TTT.click();
  		ADDTOCART.click();
  		
      }
      
      public void ADDITEMTOCART() {
        //driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		//driver.findElement(By.xpath("//input[@id='login-button']")).click();
    	username.sendKeys(Constants.STANDARDUSER);
  		password.sendKeys(Constants.PASSWORD);
  		loginbutton.click();
		ADDALLTOCART.click();
		
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
		
		
      
}
