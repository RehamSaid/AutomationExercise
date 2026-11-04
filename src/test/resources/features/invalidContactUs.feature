@negative
Feature: Invalid Contact Us Submission

  Scenario: Verify that Contact Us form cannot be submitted without email
    Given User opens the Automation Exercise website
    When User clicks on Contact Us button
    And User enters name
    And User enters subject
    And User enters message
    And User clicks Submit button
    Then Email validation message should be displayed
    And User should remain on Contact Us page
