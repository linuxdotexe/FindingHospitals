Feature: Hospitals with 24x7 service, rating above 3.5 and parking.

  @test
  Scenario: 
    Given user opens practo
    When user searches for hospital
    Then search for hospital that is open "<Timings>"
    And hospital that has a rating over "<Rating>"
    Then check if hospital has the parking amenity
    And record hospital name
    
    Examples:
      | Timings                     | Rating |
      | MON - SUN 00:00AM - 11:59PM |    3.5 |
