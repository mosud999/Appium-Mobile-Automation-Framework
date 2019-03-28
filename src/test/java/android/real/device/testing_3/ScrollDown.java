package android.real.device.testing_3;

import java.net.MalformedURLException;

import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;

/*
 * ScrollDown till the given element;
 * We are using Android codes inside our appium test script;
 * Creating object of UiScrollable class -> UiSelector class -> scrollIntoView() method where you have to specify until which
 * element it should scroll down; We are passing properties inside the  scrollIntoView method;
 * 
 * When you write your script based on emulator screen and execute in emulator it usually shows more contents 
 * on the screen as the emulator screen is bigger than real device. But when you want to run the same script in 
 * real device you may need to scroll for the same content as real device screen size is smaller than emulator. 
 * In that case you always have to check and modify your script.

 * 
*/

public class ScrollDown extends BaseConfigAndroidRealDevice {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities("real"); // calling the baseconfig driver;
		
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Views\"));")).click();;
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		driver.pressKeyCode(AndroidKeyCode.HOME);
		
		
	}

}
