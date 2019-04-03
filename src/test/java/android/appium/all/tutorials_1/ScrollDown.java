package android.appium.all.tutorials_1;

import java.net.MalformedURLException;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/*
 * ScrollDown till the given element;
 * We are using Android codes inside our appium test script;
 * Creating object of UiScrollable class -> UiSelector class -> scrollIntoView() method where you have to specify until which
 * element it should scroll down; We are passing properties inside the  scrollIntoView method;
 * 
*/

public class ScrollDown extends BaseConfig {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities(); // calling the baseconfig driver;

		// Click on Views using UiAutomator;
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		
		
	}

}