Feature: Login OrangeHRM App

  Background: User login into Orange HRM
    Given I am in Orange HRM web page

  @loginWithValidCredentials
  Scenario: Login into Orange HRM web page with valid credentials

    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on the login button
    Then The home page should be displayed
    And I logout

  @logoutCorrectly
  Scenario: Logout correctly after successful login

    Given I set the user name field with "Admin"
    And I set the password field with "admin123"
    When I click on the login button
    Then The home page should be displayed
    And I logout
    Then The login page should be displayed

  @loginWithInvalidCredentials
  Scenario: Login into Orange HRM web page with invalid credentials
    Given I set the user name field with "wrong_user"
    And I set the password field with "wrong_password"
    When I click on the login button
    Then An error message that says "Invalid Credentials" should be displayed





