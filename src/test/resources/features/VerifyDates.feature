@buy_item
Feature: Buying an item

  Scenario: Buy one item
    Given that I am on the initial page
    When I execute the dates criteria
    Then I check if the order was finished