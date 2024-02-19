package com.practo.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends BasePage{

	public Search(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[text()='Search for doctors']/parent::a")
	WebElement searchForDoctors;
	
	@FindBy(xpath="//div[@data-qa-id='doctor_review_count_section']")
	WebElement patientStoriesDropdown;
	
	@FindBy(xpath="//li[@data-qa-id='60,9999999']")
	WebElement above60PatientStories;
	
	@FindBy(xpath="//span[@data-qa-id='total_feedback']")
	List<WebElement> reviewCounts;
	
	public void navigateToSearchDoctors() {
		searchForDoctors.click();
	}
	
	public void filterByPatientStories() {
		patientStoriesDropdown.click();
		above60PatientStories.click();
	}
	
	public Boolean verifyStoryCount(int requiredCount) {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			int reviewNumber =Integer.parseInt(reviewCounts.get(i).getText().replace("Patient Stories", ""));
			if (reviewNumber > requiredCount) {
				count += 1;
			}
		}
		if (count == 10) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@FindBy(className="u-d-inlineblock u-color--white u-c-pointer")
	WebElement allFiltersDropdown;
	
	@FindBy(xpath="//label[@for='Fees0']")
	WebElement feesBelow500RadioButton;
	
	@FindBy(xpath="//label[@for='Fees1']")
	WebElement feesAbove500RadioButton;

	@FindBy(xpath="//label[@for='Fees2']")
	WebElement feesAbove1000RadioButton;

	@FindBy(xpath="//label[@for='Fees3']")
	WebElement feesAbove2000RadioButton;
	
	@FindBy(xpath="//span[@data-qa-id='consultation_fee']")
	List<WebElement> feesVerification;
	
	public void selectFeeRange(String feeRange) {
		allFiltersDropdown.click();
		
		if (feeRange.equals("0-500")) {
			feesBelow500RadioButton.click();
		}
		else if (feeRange.equals("Above 500")) {
			feesAbove500RadioButton.click();
		}
		else if (feeRange.equals("Above 1000")) {
			feesAbove1000RadioButton.click();
		}
		else if (feeRange.equals("Above 2000")) {
			feesAbove2000RadioButton.click();
		}
	}
	
	public Boolean verifyFees(int priceCheck) {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			int fee =Integer.parseInt(feesVerification.get(i).getText().replace("₹", ""));
			if (fee > priceCheck) {
				count += 1;
			}
		}
		if (count == 10) {
			return true;
		}
		else {
			return false;
		}
	}

	@FindBy(xpath="//label[@for='Availability1']")
	WebElement availableTodayRadioButton;
	
	@FindBy(xpath="//label[@for='Availability2']")
	WebElement availableTomorrowRadioButton;
	
	@FindBy(xpath="//span[@data-qa-id='availability_text']")
	List<WebElement> verifyAvailability;
	
	public void selectAvailability(String availability) {
		if(availability.equals("Available Today")) {
			availableTodayRadioButton.click();
		}
		else {
			availableTomorrowRadioButton.click();
		}
	}
	
	public Boolean verifyAvailability(String availability) {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			String buttonText = verifyAvailability.get(i).getText();
			if (buttonText.equals(availability)) {
				count += 1;
			}
		}
		if (count == 10) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@FindBy(xpath="//label[@for='Consult-type0']")
	WebElement videoConsultRadioButton;
	
	@FindBy(xpath="//button[@data-qa-id='consult_cta']")
	List<WebElement> verifyVideoConsultAvailability;
	
	public void selectVideoConsult() {
		videoConsultRadioButton.click();
	}
	
	public Boolean verifyVideoConsult() {
		int count = 0;
		for (int i = 0; i < 10; i++) {
			if (verifyVideoConsultAvailability.get(i).isDisplayed()) {
				count += 1;
			}
		}
		if (count == 10) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-locality']")
	WebElement locationPopUp;
	
	@FindBy(xpath="//input[@data-qa-id='omni-suggestion-main']")
	WebElement locationSelection;
	
	@FindBy(xpath="//button[text()='anna nagar']")
	WebElement clickLocation;
	
	@FindBy(className="u-grey_3-text uv2-spacer--xs-top")
	WebElement verifyLocation;
	
	public void selectLocation(String location) {
		locationPopUp.sendKeys(location);
		locationSelection.click();
		clickLocation.click();
	}
	
	public Boolean locationVerification(String location) {
		if (verifyLocation.getText().contains(location)) {
			return true;
		}
		else {
			return false;
		}
	}
}
