Feature: Search

  @regression
  Scenario: Filter doctors by patient stories
    Given user opens practo
    And user navigates to search for doctors
    When user filters by patient stories: "60+ stories"
    Then verify the number of patient stories is above 60

  @regression
  Scenario: Filter doctors by fees
    Given user opens practo
    And user navigates to search for doctors
    When user clicks on All filters
    And user selects: "0-500" under fees
    Then verify if the listed doctors have a fee requirement under 500

  @regression
  Scenario: Filter doctors by fees
    Given user opens practo
    And user navigates to search for doctors
    When user clicks on All filters
    And user selects: <Fee range> under fees
    Then verify if the listed doctors have a fee requirement over <Price Check>
      | Fee range  | Price Check |
      | Above 500  |         500 |
      | Above 1000 |        1000 |
      | Above 2000 |        2000 |

  @regression
  Scenario: Filter doctors by availability
    Given user opens practo
    And user navigates to search for doctors
    When user clicks on All filters
    And user selects: <Availability> under availability
    Then verify if the availability displayed above book clinic visit matches <Availability>
      | Availability       |
      | Available Today    |
      | Available Tomorrow |
