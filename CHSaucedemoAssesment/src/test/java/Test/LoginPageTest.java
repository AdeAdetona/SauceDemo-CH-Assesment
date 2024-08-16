package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import ASSESMENT.Constants;
import pages.Login_Page;

public class LoginPageTest {

	/**
	 * 
	 * Help==> install new software ==> Search testNG and restart eclipse
	 * 
	 * Another==> @BeforeClass @AfterClass @BeforeMethod @AfterMethod @Test @Ignore @parameters
	 * 
	 * Realigning ==>control+shift+F
	 * 
	 */
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
	public void Test_case_one() {
		System.out.println("Test case 1.1 ");

		// Validate standard User with valid user name can login in the sauce demo site

		Login_Page login = new Login_Page(driver);
		login.logIntoSauceDemo(Constants.STANDARDUSER, Constants.PASSWORD);

		// login.enterUsername();
		// login.enterPassword();
		// login.clickOnLoginButton();

		// driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		// driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		// driver.findElement(By.xpath("//input[@id='login-button']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Products')]")));
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;

	}

	@Test

	// Validate lock out User cannot login in the sauce demo site

	public void Test_case_two() {
		System.out.println("Test case 1.2");

		Login_Page login = new Login_Page(driver);
		login.logIntoSauceDemo(Constants.LOCKEDOUTUSER, Constants.PASSWORD);
	}

	@Test

	// Validate if problem User cannot login in the sauce demo site
	public void Test_case_three() {
		System.out.println("Test case 1.3");

		Login_Page login = new Login_Page(driver);
		login.logIntoSauceDemo(Constants.PROBLEMUSER, Constants.PASSWORD);
	}

	@Test

	// Validate if performance glitch User can login in the sauce demo site
	public void Test_case_four() {
		System.out.println("Test case 1.4");

		Login_Page login = new Login_Page(driver);
		login.logIntoSauceDemo(Constants.PGUSER, Constants.PASSWORD);
	}

	@Test

	// Validate if Stander User can login in the sauce demo site without password
	public void Test_case_five() {
		System.out.println("Test case 1.5");

		Login_Page login = new Login_Page(driver);
		login.logIntoSauceDemo(Constants.STANDARDUSER, null);
	}

	@Test

	// Validate if System allow user login into the sauce demo site with only
	// password
	public void Test_case_six() {
		System.out.println("Test case 1.6");

		Login_Page login = new Login_Page(driver);
		login.logIntoSauceDemo(null, Constants.PASSWORD);
	}

	@Test

	// Validate if System allow user login into the sauce demo site without username
	// and password input
	public void Test_case_seven() {
		System.out.println("Test case 1.7");

		Login_Page login = new Login_Page(driver);
		login.logIntoSauceDemo(null, null);
	}

	@Test

	// Validate if System allow user login into the sauce demo site with standard
	// username and incorrect password input
	public void Test_case_eight() {
		System.out.println("Test case 1.8");

		Login_Page login = new Login_Page(driver);
		login.logIntoSauceDemo(Constants.STANDARDUSER, Constants.INCORRECT_PASSWORD);
	}

	@Test

	// Validate if System allow user login into the sauce demo site with incorrect
	// username but correct password input
	public void Test_case_nine() {
		System.out.println("Test case 1.9");

		Login_Page login = new Login_Page(driver);
		login.logIntoSauceDemo(Constants.INCORRECTSTANDARD_USER, Constants.PASSWORD);
	}

	@Test

	// Validate if System allow user login into the sauce demo site with both
	// incorrect username and password input
	public void Test_case_ten() {
		System.out.println("Test case 1.10");

		Login_Page login = new Login_Page(driver);
		login.logIntoSauceDemo(Constants.INCORRECTSTANDARD_USER, Constants.INCORRECTSTANDARD_USER);
	}
}
