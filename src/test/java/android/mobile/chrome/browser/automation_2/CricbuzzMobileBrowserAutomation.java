package android.mobile.chrome.browser.automation_2;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CricbuzzMobileBrowserAutomation extends BaseConfigAndroidRealDevice{
	
	/*
	 * Steps to test Android phone chrome browser:
	 * 1. Connect the phone via USB and the start the server from terminal (type:appium->enter);
	 * 2. Configure mac chrome browser to phone chrome browser; while configuring keep your phone browser on;
	 * 3.Click on the link from remote device which will invoke the same url on mac;
	 * 4.Inspect element and get the elemenet using locator like selenium;
	 * 5. We can not use AndroidUiAutomator as this is not an app;
	 * 6. See instructions on the Android document file->confgure real device and configure browser both;
	 * 7. Run your script from eclipse and keep your phone unlock;
	 * */

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.get("http://cricbuzz.com");
		driver.findElementByXPath("//a[@href='#menu']").click();
		driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
		System.out.println(driver.getCurrentUrl());
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,480)", "");
		
		// Validate top stories text is header content or not;
		//Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));
		   


		//adb devices- Unauthorized
		//adb kill-server
		//adb start-server
		//adb devices
	}

}
