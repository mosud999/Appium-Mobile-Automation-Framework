package programatically.start_and_stop.appium_server;

import java.io.File;
import java.text.SimpleDateFormat;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

/*-------------How to run Appium server Programatically? ----------------------------
 * 
	1. First you have to get the nodepath and appium js path and put it on a String variable;
	
	2. invoke buildService method where you can create object of AppiumServiceBuilder() which has some static
	method usingDriverExecutable(), withAppiumJS(), withIPAddress(), usingPort(), withLogFile();
	
	3. Next you configure the DesiredCapabilities class in your @BeforeTest;

    * Please note: In usingPort() always pass a free port; Not the same port which you run appium server from
    terminal;

    * YouTube URL: https://www.youtube.com/watch?v=xsXZYv9vDc4

-------------How to get node.exe path in mac?---------------
	* Open search and type:
	/usr/local/bin
	 
	1. open terminal and drag the node.exe to get the path 
	or 
	2.right click on node and get info and then add node.

-------------How to get the path of Appium.js?---------------
    * Right click on the appium icon from start menu->Options->Show in finder-> it will send you to Application Appium->
    right click->show package contents->contents->resources->app->node_modules->appium->build->lib->mainjs->
    drag and drop in terminal to get the path

    * YouTube URL:https://www.youtube.com/watch?v=RRwvFCAzwgk

------------------------------------------------------------*/

public class UsingAppiumDriverLocalService {

	String nodePath = "/usr/local/bin/node";
	String appiumMainJsPath = "/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js";
	AppiumDriverLocalService service;
	SimpleDateFormat df = new SimpleDateFormat("MM-DD-YYYY:mm:ss.SSS");

	@BeforeTest
	public void setUp() {
		service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File(nodePath))
				.withAppiumJS(new File(appiumMainJsPath))
				.withIPAddress("127.0.0.1")
				.usingPort(4728)
				.withLogFile(new File("/Users/mosudahmed/eclipse-protractor"
						+ "/Appium-Mobile-Automation/test-output/Appium-programatic-log.txt")));
		service.start();
		System.out.println("Server is started ..");
		
		// You can write your DesiredCapabilities here;

	}

	@Test
	public void executeTest() {
		System.out.println("The URL is: " + service.getUrl().toString());
		System.out.println("Is server running: " + service.isRunning());
	}

	@AfterTest
	public void tearDown() {

		if (service.isRunning() == true) {
			service.stop();
		}

		System.out.println("Serve is stopped ..");
	}

}
