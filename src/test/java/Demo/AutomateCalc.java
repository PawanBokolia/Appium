package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateCalc {

	public static void main(String[] args) throws MalformedURLException {
	
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("appium:deviceName","OnePlus CHP2661");
		capabilities.setCapability("appium:platformName ","Android");
		capabilities.setCapability("appium:automationName","uiautomator2");
		capabilities.setCapability("appium:appPackage","com.oneplus.calculator");
		capabilities.setCapability("appium:appActivity","com.android.calculator2.Calculator");
		
		URL url =URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url,capabilities);
		
		System.out.println("Apllication Started");
		
		//Click on number 8
		WebElement num8= driver.findElement(By.id("com.oneplus.calculator:id/digit_8"));
		num8.click();
		
		//Click on plus sign 
		WebElement plus = driver.findElement(By.id("com.oneplus.calculator:id/op_add"));	
		plus.click();
		
		//Click on number 2 
		WebElement num2 = driver.findElement(By.id("com.oneplus.calculator:id/digit_2"));
		num2.click();
		
		//Click on equal sign 
		WebElement equal= driver.findElement(By.id("com.oneplus.calculator:id/eq"));
		equal.click();
		
		WebElement result= driver.findElement(By.id("com.oneplus.calculator:id/result"));
		String resultString  = result.getText();
		
		if(resultString.equals("10"))
		{
			System.out.println("result Pass");
		}

		else
		{
			System.out.println("Result fail");
		}
		
		driver.quit();
	
		
		
	}

}
