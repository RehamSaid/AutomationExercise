@negative
Feature: Checkout With Empty Cart

  Scenario: Verify that user cannot checkout with an empty cart
    Given User opens the Automation Exercise website
    When User clicks Cart button
    Then Empty cart message should be displayed
    And Proceed To Checkout button should not be displayed
