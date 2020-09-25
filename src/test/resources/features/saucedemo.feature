@saucedemo
Feature: saucedemo website test cases

  @saucedemo1
  Scenario: Verify happy path for logging in existing user
    Given I go to Swag Labs login page
    When I input “standard” username into Username field
    And I input “password” into Password field
    And I click Login button
    Then I am redirected to Products page

  @saucedemo2
  Scenario: Verify that password field is required
    Given I go to Swag Labs login page
    When I input “standard” username into Username field
    And I click Login button
    Then proper password error message is displayed