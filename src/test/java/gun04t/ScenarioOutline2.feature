Feature: Scenario outline example

  Scenario Outline: kiki do you love me
    Given kullanici "<url>" sayfasinda


    When kullanici asagidaki verilerle giris yaptiginda
      | username | <kullaniciAdi> |
      | password | <sifre>        |

    And kullanici "<kullaniciAdi>" ve sifre "<sifre>" ile giris yaptiginda
    Then giris durumu "<status>" olmali

    Examples:
      | url  | kullaniciAdi | sifre | status |
      | url  | ali1         | 121   | false  |
      | ali2 | ali2         | 122   | false  |
      | ali3 | ali3         | 123   | true   |
      | ali4 | ali4         | 124   | false  |
      | ali5 | ali5         | 125   | false  |
      | ali6 | ali6         | 126   | false  |