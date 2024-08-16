package ASSESMENT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsers {
     
	public static WebDriver launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
	} else if (browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}else if (browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver();
	}else if (browser.equalsIgnoreCase("iphone 12 Pro on chrome")) {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Iphone 12 Pro");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludesSwitches", new String[] {"enable-automation"});
		options.setExperimentalOption("mobileEmulation",mobileEmulation);
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver(options);
	}else if (browser.equalsIgnoreCase("Iphone 12 Pro on edge")) {
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "Iphone 12 Pro");
		EdgeOptions options = new EdgeOptions();
		options.setCapability("excludeSwitches", Arrays.asList("enable-automation"));
		options.setCapability("mobileEmulation", mobileEmulation);
		WebDriverManager.edgedriver().setup();
		return new EdgeDriver(options);
		
		
		
	}
		return new EdgeDriver();
	}
}
