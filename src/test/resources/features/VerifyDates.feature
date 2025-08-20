@VerifyingDates
Feature: Verifying dates

  Scenario: Check if date results are correct
    Given that I am on the initial page
    When I execute the dates criteria
    Then I check if the the results are correct