package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.security.DrbgParameters.Capability;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BrowserAutomation {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appium:deviceName","OnePlus CHP2661");
		capabilities.setCapability("appium:platformName ","Android");
		capabilities.setCapability("appium:automationName","uiautomator2");
	
		capabilities.setCapability("appium:browserName" ,"Chrome");				//important 
		capabilities.setCapability("appium:platformversion", "15");				//important 
		
	
		//Chrome Driver
		capabilities.setCapability("appium:chromedriverExecutable","D:\\workspace\\Java Project 2024\\Appium\\Driver\\chromedriver-win64\\chromedriver.exe");

//		capabilities.setCapability("appium:appPackage","io.appium.android.apis");
//		capabilities.setCapability("appium:appActivity","io.appium.android.apis.ApiDemos");


		URL url =URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url,capabilities);

		
		System.out.println("application is started");
		
		
		
		
		driver.get("https://www.google.com");
		Thread.sleep(3000);
	;
		WebElement searchBox =  driver.findElement(By.name("q"));
		
		searchBox.sendKeys("Taj Mahaj");
		searchBox.sendKeys(Keys.RETURN);
	
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
		
		
	}

}
