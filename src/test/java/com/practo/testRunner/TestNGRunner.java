package com.practo.testRunner;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.practo.utils.BaseClass;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//FeatureFiles/"}, 
		glue = "com.practo.stepDefinitions", 
		plugin = {"pretty","html:reports/report.html","rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun=false,
		monochrome=true
		)
public class TestNGRunner extends AbstractTestNGCucumberTests{
	static WebDriver driver;
	static Properties p;
	
	@BeforeMethod
	@Parameters("browser")
	public static void setup(String browser) throws IOException{
		driver = BaseClass.initializeBrowser(browser);		
		p = BaseClass.getProperties();
		driver.manage().window().maximize();
		driver.get(p.getProperty("appUrl"));
	}
	
	@AfterMethod
	public static void tearDown() {
		driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		// TODO: hooks from session 9
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

