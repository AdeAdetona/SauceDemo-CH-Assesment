package Test;

import java.util.List;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import ASSESMENT.Constants;
import pages.InventoryPage;
import pages.Login_Page;

public class InventoryPageTest {
	
private static final WebElement SL_Backpack = null;
WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This runs at the class level");
		
		
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("This runs after the entire class");
	}
	
		
	
	@BeforeMethod
	public void setup() {
				
        driver = ASSESMENT.Browsers.launchBrowser("edge");
		
		driver.get(Constants.URL);
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()){
			System.out.println("Test case : "+result.getName()+ "Failed ");
			Shutterbug.shootPage(driver).withName(result.getName()).save();
			
		}
		
		driver.quit();
	}
	
	@Ignore
	public void Test_case() {
		System.out.println("Test case 1");
		
		Login_Page login = new Login_Page(driver);
		login.logIntoSauceDemo(Constants.STANDARDUSER, Constants.PASSWORD);
		
	}

	@Test
	 
	//Verify that User can Add item to cart
   public void Test_case_2() {
    	System.out.println("Test Case 2.1");
    	InventoryPage inventoryPage = new InventoryPage(driver);
		inventoryPage.ADDSLbackToCart();
    }
   
	@Test
	 //Verify that User can Add item to cart
  public void Test_case_3() {
   	System.out.println("Test Case 2.2");
   	InventoryPage inventoryPage = new InventoryPage(driver);
   	    	inventoryPage.ADDSLBIKELIGHT();
	}	
    
	@Test
	 //Verify that User can Add item to cart
   public void Test_case_4() {
  	System.out.println("Test Case 2.3");
  	InventoryPage inventoryPage = new InventoryPage(driver);
  	    	inventoryPage.ADDSLTTT();
	}	
   // Assert.assertEquals(cartBadge.getText(), "1");
	
	
	@Test
	
	//Verify that User can Add all item to cart
	 public void Test_case_5() throws Exception {
		System.out.println("Test Case 2.4");
	  	InventoryPage inventoryPage = new InventoryPage(driver);
	  	inventoryPage.addToCartButtons();
	  	
	  	WebElement basketCount = driver.findElement(By.xpath("//div[@id ='shopping_cart_container']/a"));
  		//String count = basketCount.getText();
  		//Integer basketNum = Integer.valueOf(count);
  		
   		//boolean status = basketCount == basketNum ;
  		
  		//System.out.println(status);
  		//Assert.assertTrue(status);
	  	String count = basketCount.getText().trim();

	 // Convert the text to an integer
	    Integer basketNum = Integer.valueOf(count);

	 // Here, you should compare basketNum with the expected number, not with basketCount
	    Integer expectedBasketNum = 6;  

	 // Check if the actual basket count matches the expected value
	    boolean status = basketNum.equals(expectedBasketNum);

	 // Output the result
	   System.out.println(status);

	 // Assert that the basket count is as expected
	   Assert.assertTrue(status);
	}
	
	
	}


