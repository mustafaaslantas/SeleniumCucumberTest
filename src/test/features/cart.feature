
  Feature: Cart Test

    Scenario: Remove the item from the cart and verify the cart is empty

      Given Go to the cart
      And Remove the item
      Then Verify the cart is empty