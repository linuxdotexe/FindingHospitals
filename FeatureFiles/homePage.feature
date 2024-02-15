Feature: Home Page

  @smoke
  Scenario: Verify navigation item: "Find Doctors"
    Given user opens practo
    When user clicks on: "Find Doctors"
    Then verify page title: "Practo | Book Doctor Appointments Online, Order Medicine, Diagnostic Tests, Consult"
    And take screenshot
    
  @smoke
  Scenario: Verify navigation item: "Video Consult"
    Given user opens practo
    When user clicks on: "Video Consult"
    Then verify page title: "Online Doctor Consultation | Ask Top Doctor's Advice 24*7 | Practo"
    And take screenshot

  @smoke
  Scenario: Verify navigation item: "Medicines"
    Given user opens practo
    When user clicks on: "Medicines"
    Then verify page title: "Buy Medicines,Health Products Online | India's Most Reliable Online Medical Store | Practo"
    And take screenshot

  @smoke
  Scenario: Verify navigation item: "Lab Tests"
    Given user opens practo
    When user clicks on: "Lab Tests"
    Then click on selected city: "Bangalore"
    Then verify page title: "Blood Tests | Book Diagnostic Tests from Home at Best Prices | Practo"
    And take screenshot

  @smoke
  Scenario: Verify navigation item: "Surgeries"
    Given user opens practo
    When user clicks on: "Surgeries"
    Then verify page title: "Practo Care Surgeries | End to end care from top surgeons in your city"
    And take screenshot
