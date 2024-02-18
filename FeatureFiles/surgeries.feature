Feature: Surgeries

  @smoke
  Scenario: Verify consultation form submission with correct details
    Given user navigates to Surgeries from home page
    When user selects "<City>" from the city dropdown
    And user selects "<Ailment>" from the ailment dropdown
    And user inputs "<Name>" in name
    And user inputs "<Contact Number>" in Contact Number
    And click Book Appointment button
    Then capture otp input box placeholder text
    
    Examples:
      | City      | Ailment                | Contact Number | Name  |
      | Bangalore | Carpal Tunnel Syndrome |     8897732030 | Sai   |
      | Chennai   | ACL Repair             |     8897732030 | Nivas |

  @smoke
  Scenario: Verify consultation form submission with wrong name
    Given user navigates to Surgeries from home page
    When user selects "<City>" from the city dropdown
    And user selects "<Ailment>" from the ailment dropdown
    And user inputs "<Contact Number>" in contact number
    And user inputs "<Name>" in name
    Then capture error message displayed below name
    
    Examples:
      | City    | Ailment    | Contact Number | Name |
      | Chennai | ACL Repair |     8123123123 | Ni   |

  @smoke
  Scenario: Verify consultation form submission with wrong contact number
    Given user navigates to Surgeries from home page
    When user selects "<City>" from the city dropdown
    And user selects "<Ailment>" from the ailment dropdown
    And user inputs "<Contact Number>" in contact number
    And user inputs "<Name>" in name
    Then capture error message displayed below contact number
    
    Examples:
      | City      | Ailment                | Contact Number | Name  |
      | Bangalore | Carpal Tunnel Syndrome |     1231231231 | Sai   |
      | Chennai   | Carpal Tunnel Syndrome |      898989898 | Nivas |

  @smoke
  Scenario: Verify consultation form submission with wrong name and contact number
    Given user navigates to Surgeries from home page
    When user selects "<City>" from the city dropdown
    And user selects "<Ailment>" from the ailment dropdown
    And user inputs "<Contact Number>" in contact number
    And user inputs "<Name>" in name
    Then capture error message displayed below name and contact number
    
    Examples:
      | City      | Ailment                | Contact Number | Name |
      | Bangalore | Carpal Tunnel Syndrome |     1231231231 | Sa   |
      | Chennai   | Carpal Tunnel Syndrome |      898989898 | Ni   |

  @regression
  Scenario: Verify surgeries form popup message
    Given user navigates to Surgeries from home page
    When user clicks on "<Surgery Name>" under Popular Surgeries
    Then verify the message displayed above the form
    
    Examples:
      | Surgery Name |
      | Cataract     |
      | Kidney Stone |

  @regression
  Scenario: Verify surgeries form submission with correct details
    Given user navigates to Surgeries from home page
    When user clicks on "<Surgery Name>" under Popular Surgeries
    And enter "<Name>" in name
    And enter "<Contact Number>" in contact number
    And select "<City>" in the city dropdown
    Then capture otp input box placeholder text
    
    Examples:
      | Surgery Name | Name | Contact Number | City      |
      | Cataract     | Sai  |     9879879877 | Bangalore |

  @regression
  Scenario: Verify surgeries form submission with incorrect details
    Given user navigates to Surgeries from home page
    When user clicks on "<Surgery Name>" under Popular Surgeries
    And enter "<Name>" in name
    And enter "<Contact Number>" in contact number
    And select "<City>" in the city dropdown
    Then capture error message below name and contact input box
    
    Examples:
      | Surgery Name | Name | Contact Number | City      |
      | Cataract     | Sa   |       98798798 | Bangalore |