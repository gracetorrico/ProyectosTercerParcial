Feature: Search sector on OrangeHRM
  Background: Search page into Orange HRM
    Given I am in Orange HRM Home web page

  Scenario: Edit user personal details
    Given I Search "Buzz" on search menu
    Then The option "Buzz" should be the only one
    And I logout
