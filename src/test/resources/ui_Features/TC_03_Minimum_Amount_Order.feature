Feature: Minimum Amount Order Scenarios

  Background:
    Given User Goes to Hermes American Burger Pizza House home page
    Then Verify that page is American Burger Pizza House Home page
    When User selects "American Burger" category in the category menu
    Then Verify product list with category "American Burger"

    Scenario: Ordering below minimum amount Order

      When User selects "Long Chilli Cheese Burger" product from the product list
      And  User select Delivery type as "Delivery"
      And User clicks to Confirm
      Then Verify that order is not sufficient for minimum ordering

  Scenario: Ordering two product below minimum amount

      When User selects "Long Chilli Cheese Burger" product from the product list
      And  User select Delivery type as "Delivery"
      And User clicks to Confirm
      When User selects "Long Chilli Cheese Burger" product from the product list
      And User clicks to Confirm
      Then Verify that order is not sufficient for minimum ordering


  Scenario: Ordering two product over minimum amount

      When User selects "Long Chilli Cheese Burger" product from the product list
      And  User select Delivery type as "Delivery"
      And User clicks to Confirm
      When User selects "Mexican Burger" product from the product list
      And User clicks to Confirm
      Then Verify that order is sufficient for minimum ordering
