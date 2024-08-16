package testNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class e2e_User3 {

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

	// Scenario: Test the end to end journey with problem user name and correct
	// password

	public void TS3() throws Exception {
		System.out.println("Test case 5.3");
		E2Epage e2ePage = new E2Epage(driver);
		// e2ePage.addToCartButtons();

		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(Constants.PROBLEMUSER);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Constants.PASSWORD);
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		List<WebElement> addToCartButtons = driver
				.findElements(By.xpath("//div[@id='contents_wrapper']/div[2]/div/div/div/div/div[3]/button"));

		int cartCount = addToCartButtons.size();
		for (int i = 0; i < cartCount; i++) {
			Thread.sleep(1000);
			addToCartButtons.get(i).click();
			
			
			
			
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
