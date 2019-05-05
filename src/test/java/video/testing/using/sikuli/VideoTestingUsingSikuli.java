package video.testing.using.sikuli;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/*
		Youtube URL: https://www.youtube.com/watch?v=OtQAMoXYqes
		
		How to use Selenium with Sikuli (Automate Flash Objects)
		
		1.	Download and add jar file: SikuliX API
		2.	Take the capture of the particular image and store it
		3.	Then read the particular image and try to find the image on the webpage and then click
		Create object of screen: Class Screen is there, to have a representation for a pysical monitor where the capturing process (grabbing a rectangle from a screenshot, to be used for further processing with find operations is implemented. For Multi Monitor Environments it contains features to map to the relevant monitor.
		4.	 and 
		5.	pattern class: to declare the pattern for the specific image.
		
		Limitation:
		1.	Cannot open browser
		2.	Cannot open url
*/
public class VideoTestingUsingSikuli {

	public static void main(String[] args) throws FindFailed {
		System.setProperty("webdriver.chrome.driver",
				"/Users/mosudahmed/Desktop/Selenium/selenium-necessary/chromedriver");
		WebDriver driver = new ChromeDriver();

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://www.youtube.com/watch?v=XD_mFEz04x8");

		Screen screen = new Screen(); // To perform action on the screen;

		// click on Setting
		Pattern settingImg = new Pattern("Sikuli-images/Sikuli-YT-Setting.png");
		screen.wait(settingImg, 10000);
		screen.click();

		// click on Auto pixel
		Pattern autoPixelImg = new Pattern("Sikuli-images/Sikuli-YT-AutoPixel.png");
		screen.wait(autoPixelImg, 2000);
		screen.click();

		// click on 144 pixel
		Pattern pixelImg = new Pattern("Sikuli-images/Sikuli-YT-144p.png");
		screen.wait(pixelImg, 2000);
		screen.click();

		// Pause Video
		Pattern pauseImg = new Pattern("Sikuli-images/Sikuli-YT-Pause.png");
		screen.wait(pauseImg, 20000);
		screen.click();

	}

}
