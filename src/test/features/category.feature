
  Feature: Category Test

    Scenario: Press the 'Tüm Kategoriler' button, press 'Edebiyat' and select a random item

      Given  Find and press the All Categories button
      And  Find and press the Edebiyat
      And  Select a random item from list
      And Add the item to the cart and
      And Go to the cart
      And Verify that its the same item in the cart
