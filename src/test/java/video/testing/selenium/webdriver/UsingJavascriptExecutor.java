package video.testing.selenium.webdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;

public class UsingJavascriptExecutor {
	
	public static void main(String[] args) throws InterruptedException

	{
		System.setProperty("webdriver.gecko.driver", "/Users/mosudahmed/Desktop/Selenium/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.w3.org/2010/05/video/mediaevents.html");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//play video
		 js .executeScript("document.getElementById(\"video\").play()");
		 Thread.sleep(5000);
		   
		 //pause playing video 
		 js .executeScript("document.getElementById(\"video\").pause()");
		   
		 //check video is paused
		 System.out.println(js .executeScript("document.getElementById(\"video\").paused"));
		   
		 js .executeScript("document.getElementById(\"video\").play()");
		   
		 // play video from starting
		 js .executeScript("document.getElementById(\"video\").currentTime=0");
		 Thread.sleep(5000);
		   
		 //reload video
		 js .executeScript("document.getElementById(\"video\").load()");
		
		//driver.close();
		 
		 
		 /* Using xpath
		  * WebElement video = driver.findElement(By.tagName("video"));
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		
		  // pausing the video
		  js.executeScript("arguments[0].pause();", video);
		
		  Thread.sleep(5000L);
		
		        //playing the video         
		  js.executeScript("arguments[0].play();", video);
		  Thread.sleep(5000L);﻿
		  * */
	}
}
