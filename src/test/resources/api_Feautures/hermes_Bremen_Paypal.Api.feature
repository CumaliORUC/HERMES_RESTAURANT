@bremen_Url
Feature: Bremen Url_Page Api Test with Object Mapper Method
  Background:
    Given Send Get request for Bremen Url_Page paypal address
    When Create your expectedData in JsonUtil_Format

    Scenario: TC_Bremen_Url_01, Assert status code
      Then Verify that status code is 200

    Scenario:TC_Bremen_Url_02/03, Verify content data
      Then Verify that content id is "1957"
      Then Verify that the content "id" is the same as the expected data and response data
      Then Verify that content title is "Enjoy Pizza Delmenhorst"

    Scenario: TC_Bremen_Url_04, Inner Body Assertion
      Then Verify that the response payment Methods id list size is the same as expected
      Then Verify that the response payment Methods id list has expected list

    Scenario: TC_Bremen_Url_05, Inner Body Json Method
      Then Verify that response payment Methods id_1 name is "bar"


