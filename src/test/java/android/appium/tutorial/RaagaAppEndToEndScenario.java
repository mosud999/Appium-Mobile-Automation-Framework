package android.appium.tutorial;
	
	import java.net.MalformedURLException;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Point;

	import io.appium.java_client.TouchAction;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

	// End2End scenario with hadling toggle;
	public class RaagaAppEndToEndScenario extends BaseConfig {

		public static void main(String[] args) throws MalformedURLException {
			// TODO Auto-generated method stub

			AndroidDriver<AndroidElement> driver=capabilities();
		     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		     driver.findElementByXPath("//android.widget.TextView[@text='Done']").click();
		     driver.findElementById("com.raaga.android:id/landing_skip_to_raaga").click();
		     driver.findElementByXPath("//android.widget.TextView[@text='World Music']").click();
		     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"com.raaga.android:id/music_home_raaga_live\"));");
		     driver.findElementById("com.raaga.android:id/music_home_raaga_live").click();
		     driver.findElementById("com.raaga.android:id/toolbar_logo").click();
		     driver.findElementByXPath("//android.widget.TextView[@text='Settings']").click();
		     driver.findElementByXPath("//android.widget.TextView[@text='Push Notification']").click();
		     
		    /*  
		     * Handling toggle switch on/off;
		     it will go and grab the total location of the toggle by getLocation() which will return Point coordinates;
		     Then based on the coordinates you have to put the x and y pixel area for the tapping;
		     */
		    		 
		     Point point= driver.findElementById("com.raaga.android:id/toggle_notifyrecommend").getLocation();
		     TouchAction t= new TouchAction(driver);
		     //toggle on
		    
		   //  t.tap(point.x+20, point.y+30).perform(); // Scroll on;
		     //toggle off
		   //  t.tap(point.x+100, point.y+30).perform(); // Scroll off;
		  
		    
		     /* ---------------------------------------------------------
		      * Appium has deprecated the t.tap(point.x+20, point.y+30); Instead of this we have to use the below 
		     one option now;

		    // Using PointOption.point(x, y), which is a static instance of PointOption with those coordinate values
			    	 TouchAction touchAction = new TouchAction(driver);
			    	 touchAction.tap(PointOption.point(1280, 1013)).perform();
		    	 
		    //Using PointOption().withCoordinates(x, y), which returns a reference to the PointOption instance after setting those coordinate values
		    	
			    	 TouchAction touchAction = new TouchAction(driver);
			    	 touchAction.tap(new PointOption().withCoordinates(1280, 1013)).perform();
		    	 
		    	 ------------------------------------------------------------------------------*/
	     
			
		}

	}



