@american_url
Feature: American Burger Url_Page Api Test with Object Mapper Method

  Background:
    Given Send Get request for hermes get-single-product

  Scenario: Assert Status Code

    Then  Assert status code is 200

  Scenario: Assert Out Body

    Then Assert success is true
    Then Assert checksum is "63103a1b8bb4684e57649297523a2134"
    Then Assert branch_id is 159
    And  Assert product_id is 25448

 Scenario: Assert Inner Body

   Then Assert d name is "American Burger"
   Then Assert d isCombo is false

   @api
  Scenario Outline:Assert Additives
    Then Assert Additives has "<additive numbers>"

    Examples:
    |additive numbers|
    |1563|
    |1574|
