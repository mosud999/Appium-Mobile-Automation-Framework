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
 * In this Program we tried scroll down and then click the Toolsbar button
 * and then navigate back; Some of the appium codes are not working in this new appium version;
 * That's why i used Javascript executor to scroll down;
 * 
 * */

public class IosScrollDownOnApp extends IOSBaseConfig{

	public static void main(String[] args) throws MalformedURLException {
		
		
		IOSDriver<IOSElement> driver=ios_base_Config();
		
		/*----------------Scroll Down-----------------------*/
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>(); // Takes key valu pair;
		scrollObject.put("direction", "down"); // put() is used to store data in HashMap;
		js.executeScript("mobile: scroll", scrollObject);
		
		/*----------------Click on Toolbars-----------------------*/
		driver.findElementByAccessibilityId("Steppers").click();
		

		/*----------------Click on increment and print the total incrment number-----------------------*/
		WebElement increment=driver.findElementByName("Increment");
		WebElement IncrementText=driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"0\"])[1]");
		increment.click();
		increment.click();
		System.out.println("Total Increment are: "+(IncrementText.getText()));
	
		
		/*----------------Navigate Back-----------------------*/
		driver.navigate().back();
		

	}

}

/*
	 SCROLL TO BOTTOM ON IOS
	 public void swiptToBottom()
		{
		Dimension dim = driver.manage().window().getSize();
		int height = dim.getHeight();
		int width = dim.getWidth();
		int x = width/2;
		int top_y = (int)(height*0.80);
		int bottom_y = (int)(height*0.20);
		System.out.println("coordinates :" + x + "  "+ top_y + " "+ bottom_y);
		TouchAction ts = new TouchAction(driver);
		ts.press(x, top_y).moveTo(x, bottom_y).release().perform();
		}
 */