package android.mobile.chrome.browser.automation_2;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FacebookLoginMobileBrowser extends BaseConfigAndroidRealDevice{
	
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
		driver.get("http://www.facebook.com");
		System.out.println(driver.getCurrentUrl());
		driver.findElementByXPath("//input[@name='email']").sendKeys("bittect@usa.com");
		driver.findElementByXPath("//input[@name='pass']").sendKeys("123456");
		//driver.findElementByXPath("//button[@name='login']").click();
		
		System.out.println(driver.findElementByXPath("//button[@name='login']").isDisplayed());
		
		/*
		******How to scroll down in mobile browser? Follow below steps:******
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)", ""); //250 medium //480 highest'
		*/
	}

}
