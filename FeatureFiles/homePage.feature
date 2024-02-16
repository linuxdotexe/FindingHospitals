Feature: Home Page

  @smoke
  Scenario: Verify navigation items
    Given user opens practo
    When user clicks on <Navigation Item>
    Then verify page title <Page Title>
      | Navigation Item | Page Title                                                                                   |
      | Find Doctors    | Practo \| Book Doctor Appointments Online, Order Medicine, Diagnostic Tests, Consult         |
      | Video Consult   | Online Doctor Consultation \| Ask Top Doctor's Advice 24*7 \| Practo                         |
      | Medicines       | Buy Medicines,Health Products Online \| India's Most Reliable Online Medical Store \| Practo |
      | Surgeries       | Practo Care Surgeries \| End to end care from top surgeons in your city                      |

  @smoke
  Scenario: Verify Lab Tests navigation
    Given user opens practo
    When user clicks on: <Navigation Item>
    Then click on selected city: <City>
    Then verify page title: <Page Title>
      | Navigation Item | City      | Page Title                                                              |
      | Lab Tests       | Bangalore | Blood Tests \| Book Diagnostic Tests from Home at Best Prices \| Practo |
