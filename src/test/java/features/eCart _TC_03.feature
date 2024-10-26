#Author: ToanNV87
Feature: To verify number of product of Fresh Vegetables

  @appiums
  Scenario Outline: Verify number of product in Fresh Vegetables screen
    Given User open application
    When User go to the Fresh Vegetables screen
    Then Verify the number of product <total_product>

    Examples:
      | total_product |
      | 10            |