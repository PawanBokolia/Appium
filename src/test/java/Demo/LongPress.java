package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LongPress{
	
	static AndroidDriver driver;
	
	
	public static void main (String []args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appium:deviceName","OnePlus CHP2661");
		capabilities.setCapability("appium:platformName ","Android");
		capabilities.setCapability("appium:automationName","uiautomator2");
//		capabilities.setCapability("appium:platformversion","15");

		capabilities.setCapability("appium:appPackage","com.google.android.dialer");
		capabilities.setCapability("appium:appActivity","com.google.android.dialer.extensions.GoogleDialtactsActivity");
		
		//
		
		URL url =URI.create("http://127.0.0.1:4723/").toURL();
		driver = new AndroidDriver(url,capabilities);

		System.out.println("Apllication Started");
	
		//click on dial pad
		driver.findElement(By.id("com.google.android.dialer:id/dialpad_fab")).click();
		
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
	
		//Long press the delete button 
		WebElement backSpace = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"backspace\"]"));
		
		backSpace.click();  //remove one digit 
		
		Thread.sleep(4000);
		longPress(backSpace);

	}
	
	
	static void longPress(WebElement el)
	{
		
		Point location =el.getLocation();
		
		PointerInput finger = new PointerInput (PointerInput.Kind.TOUCH,"finger");
		
		Sequence longPress = new Sequence (finger, 1);
		longPress.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), location.x, location.y));
		longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		longPress.addAction(finger.createPointerMove(Duration.ofMillis(1000),PointerInput.Origin.viewport(),location.x, location.y));
		longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		
		driver.perform(Collections.singletonList(longPress));	
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
