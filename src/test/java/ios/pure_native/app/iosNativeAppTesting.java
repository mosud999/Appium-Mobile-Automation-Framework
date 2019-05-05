package ios.pure_native.app;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/*
 * IOS App testing Important note/Appium Server Config/Inspecting
YouTube url: https://www.youtube.com/watch?v=RagNvVuCvLI&list=PL-AJRKaxM-cb98PSYBpIQ9g_Vo1sn8L7f

Blogger name: Session 01: Inspect iOS Native App using Appium Desktop on Mac

Channel name: Automation -Studio

⎫	Open Appium GUI
⎫	 Start the server
⎫	  You can see the inspect element icon top right corner
⎫	   Configure your desired cap
⎫	    To see the devices: 
o	     Open terminal and type: instruments –s devices
o	       Then you will be able to see all the devices in your terminal.
⎫	         Configure app(path of the app), platfromName, platformVersion, deviceName, udid, automationName.
o	
⎫	When you will click start session it will automatically run simulator and copy the app from simulator to the appium screen.
⎫	To update your insepct screen you can either change the screen in simulator and then hit refresh in appium server or you can use tap directly from appium server.
⎫	To see the id/xpath is unique or not you can click on search icon and then select id/xpath then click ok and you will see how many nodes are for this particular  xpath/id.
⎫	Do not use class name as class can contain more element. Class name is button.
⎫	Appium server you use recording where you have to start the recording and then tap on element you will get your script automatically generated in appium. If you want use your particular attribute click on search and then select then hit tap. Very Important.
o	

 * /*
 */

public class iosNativeAppTesting {
	
	AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setUp() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP, "/Users/mosudahmed/Desktop/UICatalog.app");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
		capabilities.setCapability(MobileCapabilityType.UDID, "FE75E765-2772-4964-A71B-C374B7061283");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
		
		
		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void iosNativeAppExecution()
	{
		MobileElement els1 = (MobileElement) driver.findElementsById("Toolbars");
		els1.click();
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Okay / Cancel");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Destructive Choice");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Okay / Cancel");
		el3.click();
		el3.click();
	}
	
	@AfterTest
	public void tearDown()
	{
		if(!(driver==null))
		{
			driver.close();
		}
	}

}
