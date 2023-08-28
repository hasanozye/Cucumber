Feature: feature acilamasi


  Scenario: login functionality

    Given user on "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login" page
    When user fill username as "Admin"
    And user fill password as "admin123"
    And user clicks submit button
    Then login should be successfull
