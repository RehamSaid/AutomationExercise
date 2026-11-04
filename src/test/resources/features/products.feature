@positive
Feature: Products

  Scenario: Verify all products list and product details
    Given User opens the Automation Exercise website
    When User clicks Products button
    Then All Products page should be displayed
    And Products list should be visible
    When User clicks first product
    Then Product details should be displayed
