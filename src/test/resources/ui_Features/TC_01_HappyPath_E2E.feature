Feature: End to End

  Scenario: Ordering with Pick Up
    Given User Goes to Hermes American Burger Pizza House home page
    Then Verify that page is American Burger Pizza House Home page
    When User selects "American Burger" category in the category menu
    Then Verify product list with category "American Burger"
    When User selects random a product from the product list
    And  User select Delivery type as "Pickup"
    And User clicks to Confirm
    Then Verify that the selected product is in the cart
    And User clicks to Order now
    Then Verify that address page is displayed
    When User full fills the address boxes
    And User clicks to Checkout
    Then Verify that the Cash Button is selected
    Then Verify that the Order price is the same as the Total price
    When User clicks to Place My Order for
    Then Verify that "Your order was successful!" message is displayed