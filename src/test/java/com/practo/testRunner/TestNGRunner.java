package com.practo.testRunner;

import java.io.IOException;
import java.util.Properties;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.practo.utils.DriverSetup;

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
		driver = DriverSetup.initializeBrowser(browser);		
		p = DriverSetup.getProperties();
		driver.manage().window().maximize();
		driver.get(p.getProperty("appUrl"));
	}
	
	@AfterMethod
	public static void tearDown(Scenario scenario) {
		driver.quit();
	}
	
}

