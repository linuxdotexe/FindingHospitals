Feature: End to End happy flow execution

  @test
  Scenario Outline: Search Doctors
    Given user clicks on "<Navigation Item>"
    When user selects location as "<Location>"
    And user inputs "<Specialization>" in search
    And user selects "<Experience>" under Experience
    And user clicks on All filters
    And user selects: "<Fees>" under fees
    And user filters by patient stories: "<Patient Stories>"
    And user clicks on All filters
    And user selects: "<Availability>" under availability
    And user selects "<Sort>" under sort
    Then record top five doctor names

    Examples: 
      | Navigation Item | Specialization | Location | Patient Stories     | Experience             | Fees      | Availability    | Sort                                    |
      | Find Doctors    | Dentist        | Chennai  | 80+ Patient Stories | 5+ Years of experience | Above 500 | Available Today | Number of patient stories - High to low |

  @test
  Scenario: Extract surgeries
    Given user navigates to Surgeries from home page
    When extract surgeries listed under Popular Surgeries
    And display them in console output

  @regression @test
  Scenario Outline: verify form submission with correct details
    Given user navigates to Health and Wellness Plan page
    When user inputs "<Name>" in name
    And user inputs "<Organization>" in organization name
    And user inputs "<Contact Number>" in Contact Number
    And user inputs "<Invalid Email>" in Official Email ID
    And user selects Organization size: "<Organization Size>"
    And user selects "<Interested in>" in Interested in
    And verify Schedule a demo button is disabled
    And user inputs "<Valid Email>" in Official Email ID
    And user clicks Schedule a demo button
    Then capture thank you message

    Examples: 
      | Name      | Organization | Contact Number | Invalid Email | Valid Email      | Organization Size | Interested in |
      | Sai Nivas | DemoOrg      |     9876543210 | name@website  | name@website.com | <500              | Taking a demo |
