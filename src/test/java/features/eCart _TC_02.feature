#Author: ToanNV87
Feature: To verify "Category" screen
  This feature ensures that all items in Category screen work as expected
  @appiums
  Scenario: Verify "Category" screen
    Given User open application on devices
    When User go to the Category screen
    Then Verify items in Category screen