package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class SwitchHandling {

	public static void main(String[] args) throws MalformedURLException {
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

		String MobileElementToScroll = "Switches";
		WebElement switchElement = driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""+MobileElementToScroll +"\"))"));
		switchElement.click();

		WebElement Monitorswitch = driver.findElement(By.id("io.appium.android.apis:id/monitored_switch"));
		if(Monitorswitch.isSelected()==true)
		{
			System.out.println("Monitor swtich is on ");
		}

		else
		{
			System.out.println("switch is off ");
			Monitorswitch.click();
		}



	}

}
