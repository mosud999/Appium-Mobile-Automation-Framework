package android.hybrid.app.features.and.testing_4;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

/* 
 * ----------------How to test hybrid app?---------------------------------------------------
 * 
 * We have to follow two main steps for testing Hybrid Apps:-
 *    1. Ask developer to enable WebView debugging, call the static method setWebContentsDebuggingEnabled 
 * on the WebView class. Otherwise, you may see the switching is not working;
 * 
 *    2. You need to switch to native app for working on native app object and also switch to web view app for working on
 * web view of the app. You can first use getContext() to see which context view you are working in and then you can use 
 * getContextHandles() to get all the context views of this current app. Next we will run for-each loop to get all
 * the context views names or you can ask your developer to give you the names. After iterating you will get names
 * like this: 
	 * 	NATIVE APP AND 
	 * 	WEBVIEW_com.example.testapp;
 * The next thing you have to do is switching to the context view by their name. See example below:
 * driver.context("WEBVIEW_com.example.testapp");
 * // then you may start doing test for web view/ of that apps.
 * ----------------------------------------------------------------------------------------------
 * 
 * */

public class HybridAppTestingOnAndroid {
	
	public static void main(String[] args) throws MalformedURLException 
	{
		
		File appDir=new File("src");
		File app=new File(appDir,"testApp.apk"); // this code is just for understanding; testApp.apk is udemy app;
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	
		
		AndroidDriver<AndroidElement> driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
        /*-------To check which context view are you working on currently--------*/
		System.out.println(driver.getContext());

		/*-------Type on the native app search bar and then click on the Go Button which will go the web view--------*/
		driver.findElement(By.id("com.example.testapp:id/urlField")).sendKeys("http://google.com");
		driver.findElement(By.id("com.example.testapp:id/goButton")).click();

		/*-------To see how many context views are present in this app and store all in the s variable // 1 native and 1 web view=2 views are present here--------*/
		Set<String> s=driver.getContextHandles();

		/*-------Iterating one by one and print the names of the context views--------*/
		for(String handle : s)
		{
		System.out.println(handle);
		}

		/*-------Switching to the Web view by context web view name and then start working on web view--------*/
		//driver.context(name)
		driver.context("WEBVIEW_com.example.testapp");
        driver.findElement(By.name("q")).sendKeys("Handling hybrid app");

        /*-------Switching to the native app and start working on the native app;--------*/
		driver.context("NATIVE_APP");

		
	}

}
