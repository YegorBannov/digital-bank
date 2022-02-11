Feature: This feature file to test functionality related to signup


  Scenario: Verify User Can signup
    Given user open website
    When user click on signup link
    Then verify user is on signup page
    And verify title of the signup page
    When fill in the first form
    Then fill in the second form

