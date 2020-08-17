@market
  Feature: Marketing test suite

    @market1
    Scenario: Required fields
      Given I go to "quote" page
      And I print page details
      And I fill out required fields
      And I submit the form
      And I verify required fields