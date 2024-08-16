package ASSESMENT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testrun {

	private static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * 
		 * Setup browser
		 * 
		 * instantiate the WebDriver
		 * 
		 * //tag[@attribute=('value')]
		 *
		 *Selenium Wait Methods
		 *
		 *Explicit wait -WebDriverWait wait = new WebDriverWait (driver,20);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(""//div[contains(text(), 'Products')")))
		 *Implicit wait - driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
		 *Fluent wait
		 *
		 *
		 */

		//WebDriverManager.edgedriver().setup();
		//WebDriver driver = new EdgeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//WebDriver driver = new FirefoxDriver();
		
		driver = ASSESMENT.Browsers.launchBrowser("Edge");
		
		driver.get("https://www.saucedemo.com/v1/index.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		
		WebDriverWait wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Products')]")));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)	;
		
		driver.quit();
		
	}

}
