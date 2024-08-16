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
import junit.framework.Assert;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutTest {
	
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
		
		//driver.quit();
	}
	@Test
	
	//Verify that user can use the cancel checkout button
	public void Test_case_1() throws Exception{
		System.out.println("Test case 4.1");
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.addToCartButtons();
		checkoutPage.clickCartButton();
		checkoutPage.ClickCHECKOUT();
		checkoutPage.CancelCheckout("Ade", "Adetona"," TN10 3BP");
	
		
	}
	@Test
	//Verify that user can use the checkout button
	public void Test_case_2() throws Exception {
		System.out.println("Test case 4.2*");
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.addToCartButtons();
		checkoutPage.clickCartButton();
		checkoutPage.ClickCHECKOUT();
		
		//Verify that user can input firstname, lastname and postcode in the shipping page
		checkoutPage.Checkout("Ade", "Adetona"," TN10 3BP");
		
		//Verify that user can click the finish button to complete order
		checkoutPage.ClickFINISH();
		
		//Verify that the thankyou page is displayed
		String actualOrderpageURL = driver.getCurrentUrl();
    	String expectedOrderpageURL = "https://www.saucedemo.com/v1/checkout-complete.html";
    	Assert.assertEquals(actualOrderpageURL, expectedOrderpageURL);
    	
	
		
	}

}
