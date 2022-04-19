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

  Scenario: Increase the product order

    When User clicks to plus icon
    Then Verify that the order number has increased

  Scenario: Decrease the product order

    When User clicks to plus icon
    And  User clicks to minus icon
    Then Verify that the order number has decreased

  Scenario: Subtotal Price Increase

    Then Verify subtotal price same with total product price
    When User selects random a product from the product list
    And User clicks to Confirm
    Then Verify that the selected product is in the cart
    Then Verify subtotal price same with total product price




