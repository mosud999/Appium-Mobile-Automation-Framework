package android.device.installed.app.config;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstalledAppOpeningConfig {
	
	
	public static AndroidDriver<AndroidElement> appConfig() throws MalformedURLException
	{
		/*---- Desired Cap for native app with
		 * File file = new File("src/main/resources");
		File appFile = new File(file,"ApiDemos-debug.apk");
		DesiredCapabilities cap =  new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, "v1.12.0");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5X_API_24");
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		cap.setCapability(MobileCapabilityType.APP, appFile.getAbsolutePath());
	
			AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			return driver;*/
		
		/*Desired cap for installed app*/
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5X_API_24");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.google.android.apps.chrome.Main");
	
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		return driver;
		
	}
	
	
	/*	DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability("appiumVersion", "1.4.16");
		caps.setCapability("deviceName","Android Emulator");
		caps.setCapability("deviceType","tablet");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("browserName", "");
		caps.setCapability("platformVersion","4.1");
		caps.setCapability("platformName","Android");
		caps.setCapability("app","sauce-storage:myapp.zip");
		caps.setCapability("automationName","Selendroid");*/

}
