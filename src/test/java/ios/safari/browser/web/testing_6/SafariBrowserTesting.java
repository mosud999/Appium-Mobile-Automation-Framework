package ios.safari.browser.web.testing_6;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

/*
 * Safari Browser Automation;
 * Setup the configuration and then write normal website code;
 * To inspect element got your browser->install user agent-> 
 * Open user agent->select iPhone->select browser->select operating system;
 * Then inspect element from your mac browser and write your script.
 * Finally run the program;
 */

public class SafariBrowserTesting{

	public static void main(String[] args) throws MalformedURLException  {

		IOSDriver<IOSElement>driver;
		DesiredCapabilities d=new DesiredCapabilities();
		d.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6"); // d.setCapability(String, Objectvalue);
		d.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		d.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
		d.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		
		
		driver=new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),d);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println(driver.getContext());
		driver.get("http://www.facebook.com");
		driver.findElementByName("email").sendKeys("mosud");
		driver.findElementByName("pass").sendKeys("1234567");
		
	}

}
