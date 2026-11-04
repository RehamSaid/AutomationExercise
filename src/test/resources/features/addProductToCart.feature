@positive @smoke
Feature: Add Product To Cart and Checkout
  As a logged in user
  I want to add products to my cart and pay
  So that I can place an order

  Scenario: Verify that user can add products to cart and complete checkout
    Given User opens the Automation Exercise website
    When User logs in with valid credentials
    And User clicks Products button
    And User hovers and adds first product to cart
    Then Product added message should be displayed
    When User clicks Continue Shopping
    And User hovers and adds second product to cart
    And User views the cart
    Then Cart should contain 2 products
    When User proceeds to checkout
    Then Delivery address should be displayed
    When User enters order comment
    And User places the order
    And User enters valid payment details
    And User confirms payment
    Then Order should be placed successfully
