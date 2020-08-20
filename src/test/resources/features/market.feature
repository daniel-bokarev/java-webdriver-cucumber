@market
  Feature: Marketing test suite

    @market1
    Scenario: Required fields
      Given I go to "quote" page
      And I print page details
      And I fill out required fields
      And I submit the form
      And I verify required fields

    @market2
    Scenario: Logs
      Given I go to "yahoo" page
      And I get logs