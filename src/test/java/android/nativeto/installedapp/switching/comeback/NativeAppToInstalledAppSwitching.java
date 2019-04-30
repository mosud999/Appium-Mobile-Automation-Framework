package android.nativeto.installedapp.switching.comeback;

import static org.testng.Assert.assertNotNull;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

//This packagae need to import manually for tapOptions();
import static io.appium.java_client.touch.TapOptions.tapOptions;

//This package needs to be imported manually for withElement(element(expandleElement))-->element;
import static io.appium.java_client.touch.offset.ElementOption.element;

//This package needs to be imported manually for longPressOptions option;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//This package needs to be imported manually for ofSeconds() option;
import static java.time.Duration.ofSeconds;

public class NativeAppToInstalledAppSwitching {
	
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void setUp() throws MalformedURLException
	{
		File f = new File("src/test/java");
		File file = new File(f,"ApiDemos-debug.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "v1.12.0");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_5X_API_24");
		capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "15");
		//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "");
		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
	}
	
	@Test
	public void mainTest() throws MalformedURLException, InterruptedException
	{
		// Native app;
		setUp();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Accessibility']")).click();
	    driver.navigate().back();
	    driver.navigate().back();
		
		
		// Launch to installed setting app to see the wifi connections;
	    String appPackage="com.android.settings";
	    String appActivity="com.android.settings.Settings";
	    Activity activity = new Activity(appPackage, appActivity);
	    activity.setStopApp(false);
	    ((AndroidDriver<AndroidElement>) driver).startActivity(activity);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    driver.findElement(MobileBy.AndroidUIAutomator("text(\"Wi‑Fi\")")).click();
	    System.out.println(driver.findElement(MobileBy.AndroidUIAutomator("text(\"On\")")).getText());
	    
	    // Relaunch native app
		

	}
	
	@AfterTest
	public void tearDown()
	{
		/*if(driver!=null)
		{
			driver.close();
		}*/
	}

}
