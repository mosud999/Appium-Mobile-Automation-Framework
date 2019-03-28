package android.mobile.chrome.browser.automation_2;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class BaseConfigAndroidRealDevice {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		

		/*
		 * Steps to test Android phone chrome browser:
		 * 1. Connect the phone via USB and the start the server from terminal (type:appium->enter);
		 * 2. Configure mac chrome browser to phone chrome browser; while configuring keep your phone browser on;
		 * 3.Click on the link from remote device which will invoke the same url on mac;
		 * 4.Inspect element and get the elemenet using locator like selenium;
		 * 5. We can not use AndroidUiAutomator as this is not an app;
		 * 6. See instructions on the Android document file->confgure real device and configure browser both;
		 * 7. Run your script from eclipse and keep your phone unlock;
		 */
	
		/*
		 * In this program we will execute our test script thorugh mobile browser; For that first i have to configure
		 * Browser Name in the config page; Then i have establish connection between mobile browser and system browser;
		 * Step: go to chrome browser->more tools->New->Developers tools->remote devices (click on 3 dots)->
		 * check if any remote devices are connected->click on the device name (nexys)->
		 * click on remote deice and keep your phone on and open the browser;
		 * Set the browser on  cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		 * 
		 */
		
				AndroidDriver<AndroidElement> driver;
				DesiredCapabilities cap=new DesiredCapabilities();
			    cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
			    cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

				driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
				//System.out.println("server passed");
				return driver;
				
				
				
			}
	}


