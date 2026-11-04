@negative
Feature: Checkout Without Login

  Scenario: Verify that guest user is asked to login before checkout
    Given User opens the Automation Exercise website
    When User clicks Products button
    And User hovers and adds first product to cart
    And User views the cart
    And User proceeds to checkout
    Then Register login message should be displayed
