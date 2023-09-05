Feature: opencart add products to cart

  Scenario: login
    Given user goes on "https://opencart.abstracta.us/" page
    And user login with the following credentials
      | username | deneme@deneme.com |
      | password | deneme            |
    Then opencart login should be successfull

  Scenario Outline: add products to cart
    Given user search for "<searchTerm>"
    When user add "<product>" to the cart
    Then product should be added

    Examples:
      | searchTerm | product                  |
      | mac        | MacBook                  |
      | mac        | MacBook Pro              |
      | iPhone     | iPhone                   |
      | Samsung    | Samsung SyncMaster 941BW |
