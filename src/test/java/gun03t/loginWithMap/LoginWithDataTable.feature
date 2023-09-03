Feature: Login to HRM with datatable

  Scenario: Login with Map
    Given user on page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When user fill the login form as follows
      | username | admin    |
      | password | admin123 |
    Then login should be successful
    And quit driver

  @Smoker
  Scenario: Login with Map2
    Given user on page "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When user tries to login as follows, conclusion should be in status
      | username | password  | status |
      | Admin1   | admin123  | false  |
      | Admin    | admin1234 | false  |
      | Admin    | admin123  | true   |
      | Admin1   | admin123  | false  |
      |          |           | false  |
      | Admin    |           | false  |
      |          | admin123  | false  |

    Then quit driver