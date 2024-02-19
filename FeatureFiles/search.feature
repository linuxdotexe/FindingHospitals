Feature: Search

  @regression
  Scenario: Filter doctors by patient stories
    Given user navigates to search for doctors
    When user filters by patient stories: "<Stories Count>"
    Then verify the number of patient stories is above "<Count Check>"
    
    Examples:
      | Stories Count | Count Check |
      | 60+ stories   |          60 |

  @regression
  Scenario: Filter doctors by fees
    Given user navigates to search for doctors
    When user clicks on All filters
    And user selects: "<Fee range>" under fees
    Then verify if the listed doctors have a fee requirement under "<Price Check>"
    
    Examples:
      | Fee range | Price Check |
      | 0-500     |         500 |

  @regression
  Scenario: Filter doctors by fees
    Given user navigates to search for doctors
    When user clicks on All filters
    And user selects: "<Fee range>" under fees
    Then verify if the listed doctors have a fee requirement over "<Price Check>"
    
    Examples:
      | Fee range  | Price Check |
      | Above 500  |         500 |
      | Above 1000 |        1000 |
      | Above 2000 |        2000 |

  @regression
  Scenario: Filter doctors by availability
    Given user navigates to search for doctors
    When user clicks on All filters
    And user selects: "<Availability>" under availability
    Then verify if the availability displayed above book clinic visit matches "<Availability>"
    
    Examples:
      | Availability       |
      | Available Today    |
      | Available Tomorrow |

  @regression
  Scenario: Filter doctors by video consult availability
    Given user navigates to search for doctors
    When user clicks on All filters
    And user selects "Video Consult" under Consult type
    Then capture doctor names who are available only on video consultation

  @regression
  Scenario: Filter doctors location in "Chennai"
    Given user navigates to search for doctors
    When user selects location as chennai
    And user clicks Anna Nagar under location
    Then verify if Anna Nagar is selected: "<Message>"
    
    Examples:
      | Message                                                      |
      | You are seeing results from anna nagar. See results near you |

  @test
  Scenario: Search Doctors
    Given user searches for "<Search>" from the homepage
    When user selects location as "<Location>"
    And user selects "<Patient Stories>" under Patient Stories filter
    And user selects "<Experience>" under Experience filter
    And user selects "<Fees>" under Fees
    And user selects "<Availability>" under Availability filter
    And user selects "<Sort>" under sort
    Then record top five doctor names
    
    Examples:
      | Search  | Location | Patient Stories     | Experience             | Fees      | Availability    | Sort                                    |
      | Dentist | Chennai  | 80+ Patient Stories | 5+ Years of experience | Above 500 | Available Today | Number of patient stories - High to low |