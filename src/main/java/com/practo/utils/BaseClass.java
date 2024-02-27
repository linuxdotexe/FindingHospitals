package com.practo.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

	static WebDriver driver;
	static Properties p;

	public static WebDriver initializeBrowser() throws IOException {

// TODO: Figure out automated multiple browser testing
		
//		switch (getProperties().getProperty("browser")) {
//		case "chrome":
//			driver = new ChromeDriver();
//			break;
//		case "edge":
//			driver = new EdgeDriver();
//			break;
//		case "firefox":
//			driver = new FirefoxDriver();
//			break;
//		default:
//			System.out.println("no matching browser");
//			driver = null;
//		}
				String os = getProperties().getProperty("os");
				String browser = getProperties().getProperty("browser");
				
				if(getProperties().getProperty("execution_env").equals("remote")) {
					DesiredCapabilities capabalities = new DesiredCapabilities();
					if(os .equalsIgnoreCase("windows")) {
						capabalities.setPlatform(Platform.WIN11);
					}
					else if (os.equalsIgnoreCase("mac")) {
						capabalities.setPlatform(Platform.MAC);
					}
					else {
						System.out.println("No matching OS");
					}
					if(browser.equals("chrome")) {
						capabalities.setBrowserName("chrome");
					}
					else if(browser.equals("edge")) {
						capabalities.setBrowserName("MicrosoftEdge");
					}
					else if(browser.equals("firefox")){
						capabalities.setBrowserName("Firefox");
					}
					else {
						System.out.println("No matching browser.");
					}
		 
					 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabalities);
				}
				else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
					if(browser.equals("chrome")) {
						driver = new ChromeDriver();
					}
					else if(browser.equals("edge")){
						driver = new EdgeDriver();
					}
					else if(browser.equals("firefox")){
						driver = new FirefoxDriver();
					}
					else {
						System.out.println("No matching browser.");
					}
				}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static Properties getProperties() {

		try {
			FileReader file = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties");
			p = new Properties(); // Creating new Properties instance
			p.load(file);
		} catch (Exception e) {

		}
		return p;
	}

}
