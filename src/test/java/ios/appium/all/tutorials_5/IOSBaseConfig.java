package ios.appium.all.tutorials_5;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class IOSBaseConfig {
	
	/*------WE HAVE USED ICatalog.app WHICH IS IN DESKTOP----*/
	
	public static IOSDriver<IOSElement> ios_base_Config() throws MalformedURLException  {

		IOSDriver<IOSElement>driver;
		DesiredCapabilities d=new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6"); // d.setCapability(String, Objectvalue);
		d.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		d.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
		d.setCapability(MobileCapabilityType.APP, "/Users/mosudahmed/Desktop/UICatalog.app");
		/*-----Found error while running the below code-------*/
		d.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		
		driver=new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),d);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}

}

		/* -------------- standard format for iOS setup---------------
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Simulator");
		capabilities.setCapability(MobileCapabilityType.APP, myApp);
		---------------------------------------------------------------------------------
		*/
