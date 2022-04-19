@cart_Scenarios
Feature: At The Cart Scenarios

  Background: Go to the Cart
    Given User Goes to Hermes American Burger Pizza House home page
    Then Verify that page is American Burger Pizza House Home page
    When User selects "American Burger" category in the category menu
    Then Verify product list with category "American Burger"
    When User selects random a product from the product list
    And  User select Delivery type as "Pickup"
    And User clicks to Confirm
    Then Verify that the selected product is in the cart

 @increment_order
  Scenario: TC_Shopping_cart_01 Increase the product order

   When User clicks to plus icon
    Then Verify that the order number has increased

  @decrement_order
  Scenario: TC_Shopping_cart_02 Decrease the product order

    When User clicks to plus icon
    And  User clicks to minus icon
    Then Verify that the order number has decreased

  @removing
  Scenario: TC_Shopping_cart_03 Removing the product on cart
    When User clicks to minus icon for remove the product
    Then User verify that "Are you sure you want to remove this product?" message appeared
    When User clicks to remove confirm button
    Then User verify that item removed from cart and "Your shopping cart is empty" message is shown on cart

  @prices
  Scenario: TC_Shopping_cart_04 Subtotal Price Same With Total Price

    Then Verify subtotal price same with total product price
    When User selects random a product from the product list
    And User clicks to Confirm
    Then Verify that the selected product is in the cart
    Then Verify subtotal price same with total product price


