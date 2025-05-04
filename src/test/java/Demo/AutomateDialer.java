package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateDialer {

	public static void main(String[] args) throws MalformedURLException {
DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("appium:deviceName","OnePlus CHP2661");
		capabilities.setCapability("appium:platformName ","Android");
		capabilities.setCapability("appium:automationName","uiautomator2");
		capabilities.setCapability("appium:appPackage","com.google.android.dialer");
		capabilities.setCapability("appium:appActivity","com.google.android.dialer.extensions.GoogleDialtactsActivity");
		
		URL url =URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url,capabilities);
		
		System.out.println("Apllication Started");
		
		
		
		//09810012345
		
		//click on dial pad
		driver.findElement(By.id("com.google.android.dialer:id/dialpad_fab")).click();
		
		//Dial number
		driver.findElement(By.id("com.google.android.dialer:id/nine")).click();
		driver.findElement(By.id("com.google.android.dialer:id/eight")).click();
		driver.findElement(By.id("com.google.android.dialer:id/one")).click();
		driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
		driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
		driver.findElement(By.id("com.google.android.dialer:id/one")).click();
		driver.findElement(By.id("com.google.android.dialer:id/two")).click();
		driver.findElement(By.id("com.google.android.dialer:id/three")).click();
		driver.findElement(By.id("com.google.android.dialer:id/four")).click();
		driver.findElement(By.id("com.google.android.dialer:id/five")).click();

//		driver.findElement(By.id("com.google.android.dialer:id/dialpad_voice_call_button")).click();
			
		
		String number= driver.findElement(By.id("com.google.android.dialer:id/digits")).getText();		
		
		if(number.equals("98100 12345"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		driver.quit();
	

	}

}
