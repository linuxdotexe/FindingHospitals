package com.practo.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.practo.pageObjects.HomePage;
import com.practo.pageObjects.Search;
import com.practo.utils.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

	WebDriver driver = BaseClass.getDriver();
	HomePage hp = new HomePage(driver);
	Search sh = new Search(driver);
	
	int noOfDoctors;
	
	@Given("user selects location as {string}")
	public void user_selects_location_as(String location) {
		sh.searchForLocation(location);
	}

	@When("user inputs {string} in search")
	public void user_inputs_in_search(String specialization) {
		sh.searchForSpecialist(specialization);
	}
	
	@And("fetch the number of doctors displayed")
	public void fetch_the_number_of_doctors_displayed() {
		noOfDoctors = sh.numberOfDoctors();
	}

	@And("user filters by patient stories: {string}")
	public void user_filters_by_patient_stories(String stories) {
		sh.filterByPatientStories(stories);
	}

	@Then("verify the number of doctors is changed")
	public void verify_the_number_of_doctors_is_changed() {
		Assert.assertNotEquals(sh.numberOfDoctors(), noOfDoctors);
	}
	
	@And("user clicks on All filters")
	public void when_user_clicks_on_all_features() {
		sh.clickAllFilters();
	}
	
	@And("user selects: {string} under fees")
	public void user_selects_under_fees(String feeRange) {
		sh.selectFeeRange(feeRange);
	}
	
	@Then("verify if the listed doctors have the right fee requirement {string}")
	public void verify_if_the_listed_doctors_have_the_right_fee_requirement(String priceCheck) {
		Assert.assertTrue(sh.seperateAndVerifyDoctorFees(sh.doctorInfoCard, priceCheck));
		System.out.println(sh.doctorFee);
	}

}
