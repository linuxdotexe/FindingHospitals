package com.practo.pageObjects;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HealthAndWellness extends BasePage{

	public HealthAndWellness(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[@class='mweb-hide sticky_side_bar text-alpha u-text--bold']")
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
	public WebElement scheduleDemoButton;
	
	public void fillName(String name) {
		nameInputSchedule.sendKeys(name);
	}

	public void fillOrganization(String orgName) {
		orgInputSchedule.sendKeys(orgName);
	}

	public void fillContact(String contact) {
		contactInputSchedule.sendKeys(contact);
	}
	
	public void fillEmail(String email) {
		emailInputSchedule.clear();
		emailInputSchedule.sendKeys(email);
	}
	
	public void selectOrgSize(String orgSize) {
		Select orgSizeSelect = new Select(orgSizeSelectSchedule);
		orgSizeSelect.selectByVisibleText(orgSize);
	}

	public void selectInterest(String interestedIn) {
		Select interestedInSelect = new Select(interestedInSelectSchedule);
		interestedInSelect.selectByVisibleText(interestedIn);
	}
	
	public Boolean isScheduleDemoButtonEnabled() {
		return scheduleDemoButton.isEnabled();
	}
	
	public void submitForm() {
		scheduleDemoButton.click();
	}
	
//	@FindBy(xpath="//div[@aria-label='Thank you']/div/div")
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[1]")
	WebElement thankYouMessage;
	
	public String fetchThankYouMessage() {
		if (thankYouMessage.isDisplayed() == false) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOf(thankYouMessage));
		}
		// NOTE: this is a cry for help.
		try {
			return thankYouMessage.getText();
		} catch (NoSuchElementException e) {
			try {
				Thread.sleep(10);
				System.out.println("i waited 10 more");
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return thankYouMessage.getText();
		}
	}

}
