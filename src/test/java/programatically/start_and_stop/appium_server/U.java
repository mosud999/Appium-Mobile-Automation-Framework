package programatically.start_and_stop.appium_server;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
public class U {
	
	AppiumDriverLocalService service;
	AppiumDriver<MobileElement> driver;
	public void setUP()
	{
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		System.out.println("Server is started");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Nexus_5X_API_24");
		cap.setCapability("app", System.getProperty("src/test/java")+"ApiDemos-debug.apk");
		driver = new AndroidDriver<MobileElement>(service.getUrl(), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void validateText()
	{
		driver.findElementByAccessibilityId("Accessibility").click();
		String text = driver.findElementByAccessibilityId("Accessibility Node Provider").getText();
		if(text.equalsIgnoreCase("Accessibility Node Provider"))
		{
			System.out.println("Passed");
		} else
		{
			System.out.println("Failed");
		}
	}
	
	public void tearDown()
	{
		driver.quit();
		service.stop();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		U obj = new U();
		obj.setUP();
		obj.validateText();
		obj.tearDown();

	}

}
