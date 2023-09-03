Feature: Opencart Search

  Background:
    Given user on opencart main page

  Scenario: user searches mac
    When  user search "mac"
    Then  product count should be 4

    Scenario: user seraches iphone
      When user search "iphone"
      Then product count should be 2