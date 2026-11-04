@positive @smoke
Feature: Register User
  As a new visitor
  I want to create an account
  So that I can shop on Automation Exercise

  Scenario: Verify that user can register successfully
    Given User opens the Automation Exercise website
    When User clicks on Signup Login button
    And User enters signup name "Reham"
    And User enters a new unique signup email
    And User clicks Signup button
    And User fills account information
    And User clicks Create Account
    Then Account should be created successfully
