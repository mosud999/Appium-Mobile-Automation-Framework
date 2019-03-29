package ios.appium.all.tutorials_5;

import java.net.MalformedURLException;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

/*
 * In this program, at first we call the base config;
 * Then we use different locators to click and sendkeys;
 * IOS most powerful locator is findElementByAccessibilityId;
 * For xpath the class name is tag name and see appium inspect element to get the attribute; 
 * 
 * */

public class IosBasics extends IOSBaseConfig{

	public static void main(String[] args) throws MalformedURLException {
		
		IOSDriver<IOSElement>driver=ios_base_Config();
		driver.findElementByAccessibilityId("Alert Views").click(); // Click on alert using powerful findElementByAccessibilityId;
		driver.findElementByXPath("//*[@name='Text Entry']").click(); // Click on text using xpath;
		driver.findElementByClassName("XCUIElementTypeOther").sendKeys("hello"); //using class name;
		driver.findElementByName("OK").click(); // using name locator;

	}

}
