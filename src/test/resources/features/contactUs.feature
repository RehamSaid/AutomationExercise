@positive
Feature: Contact Us
  As a visitor
  I want to send a message through the Contact Us form
  So that I can reach the website team

  Scenario: Verify that user can submit the Contact Us form
    Given User opens the Automation Exercise website
    When User clicks on Contact Us button
    Then Get In Touch section should be displayed
    When User enters name
    And User enters email
    And User enters subject
    And User enters message
    And User uploads a file
    And User clicks Submit button
    And User accepts the alert
    Then Success message should be displayed
