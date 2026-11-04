@negative
Feature: Invalid Search

  Scenario: Verify that searching for invalid text returns no products
    Given User opens the Automation Exercise website
    When User clicks Products button
    And User searches for product "abcdef123456"
    And User clicks Search button
    Then Searched Products title should be displayed
    And No products should be found
