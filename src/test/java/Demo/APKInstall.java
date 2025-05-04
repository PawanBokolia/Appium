package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class APKInstall {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
	
		//gather Desired capabilities
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("appium:deviceName","AndroidEmulator");
		capabilities.setCapability("appium:platformName ","Android");
		capabilities.setCapability("appium:automationName","uiautomator2");
		capabilities.setCapability("appium:app","D:\\Testing\\Appium_apk\\app-debug.apk");
		capabilities.setCapability("appium:platformVersion", "13");
		
		URL url =URI.create("http://127.0.0.1:4723/").toURL();
		
		AndroidDriver driver = new AndroidDriver(url,capabilities);
		
		Thread.sleep(5000);
		System.out.println("application is install");
		

		
/*		//another options if capabilities are not working
 
		 UiAutomator2Options options = new UiAutomator2Options();

	        options.setPlatformName("Android");
	        options.setDeviceName("AndroidEmulator");
	        options.setAutomationName("UiAutomator2");
	        options.setApp("D:\\Testing\\Appium_apk\\app-debug.apk");

	        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723"), options);

	        Thread.sleep(5000);
			System.out.println("application is install");
		
*/		
		
		
		driver.quit();
		
		
		
		
		
	}

}
