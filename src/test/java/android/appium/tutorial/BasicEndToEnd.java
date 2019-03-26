package android.appium.tutorial;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BasicEndToEnd extends BaseConfig {

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement > driver=capabilities(); // calling the baseconfig driver;
		//End to End scenario of an app;
		driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		driver.findElement(By.xpath("(//android.widget.TextView)[4]")).click();
		driver.findElementById("android:id/checkbox").click(); // using id locator
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click(); // xpath index starts from 1;
		driver.findElementByClassName("android.widget.EditText").sendKeys("Hello");
		driver.findElementsByClassName("android.widget.Button").get(0).click(); //get index starts from 0;
		
	}

}
