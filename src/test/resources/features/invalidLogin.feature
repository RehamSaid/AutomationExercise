@negative
Feature: Invalid Login

  Scenario: Verify that login fails with incorrect email and password
    Given User opens the Automation Exercise website
    When User clicks on Signup Login button
    And User enters login email "not.registered.user.123@test.com"
    And User enters login password "WrongPassword123"
    And User clicks Login button
    Then Incorrect login message should be displayed
