@negative
Feature: Invalid Payment

  Scenario: Verify that order cannot be paid with missing card number
    Given User opens the Automation Exercise website
    When User logs in with valid credentials
    And User clicks Products button
    And User hovers and adds first product to cart
    And User views the cart
    And User proceeds to checkout
    And User enters order comment
    And User places the order
    And User enters invalid payment details
    And User confirms payment
    Then Card number validation message should be displayed
    And User should remain on payment page
