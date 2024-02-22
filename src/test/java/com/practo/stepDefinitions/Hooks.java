package com.practo.stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.practo.utils.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	static WebDriver driver;
	static Properties p;
	
	@Before
	public static void setup() throws IOException{
		driver = BaseClass.initializeBrowse();		
		p = BaseClass.getProperties();
		driver.manage().window().maximize();
		driver.get(p.getProperty("appUrl"));
	}
	
	@After
	public static void tearDown() {
//		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		// For cucumber JUnit report
			System.out.println(scenario.getName());
			File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
	            // Specify the path where you want to save the screenshot
	            FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+"/src/test/resources/ScreenShots/"+scenario.getName()+".jpg"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	

}
