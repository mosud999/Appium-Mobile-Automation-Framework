package android.gestures.tutorials_1;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//This package needs to be imported manually for element option;
import static io.appium.java_client.touch.offset.ElementOption.element;
//This package needs to be imported manually for longPressOptions option;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

/*
 * DragAndDrop
 * Steps are :
 * longpress->on element->move to->destination(element)->release->perform;
 * 
*/

public class DragAndDrop extends BaseConfig {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities(); // calling the baseconfig driver;

		// Click on Views using UiAutomator;
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
		// Click on DragAndDrop;
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Drag and Drop\")")).click();
		
		TouchAction t=new TouchAction(driver);
		WebElement source=driver.findElementsByClassName("android.view.View").get(0);
		WebElement destination=driver.findElementsByClassName("android.view.View").get(1);
		//t.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
		t.longPress((element(source))).moveTo(element(destination)).release().perform();
		
		
	}

}
