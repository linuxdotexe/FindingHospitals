Feature: Health and Wellness

  @smoke
  Scenario: verify page title
    Given user opens practo
    When user clicks on For Corporates
    And user clicks on Health and Wellness Plan
    Then verify the browser navigates to the right page

  @smoke
  Scenario: verify form submission with correct details
    Given user opens practo
    And user clicks on For Corporates
    And user clicks on Health and Wellness Plan
    When user inputs "Sai Nivas" in name
    And user inputs "Cognizant" in organization name
    And user inputs "9876543210" in Contact Number
    And user inputs "name@website.com" in Official Email ID
    And user selects Organization size: "<500"
    And user selects "Taking a demo" in Interested in
    Then verify Schedule a demo button is enabled
    
  @smoke
  Scenario: verify form submission with incorrect details
    Given user opens practo
    And user clicks on For Corporates
    And user clicks on Health and Wellness Plan
    When user inputs "Sai Nivas" in name
    And user inputs "Cognizant" in organization name
    And user inputs "86420" in Contact Number
    And user inputs "name@website" in Official Email ID
    And user selects Organization size: "<500"
    And user selects "Taking a demo" in Interested in
    Then verify Schedule a demo button is disabled
    And capture error styling
    
  @smoke
  Scenario: verify form submission with correct details
    Given user opens practo
    And user clicks on For Corporates
    And user clicks on Health and Wellness Plan
    When user inputs "Sai Nivas" in name
    And user inputs "Cognizant" in organization name
    And user inputs "9876543210" in Contact Number
    And user inputs "name@website.com" in Official Email ID
    And user selects Organization size: "<500"
    And user selects "Taking a demo" in Interested in
    And click Schedule a demo button
    Then verify the form is submitted

  @smoke
  Scenario: verify Schedule a demo button navigation
    Given user opens practo
    When user clicks on For Corporates
    And user clicks on Health and Wellness Plan
    When scroll down until Schedule a demo navigation helper is visible
    And click the Schedule a demo button
    Then verify the page is scrolled up to the top
    
  @smoke
  Scenario: verify form submission with correct details
    Given user opens practo
    And user clicks on For Corporates
    And user clicks on Health and Wellness Plan
    When user inputs "Sai Nivas" in name
    And user inputs "Cognizant" in organization name
    And user inputs "9876543210" in Contact Number
    And user inputs "name@website.com" in Official Email ID
    But user does not select Organization size
    And user selects "Taking a demo" in Interested in
    Then verify Schedule a demo button is disabled

  @smoke
  Scenario: verify form submission with correct details
    Given user opens practo
    And user clicks on For Corporates
    And user clicks on Health and Wellness Plan
    When user inputs "Sai Nivas" in name
    And user inputs "Cognizant" in organization name
    And user inputs "9876543210" in Contact Number
    And user inputs "name@website.com" in Official Email ID
    And user selects Organization size: "<500"
    But user does not select Interested in
    Then verify Schedule a demo button is disabled