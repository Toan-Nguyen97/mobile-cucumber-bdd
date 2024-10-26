#Author: ToanNV87
Feature: To verify Payment screen
  This feature ensures that all items work as expected

  @appiums
  Scenario Outline: To verify detail Payment screen
    Given User open application
    When User go to the dashboard
    And User go into Category screen
    And User select Beverages screen
    And User Add product <product> to cart
    And Add to cart with <quantity> of products <product>
    And Click into Cart icon on top screen
    And Select location <location>
    And Click Continue button
    And Click button Login
    And Click Continue button
    And Click Continue button in select address screen
    Then Verify detail Payment screen with <product> and <totalPrice> and <subtotal> and <deliveryCharge> and <youSaved> and <location> and <grandTotal> and <productPayment>
    Examples:
      | product                                 | quantity | totalPrice | location | grandTotal | subtotal | deliveryCharge | youSaved | grandTotal | productPayment                                   |
      | Sunfeast Dark Fantasy Choco Fills, 600g | 2        | $414.20    | 370001   | $414.20    | $414.20  | $0.00          | $109.0   | $109.0     | Sunfeast Dark Fantasy Choco Fills, 600g (1 Pack) |