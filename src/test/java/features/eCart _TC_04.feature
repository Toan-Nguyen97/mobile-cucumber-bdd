#Author: ToanNV87
Feature: To verify product in Coffee screen
  This feature ensures that all information of products in Coffee screen as expected

  @appiums
  Scenario Outline: To verify product detail
    Given User open application
    When User go to the dashboard
    And User go into Coffee screen
    And User select product to view detail <productName>
    Then Verify product information <productName> and <productPrice>
    When User click Add to cart button
    And User click Go to cart button
    Then Verify <productName> in cart

    Examples:
      | productName                                                                                                                     | productPrice |
      | High Octane Instant Coffee Paste with Hazelnut and Coconut Flavors, 150G - Pack of 2 (Hazelnut and Coconut Beaten Coffee Paste) | $718.31      |