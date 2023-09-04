Feature: Scenario outline example

  Scenario Outline:
    Given ogrencinin adi "<name>"
    When ogrencinin soyadi "<lastname>"
    Then ogrencinin yasi <age>

    Examples:
      | name | lastname | age |
      | ali1 | ali1     | 121 |
      | ali2 | ali2     | 122 |
      | ali3 | ali3     | 123 |
      | ali4 | ali4     | 124 |
      | ali5 | ali5     | 125 |
      | ali6 | ali6     | 126 |