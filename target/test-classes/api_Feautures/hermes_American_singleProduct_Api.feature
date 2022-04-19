@american_url
Feature: American Burger Url_Page Api Test with Object Mapper Method

  Background:
    Given Send Get request for American get-single-product baseUrl

  Scenario:TC_American_BurgerUrl_01, Assert Status Code

    Then  Assert status code is 200

  Scenario: TC_American_BurgerUrl_02, Assert Out Body

    Then Assert success is true
    Then Assert checksum is "63103a1b8bb4684e57649297523a2134"
    Then Assert branch_id is 159
    And  Assert product_id is 25448

 Scenario:TC_American_BurgerUrl_03, Assert Inner Body

   Then Assert d name is "American Burger"
   Then Assert d isCombo is false


  Scenario Outline:TC_American_BurgerUrl_04, Assert Additives
    Then Assert Additives has "<additive numbers>"

    Examples:
    |additive numbers|
    |1563|
    |1574|
