package cloud.base.testing.saucelab;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;

public class SafariBrowserSauceLab {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// TODO Auto-generated method stub

		DesiredCapabilities dc=DesiredCapabilities.iphone();

		dc.setCapability("platformName", "iOS");

		//cap.setCapability(MobileCapabilityType.PLATFORM_NAME,MobilePlatform.IOS);

		dc.setCapability("platformVersion", "7.1");

		//cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"7.1");

		dc.setCapability("appiumVersion", "1.3.4");

		dc.setCapability("deviceName", "iPhone Simulator");

		dc.setCapability("browserName", "safari");

		IOSDriver driver=new IOSDriver(new URL("http://rahul1:e950d779-1817-4c3c-b122-06715b814dfd@ondemand.saucelabs.com:80/wd/hub"),dc);

		//IOSDriver driver=new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap );

		/*driver.get("http://google.com");

		Thread.sleep(8000L);*/

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Navigating to Udemy");

		driver.get("https://udemy.com");

		System.out.println("Succesfully navigated to Udemy");

		driver.findElement(By.xpath(".//*[@id='ios-splash']/a")).click();

		//tagname[@attribute='value']

		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("SoapUI");

		driver.findElement(By.xpath("//button[contains(@class,search-btn)]/i")).click();

		//System.out.println(driver.getTitle());

		//*[@id="courses"]/li[1]/a/span[2]

		System.out.println(driver.findElement(By.xpath(".//*[@id='courses']/li[1]/a/span[2]")).getText());

		}

}
