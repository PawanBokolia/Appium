package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DropDownHandling {

	public static void main(String args []) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("appium:deviceName","OnePlus CHP2661");
		capabilities.setCapability("appium:platformName ","Android");
		capabilities.setCapability("appium:automationName","uiautomator2");
		capabilities.setCapability("appium:appPackage","io.appium.android.apis");
		capabilities.setCapability("appium:appActivity","io.appium.android.apis.ApiDemos");
		
		URL url =URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url,capabilities);
		
		System.out.println("application is install");
		
		//click on view button 
		driver.findElements(By.id("android:id/text1")).get(11).click();
		
		//click on control button 
		driver.findElements(By.id("android:id/text1")).get(4).click();
		
		//click on light theme 
		driver.findElements(By.id("android:id/text1")).get(0).click();
		
		
		WebElement dropDown= driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]"));
		dropDown.click();
		
		Thread.sleep(2000);
		WebElement earthOption = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Earth\"]"));
		earthOption.click();
		
		Thread.sleep(2000);
		System.out.println("session is closed");
		
		driver.quit();
		
		
		
		
		
		
		
		
	}
}
