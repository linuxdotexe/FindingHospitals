package com.practo.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Surgeries extends BasePage {

	public Surgeries(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@data-qa-id='city-selector-container']")
	WebElement cityDropdown;
	
	@FindBy(xpath="//div[@data-qa-id='city-name']/h1[text()='Bangalore']")
	WebElement cityBangalore;
	
	@FindBy(xpath="//div[@data-qa-id='city-name']/h1[text()='Chennai']")
	WebElement cityChennai;

	@FindBy(xpath="//div[@data-qa-id='ailment-selector-container']")
	WebElement ailmentDropdown;
	
	@FindBy(xpath="//div[contains(@class, 'text-12px')]/h1[text()='Carpal Tunnel Syndrome']")
	WebElement ailmentCarpelTunnel;

	@FindBy(xpath="//div[contains(@class, 'text-12px')]/h1[text()='ACL Repair']")
	WebElement ailmentACLRepair;
	
	@FindBy(id="Name-Gen-Lead-Form")
	WebElement nameInput;
	
	@FindBy(id="Phone-Gen-Lead-Form")
	WebElement contactNumberInput;
	
	@FindBy(xpath="//button[@data-qa-id='book-appointment-cta']")
	WebElement bookAppointmentButton;
	
	@FindBy(id="mobile_token")
	WebElement otpInput;
	
	@FindBy(xpath="//div[text()='Invalid User Name']")
	WebElement errorMessageName;

	@FindBy(xpath="//div[text()='Invalid Phone Number']")
	WebElement errorMessageContact;
	
	// TODO: check if this actually works
	@FindBy(xpath="//p[text()='Cataract']/parent::div")
	WebElement surgeryNameCataract;

	// TODO: check if this actually works
	@FindBy(xpath="//p[text()='Kidney Stone']/parent::div")
	WebElement surgeryNameKidneyStone;
	
	@FindBy(xpath="//p[contains(text(), 'Book an appointment for')")
	WebElement surgeriesFormMessage;
	
	@FindBy(id="Name-AIlment-Lead-Form")
	WebElement surgeriesFormNameInput;
	
	@FindBy(id="Phone-AIlment-Lead-Form")
	WebElement surgeriesFormPhoneInput;
	
	// TODO: check if this actually works
	@FindBy(xpath="//span[text()='City*']/parent::div")
	WebElement surgeriesFormCityDropdown;
	
	@FindBy(xpath="//button[text()='Book Appointment']")
	WebElement surgeriesBookAppointmentButton;
	
	// TODO: verify if you can use the existing XPaths
	@FindBy(xpath="//div[text()='Invalid User Name']")
	WebElement surgeriesErrorMessageName;
	
	@FindBy(xpath="//div[text()='Invalid Phone Number']")
	WebElement surgeriesErrorMessageContact;
	
	@FindBy(id="mobile_token")
	WebElement surgeriesOtpInput;
	
	public void selectCityFromDropdown(String city) {
		cityDropdown.click();
		if (city.equals("Bangalore")) {
			cityBangalore.click();
		}
		else {
			cityChennai.click();
		}
	}
	
	public void selectAilmentFromDropdown(String ailment) {
		ailmentDropdown.click();
		if (ailment.equals("Carpal Tunnel Syndrome")) {
			ailmentCarpelTunnel.click();
		}
		else {
			ailmentACLRepair.click();
		}
	}
	
	public void nameInputSurgeriesForm(String name) {
		nameInput.sendKeys(name);
	}
	
	public void contactInputSurgeriesForm(String contact) {
		contactNumberInput.sendKeys(contact);
	}
	
	public void bookAppointment() {
		bookAppointmentButton.click();
	}
	
	public String getOtpPlaceholder() {
		return otpInput.getAttribute("placeholder");
	}
	
	public String getNameErrorMessage() {
		return errorMessageName.getText();
	}
	
	public String getContactErrorMessage() {
		return errorMessageContact.getText();
	}
	
	public void clickSurgery(String surgeryName) {
		if (surgeryName.equals("Cataract")) {
			surgeryNameCataract.click();
		}
		else {
			surgeryNameKidneyStone.click();
		}
	}

	public String returnSurgeriesFormMessage() {
		return surgeriesFormMessage.getText();
	}
	
	public void fillSurgeriesForm(String name, String contact) {
		surgeriesFormNameInput.sendKeys(name);
		surgeriesFormPhoneInput.sendKeys(contact);
		surgeriesFormCityDropdown.click();
		cityBangalore.click();
		surgeriesBookAppointmentButton.click();
	}

}
