package com.practo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// TODO: find out if you can pass vars in the xpath
	
	@FindBy(xpath="//div[text()='Find Doctors']")
	WebElement findDoctorsNavElement;
	
	@FindBy(xpath="//div[text()='Video Consult']")
	WebElement videoConsultNavElement;
	
	@FindBy(xpath="//div[text()='Medicines']")
	WebElement medicinesNavElement;
	
	@FindBy(xpath="//div[text()='Lab Tests']")
	WebElement labTestsNavElement;
	
	@FindBy(xpath="//div[text()='Surgeries']")
	WebElement surgeriesNavElement;
	
	public void visitNavLinks(String linkName) {
		if (linkName.equals("Find Doctors")) {
			findDoctorsNavElement.click();
		}
		else if (linkName.equals("Video Consult")) {
			videoConsultNavElement.click();
		}
		else if (linkName.equals("Medicines")) {
			medicinesNavElement.click();
		}
		else if (linkName.equals("Lab Tests")) {
			labTestsNavElement.click();
		}
		else if (linkName.equals("Surgeries")) {
			surgeriesNavElement.click();
		}
	}

	@FindBy(xpath="//span[text()='For Corporates']/ancestor::div[@tabindex='0']")
	WebElement forCorporatesDropdown;
	
	@FindBy(linkText="Health & Wellness Plans")
	WebElement healthWellnessButton;
	
	public void navigateToHealthWellness() {
		forCorporatesDropdown.click();
		healthWellnessButton.click();
	}
	
}
