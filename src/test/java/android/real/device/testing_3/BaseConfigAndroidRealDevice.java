package android.real.device.testing_3;

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

	public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {
		
		// Invoke app using .apk and absolute path;
				File f=new File("src/test/java");
				File fs=new File(f,"ApiDemos-debug.apk");
				DesiredCapabilities cap=new DesiredCapabilities();
				
				if(device.equals("emulator"))
				{
					cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X API 24");
				}
				
				else if(device.equals("real"))
				{
					cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
				}
				
				cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
				
				AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
				//System.out.println("server passed");
				return driver;
			}
	}


