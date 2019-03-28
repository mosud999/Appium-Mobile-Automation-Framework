package android.appium.all.tutorials_1;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


/*
 * Important Appium Methods;
*/

public class ImportantAppiumMethods extends BaseConfig {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities(); // calling the baseconfig driver;
		// To see the current activity of the app;
		System.out.println(driver.currentActivity());
		
		// To see which specific mode/app you are in? Native, Hybrid or WebView?
		System.out.println(driver.getContext());
		
		// To see the rotating position of the current app; 
		System.out.println(driver.getOrientation());
		
		//driver.isLocked();
		
		// To hide the keyboard if it is open on the screen;
		//driver.hideKeyboard();
		
		// To perform Back, Backspace, Home or keyboard specific methods;
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
		driver.pressKeyCode(AndroidKeyCode.BACK);
		
		
		
	}

}
