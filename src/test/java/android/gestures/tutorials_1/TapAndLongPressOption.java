package android.gestures.tutorials_1;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
//This packagae need to import manually for touchoption();
import static io.appium.java_client.touch.TapOptions.tapOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

// This package needs to be imported manually for element option;
import static io.appium.java_client.touch.offset.ElementOption.element;
//This package needs to be imported manually for longPressOptions option;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//This package needs to be imported manually for ofSeconds() option;
import static java.time.Duration.ofSeconds;

/* This program we performed: 
 * 1. Tap 2.LongPress
 * What is the difference between tap and click?
 * Ans: For click you have to use mouse and for tap you have to touch on the specific element
 * although both of this two has same functionality;
 * To use the Tap first you have to create an object of TouchAction. By using the reference you can add the tapOption argument you can
 * give the element where you want to tap and then perform().
 * you can also perform longpress and other option using the reference;
 * for this tapOptions() and element you have manually import two packages mentioned above;
 * 
 * For longPress you have to use the duration like how long you will press and then release and then perform this action;
 * For longPress and ofSeconds you manually have to import the packages;
 * */

public class TapAndLongPressOption extends BaseConfig {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities(); // calling the baseconfig driver;

		// click on Views using UiAutomator;
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();

		TouchAction t = new TouchAction(driver);
		WebElement ele1 = driver.findElementByXPath("//android.widget.TextView[@index='8']");
		t.tap(tapOptions().withElement(element(ele1))).perform();
		WebElement ele2 = driver.findElement(MobileBy.AndroidUIAutomator("text(\"1. Custom Adapter\")"));
		t.tap(tapOptions().withElement(element(ele2))).perform();
		WebElement ele3 = driver.findElement(MobileBy.AndroidUIAutomator("text(\"People Names\")"));
		t.longPress(longPressOptions().withElement(element(ele3)).withDuration(ofSeconds(2))).release().perform();
		System.out.println(driver.findElementById("android:id/title").isDisplayed());

	}

}
