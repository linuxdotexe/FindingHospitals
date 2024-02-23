package com.practo.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search extends BasePage{

	public Search(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-keyword']")
	WebElement inputSpecialist;
	
	@FindBy(xpath="//div[@data-qa-id='omni-suggestion-main']")
	WebElement specializationSearchFirstSuggestion;
	
	@FindBy(xpath="//span[@data-qa-id='others-speciality']")
	WebElement otherSpecializations;
	
	@FindBy(xpath="//p[@class='test-name' and text()='Dentist']")
	WebElement dentistOtherSpecializations;
	
	public void searchForSpecialist(String specialization) {
		try {
			if (inputSpecialist.getAttribute("value").equals(specialization)) {
				// do nothing
			} else {
				System.out.println(inputSpecialist.getAttribute("value"));
				inputSpecialist.clear();
				inputSpecialist.sendKeys(specialization);
				Thread.sleep(5000);
				if (specializationSearchFirstSuggestion.isDisplayed()) {
					wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(specializationSearchFirstSuggestion)));
					js.executeScript("arguments[0].click()", specializationSearchFirstSuggestion);
				}
			}
		} catch (Exception e) {
			otherSpecializations.click();
			dentistOtherSpecializations.click();
		}
	}
	
	@FindBy(xpath="//input[@data-qa-id='omni-searchbox-locality']") 
	WebElement inputLocation;
	
	@FindBy(xpath="//div[@data-qa-id='omni-suggestion-main' and text()='Chennai']")
	WebElement inputConfirmation;
	
	public void searchForLocation (String location) {
		if (inputLocation.getAttribute("value").equals(location)) {
			// do nothing. we have the location already.
		} else {
			inputLocation.clear();
			inputLocation.sendKeys(location);
			if (inputConfirmation.isDisplayed()) {
				try {
					inputConfirmation.click();
				} catch (StaleElementReferenceException e) {}
			}
		}
	}

	@FindBy(xpath="//div[@data-qa-id='doctor_review_count_section']")
	WebElement patientStoriesDropdown;
	
	@FindBy(xpath="//ul[@data-qa-id='doctor_review_count_list']/li[@class='c-dropdown__list__item']")
	List<WebElement> patientStoriesCountSelector;
	
	@FindBy(xpath="//h1")
	WebElement numberOfDoctors;
	
	public void filterByPatientStories(String numberOfStories) {
		patientStoriesDropdown.click();
		patientStoriesCountSelector.get(1).click();
	}
	
	public int numberOfDoctors() {
		// TODO: try removing sleep
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(numberOfDoctors.getText().split("\\s+")[0]);
	}
	
	@FindBy(xpath="//*[@class='u-d-inlineblock u-color--white u-c-pointer']")
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
	
	public void clickAllFilters() {
		allFiltersDropdown.click();
	}
	
	public void selectFeeRange(String feeRange) {
		if (feeRange.equals("0-500")) {
			feesBelow500RadioButton.click();
		}
		else if (feeRange.equals("Above 500")) {
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(feesAbove500RadioButton)));
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
		for (int i = 0; i < 5; i++) {
			int fee = Integer.parseInt(feesVerification.get(i).getText().replace("₹", ""));
			if (fee > priceCheck) {
				count += 1;
			}
		}
		if (count == 5) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@FindBy(xpath="//div[@data-qa-id='doctor_card']//div[@class='info-section']")
	public List<WebElement> doctorInfoCard;
	
	List<String> doctorName = new ArrayList<String>();
	List<String> doctorSpecialization = new ArrayList<String>();
	List<String> doctorExperience = new ArrayList<String>();
	List<String> doctorLocation = new ArrayList<String>();
	List<String> doctorFee = new ArrayList<String>();
	
	public void outputDoctorNames() {
		for (int i = 0; i < 5; i++) {
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(doctorInfoCard.get(i))));
			doctorName.add(doctorInfoCard.get(i).getText().split("\\n+")[0]);
			doctorSpecialization.add(doctorInfoCard.get(i).getText().split("\\n+")[1]);
			doctorExperience.add(doctorInfoCard.get(i).getText().split("\\n+")[2]);
			doctorLocation.add(doctorInfoCard.get(i).getText().split("\\n+")[3]);
			doctorFee.add(doctorInfoCard.get(i).getText().split("\\n+")[4]);
		}
		System.out.println(doctorName);
		System.out.println(doctorSpecialization);
		System.out.println(doctorExperience);
		System.out.println(doctorLocation);
		System.out.println(doctorFee);
	}
	
	public Boolean seperateAndVerifyDoctorFees(List<WebElement> infoCard, String condition) {
		for (int i = 0; i < 5; i++) {
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(infoCard.get(i))));
			doctorFee.add(infoCard.get(i).getText().split("\\n+")[4].replaceAll("[^0-9]", ""));
		}
		
		Boolean result = false;
		
		for (String fee : doctorFee) {
			if (condition.equals("0-500")) {
				if (Integer.parseInt(fee) <= 500) {
					result = true;
				}
			} 
			else if (condition.equals("Above 500")) {
				if (Integer.parseInt(fee) >= 500) {
					result = true;
				}
			}
		}
		
		return result;
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
		Boolean result = false;
		for (int i = 0; i < 5; i++) {
			String buttonText = verifyAvailability.get(i).getText();
			if (buttonText.equals(availability)) {
				result = true;
			}
		}
		return result;
	}

	@FindBy(xpath="//label[@for='Consult-type0']")
	WebElement videoConsultRadioButton;
	
	@FindBy(xpath="//button[@data-qa-id='consult_cta']")
	List<WebElement> verifyVideoConsultAvailability;
	
	public void selectVideoConsult() {
		videoConsultRadioButton.click();
	}
	
	public Boolean verifyVideoConsult() {
		Boolean result = false;
		for (int i = 0; i < verifyVideoConsultAvailability.size(); i++) {
			if (verifyVideoConsultAvailability.get(i).isDisplayed()) {
				result = true;
			}
		}
		return result;
	}
	
	@FindBy(xpath="//button[text()='anna nagar']")
	WebElement clickLocation;
	
	@FindBy(xpath="//*[@class='u-grey_3-text uv2-spacer--xs-top']")
	WebElement verifyLocation;
	
	public void selectLocation(String location) {
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
	
	@FindBy(xpath="//div[@data-qa-id='years_of_experience_section']")
	WebElement experienceDropdown;

	@FindBy(xpath="//li[@aria-label='5+ Years of experience']")
	WebElement experienceFivePlus;
	
	public void selectExperience(String experience) {
		experienceDropdown.click();
		if (experience.equalsIgnoreCase("5+ Years of experience")) {
			experienceFivePlus.click();
		}
	}
	
	@FindBy(xpath="//div[@data-qa-id='sort_by_section']")
	WebElement sortDropdown;
	
	@FindBy(xpath="//li[@data-qa-id='doctor_review_count']")
	WebElement sortSelect;
	
	public void selectSort(String sort) {
		sortDropdown.click();
		if (sort.equals("Number of patient stories - High to low")) {
			sortSelect.click();
		}
	}
	
}
