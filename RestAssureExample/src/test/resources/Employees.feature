Feature: Employees endpoint
  Background: Employees endpoints should allow to get, create, update and delete employees

  @getAll
  Scenario: /employees should return all the employees
    Given I perform a GET to the employees endpoint
    Then I verify status code 200 is returned
    And I verify that the body does not have size 0

    ##Added Scenario to test GetById with correct id
  @getById
  Scenario: /employees/{id} should return the needed employee
    Given I perform a GET to the employees endpoint with Id "3"
    Then I verify status code 200 is returned
    And I verify the following data in the body response with id
      | Ashton Cox | 86000 | 66 |

      ##Added Scenario to test GetById with incorrect id
  @getById
  Scenario: /employees/{id} should return error message
    Given I perform a GET to the employees endpoint with Id "27"
    Then I verify status code 404 is returned
    And I verify the message "Employee Not Found" is displayed

  @post
  Scenario: /create should create an employee
    Given I perform a POST to the create endpoint with the following data
      | Diego | 3500 | 26 |
    Then I verify status code 200 is returned
    And I verify that the body does not have size 0
    And I verify the message "Successfully! Record has been added." is displayed
    And I verify the following data in the body response
      | Diego | 3500 | 26 |

    ##Added Scenario to test Post with incorrect id
  @post
  Scenario: /create should return error message
    Given I perform a POST to the create endpoint with the following data
      |  | sfsd | 26 |
    Then I verify status code 400 is returned
    And I verify the message "Bad request" is displayed

    ##Added Scenario to test update with correct info
  @Update
  Scenario: /Update should change employee information
    Given  I perform a PUT to the update endpoint with the following data on ID "3"
      | Test | 1234 | 56 |
    Then I verify status code 200 is returned
    And I verify that the body does not have size 0
    And I verify the message "Successfully! Record has been updated." is displayed
    And I verify the following data in the body response
      | Test | 1234 | 56 |

    ##Added Scenario to test update with incorrect info
  @Update
  Scenario: /Update should return error message
    Given I perform a PUT to the update endpoint with the following data on ID "3"
      |  | sfsd | 26 |
    Then I verify status code 400 is returned
    And I verify the message "Bad request" is displayed

    ##Added Scenario to test delete with correct request
  @Delete
  Scenario: /Delete should delete employee
    Given I perform a DELETE to the delete endpoint on ID "5"
    And I verify the correct employee "5" has been deleted
    And I verify the message "Successfully! Record has been deleted" is displayed

    ##Added Scenario to test delete with incorrect request
  @Delete
  Scenario: /Delete should return error message
    Given I perform a DELETE to the delete endpoint on ID ""
    Then I verify status code 400 is returned
    And I verify the message "Bad request" is displayed


