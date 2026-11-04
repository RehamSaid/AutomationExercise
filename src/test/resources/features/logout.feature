@positive
Feature: Logout

  Scenario: Verify that logged in user can log out
    Given User opens the Automation Exercise website
    When User logs in with valid credentials
    Then User should login successfully
    When User clicks Logout button
    Then User should be redirected to the Login page
