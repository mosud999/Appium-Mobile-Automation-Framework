package MainAppConfiguration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class AppConfigUsingPackageAndActivity {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		
		/*
		 * In this code we invoke our real device app by APP_PACKAGE and APP_ACTIVITY;
		 * You don't need to use the absolute path or invoke any .apk file in that case;
		 * 
		 * How to get an app package name and activity?
		 * Ans: By Installing APK-INFO app which will provide all the package and activity information 
		 * for all the installed app;
		 * */
		
		//File f=new File("src/test/java");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X API 24");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.whatsapp");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "main.activity");
		
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		//System.out.println("server passed");
		return driver;
	}

}
