#Author: ToanNV87
Feature: To verify Profile screen
  This feature to ensures that all items in profile screen work as expected
  @appiums
  Scenario: To verify detail of Profile screen
    Given User open application
    When User go to the dashboard
    And Click to Profile on footer menu
    And Click to Welcome Guest
    Then Verify login screen displayed
    When Click button Login
#    And Select with location all
    And Click to Profile on footer menu
    Then Verify Profile screen displayed
