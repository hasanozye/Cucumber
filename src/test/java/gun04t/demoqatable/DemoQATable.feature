Feature: DemoQA

  Scenario Outline: Webtable gidis
    Given kullanici "<url>" adresine gider
    And kullanici Elements linkine tiklar
    And kullanici WebTables linkine tiklar
    When kullanici formu asagidaki bilgilerle doldurdugunda
      | FirstName  | <firstName>  |
      | LastName   | <lastName>   |
      | Email      | <email>      |
      | Age        | <age>        |
      | Salary     | <salary>     |
      | Department | <department> |

#    Then kayit eklenmis olmali
    Examples:
      | url                | firstName | lastName | email          | age | salary | department |
      | https://demoqa.com | ali       | veli     | ali@gmail.com  | 20  | 200    | A          |
      | https://demoqa.com | ali1      | veli1    | ali1@gmail.com | 20  | 200    | A          |
      | https://demoqa.com | ali2      | veli2    | ali2@gmail.com | 20  | 200    | B          |
      | https://demoqa.com | ali3      | veli3    | ali3@gmail.com | 20  | 200    | A          |
      | https://demoqa.com | ali4      | veli4    | ali4@gmail.com | 20  | 200    | C          |
      | https://demoqa.com | ali5      | veli5    | ali5@gmail.com | 20  | 200    | A          |
      | https://demoqa.com | ali6      | veli6    | ali6@gmail.com | 20  | 200    | D          |