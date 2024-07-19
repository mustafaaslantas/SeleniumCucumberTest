
  Feature: Search Test

    Scenario: Search an item and verify the results match with the searched name

      Given Find and press the search bar
      And Type Orhan Pamuk and search
      And Verify the results