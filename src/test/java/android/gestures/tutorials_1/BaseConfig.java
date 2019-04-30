package android.gestures.tutorials_1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseConfig {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		// TODO Auto-generated method stub
		
		File f=new File("src/test/java");
		File fs=new File(f,"ApiDemos-debug.apk");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus 5X API 24");
		//System.out.println("device passed");
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		//System.out.println("app passed");
		
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		//System.out.println("server passed");
		return driver;
	}

}
