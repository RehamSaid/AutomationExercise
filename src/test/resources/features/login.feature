@positive @smoke
Feature: Login
  As a registered user
  I want to log in with my credentials
  So that I can access my account

  Scenario: Verify that registered user can log in successfully
    Given User opens the Automation Exercise website
    When User clicks on Signup Login button
    And User enters valid email and password
    And User clicks Login button
    Then User should login successfully
