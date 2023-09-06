Feature: feature 1

  @login @A @B
  Scenario: scenario 1

    Given user multiply 2
    When user divide 2
    Then result is "two"

  @logout @B
  Scenario: scenario 2

    Given user multiply 2
    When user divide 2
    Then result is "two"