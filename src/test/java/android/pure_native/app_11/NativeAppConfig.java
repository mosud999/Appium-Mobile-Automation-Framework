package android.pure_native.app_11;

import static org.testng.Assert.assertNotNull;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

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

public class NativeAppConfig {
	
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
		setUp();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Accessibility']")).click();
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Accessibility Node Querying']")).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(By.xpath("(//android.widget.TextView)[@text='Views']")).click();
		
		
		/*-------Scroll to an Element; No need to import any jar for this scroll; ----------------*/
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))").click();
		
		WebElement expandleElement = driver.findElementByXPath("//android.widget.TextView[@index='8']");
		WebElement customadapterElement = driver.findElement(MobileBy.AndroidUIAutomator("text(\"1. Custom Adapter\")"));
		WebElement peoplenamesElement = driver.findElement(MobileBy.AndroidUIAutomator("text(\"People Names\")"));
		WebElement samplementElement = driver.findElementById("android:id/title");	
		
		/*----------------------------------------------
		 			* Scenario-1 Started Below 
		 * ---------------------------------------------
		 * Click on Views->
		 * Tap on Expandable Lists -> 
		 * Tap on 1. Custom Adapter -> 
		 * Long press on People Names -> 
		 * Check Sample menu is displayed
		 --------------------------------------------------------------------- */
		 
		/*-------Create an object of TouchAction class to perform------*/
		TouchAction touchAction = new TouchAction(driver);
		
		/*-------Tap Option -> import package on top manually--------*/
		Thread.sleep(3000);
		touchAction.tap(tapOptions().withElement(element(expandleElement))).perform();
		Thread.sleep(3000);
		touchAction.tap(tapOptions().withElement(element(customadapterElement))).perform();
		
		/*-------Long Press Option -> import package on top manually--------*/
		Thread.sleep(3000);
		touchAction.longPress(longPressOptions().withElement(element(peoplenamesElement)).withDuration(ofSeconds(2))).release().perform();
		
		/*-------Checks condition if element is displayed or not--------*/
		if(samplementElement.isDisplayed())
		{
			System.out.println(samplementElement.getText() + " is Displayed");
		}
		
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		
		/*------------------------------------------------------
		 * 						Scenario-1 End 
		 * ------------------------------------------------------*/
		
        
		
		System.out.println("Success");

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
