Feature: Search

  @regression
  Scenario: Filter doctors by patient stories
    Given user opens practo
    And user navigates to search for doctors
    When user filters by patient stories: "60+ stories"
    Then verify the results
    
  @regression
  Scenario: Filter doctors by fees
    Given user opens practo
    And user navigates to search for doctors
    When user clicks on All filters
    And user selects: "0-500" under fees
    Then verify the results

  @regression
  Scenario: Filter doctors by fees
    Given user opens practo
    And user navigates to search for doctors
    When user clicks on All filters
    And user selects: "Above 500" under fees
    Then verify the results

  @regression
  Scenario: Filter doctors by fees
    Given user opens practo
    And user navigates to search for doctors
    When user clicks on All filters
    And user selects: "Above 1000" under fees
    Then verify the results

  @regression
  Scenario: Filter doctors by fees
    Given user opens practo
    And user navigates to search for doctors
    When user clicks on All filters
    And user selects: "Above 2000" under fees
    Then verify the results
    
  @regression
  Scenario: Filter doctors by availability
    Given user opens practo
    And user navigates to search for doctors
    When user clicks on All filters
    And user selects: "Available in next 4 hours" under availability
    Then verify the results

  @regression
  Scenario: Filter doctors by availability
    Given user opens practo
    And user navigates to search for doctors
    When user clicks on All filters
    And user selects: "Available Today" under availability
    Then verify the results

  @regression
  Scenario: Filter doctors by availability
    Given user opens practo
    And user navigates to search for doctors
    When user clicks on All filters
    And user selects: "Available Tomorrow" under availability
    Then verify the results