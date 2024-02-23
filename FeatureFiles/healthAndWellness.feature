Feature: Health and Wellness

  @sanity
  Scenario: verify Schedule a demo button navigation
    Given user navigates to Health and Wellness Plan page
    When user scrolls down to the bottom of the page
    And user clicks the Schedule a demo button
    Then verify the page is scrolled up to the top

  @smoke
  Scenario Outline: verify if submit button disabled with incorrect details
    Given user navigates to Health and Wellness Plan page
    When user inputs "<Name>" in name
    And user inputs "<Organization>" in organization name
    And user inputs "<Contact Number>" in Contact Number
    And user inputs "<Email>" in Official Email ID
    And user selects Organization size: "<Organization Size>"
    And user selects "<Interested in>" in Interested in
    Then verify Schedule a demo button is disabled

    Examples: 
      | Name      | Organization | Contact Number | Email            | Organization Size | Interested in |
      | Sai       | DemoOrg      |          86420 | name@website.com | 1001-5000         | Taking a demo |
      | Nivas     | DemoOrg      |     9876543310 | name@website     | <500              | Taking a demo |
      | Venkata   | DemoOrg      |     9876544210 | name@website.co  |                   | Taking a demo |
      | Sai Nivas | DemoOrg      |     9876553210 | name@site.com    | 5001-10000        |               |

  @smoke
  Scenario Outline: verify if submit button enabled with correct details
    Given user navigates to Health and Wellness Plan page
    When user inputs "<Name>" in name
    And user inputs "<Organization>" in organization name
    And user inputs "<Contact Number>" in Contact Number
    And user inputs "<Email>" in Official Email ID
    And user selects Organization size: "<Organization Size>"
    And user selects "<Interested in>" in Interested in
    Then verify Schedule a demo button is enabled

    Examples: 
      | Name      | Organization | Contact Number | Email            | Organization Size | Interested in |
      | Sai Nivas | DemoOrg      |     9876543210 | name@website.com | 501-1000          | Taking a demo |
