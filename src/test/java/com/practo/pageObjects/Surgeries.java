package com.practo.pageObjects;

import java.util.List;

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
	
	@FindBy(xpath="//*[@id=\"__next\"]/main/div/div[7]/div/div/div[2]/div/div[2]/div/div/div[6]/div[1]/h1")
	WebElement cityBangaloreSurgeries;
	
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
	
	@FindBy(className="mobile-text-preview")
	WebElement mobileNumberVerification;
	
	@FindBy(xpath="//iframe[@data-qa-id='otp-modal-iframe']")
	WebElement frame;
	
	@FindBy(xpath="//div[text()='Invalid User Name']")
	WebElement errorMessageName;

	@FindBy(xpath="//div[text()='Invalid Phone Number']")
	WebElement errorMessageContact;
	
	@FindBy(xpath="//p[text()='Cataract']/parent::div")
	WebElement surgeryNameCataract;

	@FindBy(xpath="//p[text()='Kidney Stone']/parent::div")
	WebElement surgeryNameKidneyStone;
	
	@FindBy(xpath="//p[contains(text(), 'Book an appointment for')]")
	WebElement surgeriesFormMessage;
	
	@FindBy(id="Name-AIlment-Lead-Form")
	WebElement surgeriesFormNameInput;
	
	@FindBy(id="Phone-AIlment-Lead-Form")
	WebElement surgeriesFormPhoneInput;
	
	// TODO: check if this actually works
	@FindBy(xpath="//span[text()='City*']/parent::div")
	WebElement surgeriesFormCityDropdown;
	
	@FindBy(xpath="//button[text()='Book Appointment' and @class='ailmentLeadForm-module_submit-cta__oKug8']")
	WebElement surgeriesBookAppointmentButton;
	
	// TODO: verify if you can use the existing XPaths
	@FindBy(xpath="//div[text()='Invalid User Name']")
	WebElement surgeriesErrorMessageName;
	
	@FindBy(xpath="//div[text()='Invalid Phone Number']")
	WebElement surgeriesErrorMessageContact;
	
	@FindBy(id="mobile_token")
	WebElement surgeriesOtpInput;
	
	@FindBy(xpath="//p[@data-qa-id='surgical-solution-ailment-name']")
	List<WebElement> popularSurgeries;
	
	public void outputPopularSurgeries() {
		for (WebElement ailmentName : popularSurgeries) {
			System.out.println(ailmentName.getText());
		}
		System.out.println("Total Count of Popular Surgeries: " + popularSurgeries.size());
	}
	
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
	
	public String verifyMobileNumber() {
		driver.switchTo().frame(frame);
		return mobileNumberVerification.getText();
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
	
	public void fillSurgeryName(String name) {
		surgeriesFormNameInput.sendKeys(name);
	}

	public void fillSurgeryContact(String contact) {
		surgeriesFormPhoneInput.sendKeys(contact);
	}

	public void selectCitySurgeryForm(String city) {
		surgeriesFormCityDropdown.click();
		if (city.equals("Bangalore")) {
			cityBangaloreSurgeries.click();
		}
	}

	public void submitSurgeryForm() {
		surgeriesBookAppointmentButton.click();
	}

}
