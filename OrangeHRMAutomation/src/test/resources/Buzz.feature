Feature: Add Buzz Message on OrangeHRM
  Background: Add Buzz Message for user into Orange HRM
    Given I am in Orange HRM Home web page

  @AddBuzzMessage
  Scenario: New Buzz Newsfeed
    Given I click on Buzz NewsFeed
    And I add the following text "Hello, world! Ready to roll" to the buzz newsfeed
    And I click on Post Button
    Then A success post message should be displayed
    And The message should be displayed as "Hello, world! Ready to roll"