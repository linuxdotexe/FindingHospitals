package com.practo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HealthAndWellness extends BasePage{

	public HealthAndWellness(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className="mweb-hide sticky_side_bar text-alpha u-text--bold")
	WebElement scheduleDemoNavButton;
	
	public void clickScheduleDemoNavButton() {
		scheduleDemoButton.click();
	}

	@FindBy(id="name")
	WebElement nameInputSchedule;

	@FindBy(id="organizationName")
	WebElement orgInputSchedule;

	@FindBy(id="contactNumber")
	WebElement contactInputSchedule;

	@FindBy(id="officialEmailId")
	WebElement emailInputSchedule;

	@FindBy(id="organizationSize")
	WebElement orgSizeSelectSchedule;

	@FindBy(id="interestedIn")
	WebElement interestedInSelectSchedule;
	
	@FindBy(xpath="//button[text()='Schedule a demo']")
	WebElement scheduleDemoButton;
	
	public void fillScheduleForm(String name, String orgName, String contact, String email, String orgSize, String interestedIn) {
		nameInputSchedule.sendKeys(name);
		orgInputSchedule.sendKeys(orgName);
		contactInputSchedule.sendKeys(contact);
		emailInputSchedule.sendKeys(email);
		
		Select orgSizeSelect = new Select(orgSizeSelectSchedule);
		orgSizeSelect.selectByVisibleText(orgSize);

		Select interestedInSelect = new Select(interestedInSelectSchedule);
		interestedInSelect.selectByVisibleText(interestedIn);
	}
	
	public Boolean isScheduleDemoButtonEnabled() {
		return scheduleDemoButton.isEnabled();
	}
	
	public void submitForm() {
		scheduleDemoButton.click();
	}
	
	@FindBy(xpath="//div[@aria-label='Thank you']/div/div")
	WebElement thankYouMessage;
	
	public String fetchThankYouMessage() {
		return thankYouMessage.getText();
	}

}
