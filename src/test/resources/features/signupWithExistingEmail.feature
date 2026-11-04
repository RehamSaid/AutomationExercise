@negative
Feature: Signup With Existing Email

  Scenario: Verify that user cannot sign up with an already registered email
    Given User opens the Automation Exercise website
    When User clicks on Signup Login button
    And User enters signup name "Reham"
    And User enters the registered email in signup form
    And User clicks Signup button
    Then Email already exists message should be displayed
