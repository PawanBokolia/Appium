package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppManagement {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appium:deviceName","OnePlus CHP2661");
		capabilities.setCapability("appium:platformName ","Android");
		capabilities.setCapability("appium:automationName","uiautomator2");
		capabilities.setCapability("appium:platformversion", "15");


		URL url =URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url,capabilities);

		Thread.sleep(2000);

		String packageName = "io.appium.android.apis";
		
		//terminate the application  
//		driver.terminateApp(packageName);
		
		//remove the application 
//		driver.removeApp(packageName);		
		 
		if(!driver.isAppInstalled(packageName))
		{
			//Install application
			driver.installApp("D:\\Testing\\Appium_apk\\ApiDemos-debug.apk");
		}
		else 
		{
			System.out.println("app already install ");
		}
		
		//Activate the application 
		driver.activateApp(packageName);

		Thread.sleep(3000);

		driver.quit();



	}

}
