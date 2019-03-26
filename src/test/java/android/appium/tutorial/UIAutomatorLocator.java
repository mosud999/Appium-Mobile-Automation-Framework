package android.appium.tutorial;

import java.net.MalformedURLException;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIAutomatorLocator extends BaseConfig{
	
	public static void main(String[] args) throws MalformedURLException {
		
	
	AndroidDriver<AndroidElement > driver=capabilities(); // calling the baseconfig driver;
	
	/*
	---------- SYNTAX FOR USING UI AUTOMATOR ------------------------
	driver.findElement(MobileBy.AndroidUIAutomator("")).click(); --> use this for UIAutomator Locator;
	
	
	---------- SYNTAX FOR UIAUTOMATOR ATTRIBUTE-----------------------
	driver.findElement(MobileBy.AndroidUIAutomator("attribute(value)");
	---------- USE BACKSLASH IF YOU HAVE "(DOUBLE QUOTATION) INSIDE "(DOUBLE QUOTATION);
	driver.findElement(MobileBy.AndroidUIAutomator("attribute(\"value\")");
	
	--------- SYNATX FOR UIAUTOMATOR PROPERTIES -----------------------
	driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().clickable(true)")); --> clickable is  a property;
	*/
	
	// click on Views using UiAutomator;
	driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
	
	// Verify all the items are not clickable;
	int count=driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().clickable(true)")).size();
	System.out.println("Clickable items are: " +count);
	}

}
