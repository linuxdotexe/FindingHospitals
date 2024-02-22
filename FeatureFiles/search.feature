Feature: Search

  @regression
  Scenario: Filter doctors by patient stories
    Given user selects location as "<Location>"
    When user inputs "<Specialization>" in search
    And fetch the number of doctors displayed
    And user filters by patient stories: "<Stories Count>"
    Then verify the number of doctors is changed
    
    Examples:
      | Stories Count 				| Location | Specialization |
      | 80+ Patient Stories   | Chennai  | Dentist        |

  @regression
  Scenario: Filter doctors by fees
    Given user selects location as "<Location>"
    When user inputs "<Specialization>" in search
    And user clicks on All filters
    And user selects: "<Fee range>" under fees
    Then verify if the listed doctors have the right fee requirement "<Fee range>"
    
    Examples:
      | Fee range  | Location | Specialization |
      | 0-500      | Chennai	| Dentist				 |
      | Above 500  | Chennai	| Dentist				 |

  @regression
  Scenario: Filter doctors by availability
    Given user selects location as "<Location>"
    When user inputs "<Specialization>" in search
    And user clicks on All filters
    And user selects: "<Availability>" under availability
    Then verify if the availability displayed above book clinic visit matches "<Availability>"
    
    Examples:
      | Availability       | Location | Specialization |
      | Available Today    | Chennai 	| Dentist				 |
      | Available Tomorrow | Chennai 	| Dentist				 |

  @regression
  Scenario: Filter doctors by video consult availability
    Given user selects location as "<Location>"
    When user inputs "<Specialization>" in search
    And user clicks on All filters
    And user selects "<Consult type>" under Consult type
    Then verify if results displayed are of video consult

    Examples:
      | Consult type  | Location | Specialization |
      | Video Consult | Chennai  | Dentist				|

  @regression
  Scenario: Filter doctors location in Chennai
    Given user selects location as "<Location>"
    When user inputs "<Specialization>" in search
    And user clicks "<Area>" under location
    Then verify if the area is selected: "<Message>"
    
    Examples:
      | Location | Specialization | Area 			 | Message                                                      |
      | Chennai  | Dentist        | Anna Nagar | You are seeing results from anna nagar. See results near you |

  @test
  Scenario: Search Doctors
    Given user selects location as "<Location>"
    When user inputs "<Specialization>" in search
    And user selects "<Experience>" under Experience
    And user clicks on All filters
    And user selects: "<Fees>" under fees
    And user clicks on All filters
    And user filters by patient stories: "<Patient Stories>"
    And user selects: "<Availability>" under availability
    And user selects "<Sort>" under sort
    Then record top five doctor names
    
    Examples:
      | Specialization  | Location | Patient Stories     | Experience             | Fees      | Availability    | Sort                                    |
      | Dentist 				| Chennai  | 80+ Patient Stories | 5+ Years of experience | Above 500 | Available Today | Number of patient stories - High to low |