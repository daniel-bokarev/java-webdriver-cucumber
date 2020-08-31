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

    @market3
    Scenario: Alert, iFrame and Window
      Given I go to "quote" page
      And I "dismiss" third party agreement
      And I wait for 1 sec
      And I fill out "Richard Roe" name and "0123456789" phone contact
      And I wait for 1 sec
      And I verify document list contains "Document 2"
      And I fill out required fields