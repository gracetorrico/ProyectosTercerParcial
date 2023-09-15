Feature: Edit MyInfo on OrangeHRM
  Background: Edit user info into Orange HRM
    Given I am in Orange HRM Home web page

    @EditPersonalDetails
    Scenario: Edit user personal details
      Given I click on My Info button
      And My Info page is displayed
      When I click on Personal Details button
      Then I change Middle Name to "Benjamin"
      And I change Drivers License number to "34650211"
      And I click on Save button
      Then A success message should be displayed
      And I logout

  @EditContactInfo
  Scenario: Edit user contact details
    Given I click on My Info button
    And My Info page is displayed
    When I click on Contact Details button
    ##Then I change mobile number to "568924214"
    Then I change mobile number to "00000"
    And I change second email to "testing@orange.hrm"
    And I click on Save Contact button
    Then A success message should be displayed
    And I logout

