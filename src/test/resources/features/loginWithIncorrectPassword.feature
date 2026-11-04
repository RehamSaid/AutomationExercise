@negative
Feature: Login With Incorrect Password

  Scenario: Verify that registered user cannot log in with a wrong password
    Given User opens the Automation Exercise website
    When User clicks on Signup Login button
    And User enters the registered email in login form
    And User enters login password "WrongPassword123"
    And User clicks Login button
    Then Incorrect login message should be displayed
