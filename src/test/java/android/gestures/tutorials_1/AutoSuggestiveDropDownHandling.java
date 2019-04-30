package android.gestures.tutorials_1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSuggestiveDropDownHandling {
	
	/*
	 * How to handle auto suggestion?
	 * First we will write some characters and then we will wait for the whole suggested list class/ul;
	 * Then we will run a for each loop and setup a condition where suggested keyword equals to bangladesh:
	 * When the condition will match it will go inside and click on bangladesh;
	 * We can run the same exact script in our mobile version;
	 * */
	
	public static void main(String[] args)
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/mosudahmed/Desktop/Selenium/selenium-necessary/chromedriver");
		driver=new ChromeDriver();
		driver.get("http://www.google.com");
		
		/* -----Provide google search box xpath and type some characters-------- */
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Ban");
		
		/* -----Provide the whole suggested areas class or ul in custom wait list-------- */
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='erkvQe']")));
		List<WebElement> ele=driver.findElements(By.xpath("//ul[@class='erkvQe']/li"));
		
		/* -----Run for each loop and setup an exact condition for a specific word to click-------- */
		for(WebElement suggest:ele)
		{

			if(suggest.getText().equalsIgnoreCase("bangladesh"))
			{
				suggest.click();
				driver.close();
			}
		}

	}
	

}
