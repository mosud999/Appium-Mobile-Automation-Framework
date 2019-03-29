package ios.appium.all.tutorials_5;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

/*
 * This script is for picking up date from auto scrolling wheel;
 * We have used webelement and the apply send keys;
 * 
 * */

public class IosPickerTest extends IOSBaseConfig{

	public static void main(String[] args) throws MalformedURLException {	
		
		IOSDriver<IOSElement> driver=ios_base_Config();
		
		driver.findElementByName("Picker View").click();
		driver.findElementByXPath("//XCUIElementTypePickerWheel[@name='Red color component value']").sendKeys("75");
		driver.findElementByXPath("	//XCUIElementTypePickerWheel[@name='Green color component value']").sendKeys("195");
		driver.findElementByXPath("//XCUIElementTypePickerWheel[@name='Blue color component value']").sendKeys("110");
		
	}

}

