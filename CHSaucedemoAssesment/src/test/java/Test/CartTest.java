package Test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import ASSESMENT.Constants;
import pages.CartPage;
import pages.InventoryPage;

public class CartTest {
	
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
	
	@Test
	
	
	 public void Test_case_1() throws Exception {
			System.out.println("Test Case 3.1");
		  	CartPage cartPage = new CartPage(driver);
		  	cartPage.addToCartButtons();
		  	cartPage.clickCartButton();
	}
	
	@Test
	
	
	 public void Test_case_2() throws Exception {
			System.out.println("Test Case 3.2");
		  	CartPage cartPage = new CartPage(driver);
		  	cartPage.addToCartButtons();
		  	cartPage.clickCartButton();
		  	cartPage.ClickRemoveFromCart();
	}

	
	@Test
	
	
	 public void Test_case_3() throws Exception {
			System.out.println("Test Case 3.3");
		  	CartPage cartPage = new CartPage(driver);
		  	cartPage.addToCartButtons();
		  	cartPage.clickCartButton();
		  	cartPage.ClickCONTINUESHOPPING();
	}
	
	@Test
	
	
	 public void Test_case_4() throws Exception {
			System.out.println("Test Case 3.4");
		  	CartPage cartPage = new CartPage(driver);
		  	cartPage.addToCartButtons();
		  	cartPage.clickCartButton();
		  	cartPage.ClickCHECKOUT();
		  	
	}
}
