package testNG;

import java.util.List;

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
import pages.E2Epage;

public class e2e_User5 {

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
		if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println("Test case : " + result.getName() + "Failed ");
			Shutterbug.shootPage(driver).withName(result.getName()).save();

		}

		driver.quit();
	}

	@Test

	// Scenario: Test the end to end journey with incorrect user name and correct
	// password
	public void Test_S5() throws Exception {
		System.out.println("Test case 5.5");
		E2Epage e2ePage = new E2Epage(driver);
		// e2ePage.addToCartButtons();

		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(Constants.INCORRECTSTANDARD_USER);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Constants.PASSWORD);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		List<WebElement> addToCartButtons = driver
				.findElements(By.xpath("//div[@id='contents_wrapper']/div[2]/div/div/div/div/div[3]/button"));

		int cartCount = addToCartButtons.size();
		for (int i = 0; i < cartCount; i++) {
			Thread.sleep(1000);
			addToCartButtons.get(i).click();
			
			//WebElement basketCount = driver.findElement(By.xpath("//div[@id ='shopping_cart_container']/a"));
	  		//String count = basketCount.getText();
	  		//Integer basketNum = Integer.valueOf(count);
	  		
	   		//boolean status = basketCount == basketNum ;
	  		
	  		//System.out.println(status);
	  		//Assert.assertTrue(status);
		  	//String count = basketCount.getText().trim();

		 // Convert the text to an integer
		    //Integer basketNum = Integer.valueOf(count);

		 // Here, you should compare basketNum with the expected number, not with basketCount
		    //Integer expectedBasketNum = 6;  

		 // Check if the actual basket count matches the expected value
		    //boolean status = basketNum.equals(expectedBasketNum);

		 // Output the result
		   //System.out.println(status);

		 // Assert that the basket count is as expected
		  // Assert.assertTrue(status);
		}

		e2ePage.clickCartButton();
		e2ePage.ClickCHECKOUT();
		e2ePage.Checkout("Ade", "Adetona", " TN10 3BP");
		e2ePage.ClickFINISH();
		String actualOrderpageURL = driver.getCurrentUrl();
		String expectedOrderpageURL = "https://www.saucedemo.com/v1/checkout-complete.html";
		Assert.assertEquals(actualOrderpageURL, expectedOrderpageURL);

	}

}
