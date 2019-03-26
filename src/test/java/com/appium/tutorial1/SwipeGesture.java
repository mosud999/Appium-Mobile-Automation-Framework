package com.appium.tutorial1;

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

/* 
 * In this program we will perform swipe operation;
 * LongPress->on element->wait->moveToElement->release->perform;
 */

public class SwipeGesture extends BaseConfig {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities(); // calling the baseconfig driver;

		// Click on Views using UiAutomator;
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
		// Click on date widgets;
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Date Widgets\")")).click();
		// Click on Inline button;
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"2. Inline\")")).click();
		
		// Create object of TouchAction to use swipe gesture;
		TouchAction t = new TouchAction(driver);
		WebElement element1 = driver.findElement(MobileBy.AndroidUIAutomator("content-desc(\"9\")"));
		t.tap(tapOptions().withElement(element(element1))).perform();
		WebElement first_element=driver.findElementByXPath("//*[@content-desc='15']");
		WebElement second_element=driver.findElementByXPath("//*[@content-desc='45']");
		
		// LongPress->on element->wait->moveToElement->release->perform;
		t.longPress(longPressOptions().withElement(element(first_element)).withDuration(ofSeconds(2))).moveTo(element(second_element)).release().perform();
	
		
	}

}
