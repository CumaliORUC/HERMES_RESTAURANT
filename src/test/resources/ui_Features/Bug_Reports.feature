Feature: Bug Reports

    Scenario: Bug Report 1; Inform box not clickable

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
      Then User clicks to inform checkbox

    Scenario: Bug Report 2; Failed to send feedback

      Given User Goes to Hermes American Burger Pizza House home page
      When User clicks to Contact Us
      And User full fill email address and commentbox
      And User clicks to agreement checkbox
      And User clicks to sent feed back
      Then Verify that Successful message is displayed

    Scenario: Bug Report 3; %10 discount calculation error

      Given User Goes to Hermes American Burger Pizza House home page
      When User selects "Hot Dogs" category in the category menu
      Then Verify product list with category "Hot Dogs"
      When User selects random a product from the product list
      And  User select Delivery type as "Pickup"
      And User clicks to Confirm
      Then Verify that the selected product is in the cart
      When User selects random a product from the product list
      And User clicks to Confirm
      Then Verify that the selected product is in the cart
      Then Verify that discount rate is correct