#Author: ToanNV87
Feature: To verify Cart screen
  This feature ensures that all items in Cart screen work as expected

  @appiums
  Scenario Outline: Verify Cart screen
    Given User open application
    When User go to the dashboard
    And User go into Category screen
    And User select FastFood option
    And User Add product <productName> to cart
    And Add to cart with <quantity> of products <productName>
    And Click into Cart icon on top screen
    And Select location <location>
    Then Verify detail products with values <productName> and <quantity> and <price> and <measurement> and <totalPrice>
    Examples:
      | productName                     | quantity | location | price  | measurement | totalPrice |
      | Kurkure Namkeen - Masala Munch, | 2       | 370405   | $13.00 | 85 kg       | $26.00     |