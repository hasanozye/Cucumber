Feature: matematik islemleri


  Scenario: toplama islemi
    Given baslangic sayisi 10 olsun
    When  kullanici 3 eklediginde
    And   kullanici 5 eklediginde
    And   kullanici 7 eklediginde
    Then  sonuc 25 olmalidir

  Scenario: cikarma islemi
    Given baslangic sayisi 2 olsun
    When  kullanici 10 eklediginde
    And   kullanici 2 cikardiginda
    Then  sonuc 10 olmalidir