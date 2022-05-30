Feature: Filtreleme Testi

  Background:
    Given siteye gidiniz "https://brandstore.e-shopland.ch/"
    When Tüm ürünler butonuna tıklayınız
    And ürünler filtresi butonuna tıklanır

  Scenario: Test606 Fiyata göre filtreleme
    And sağ ve sol butonlarının kaydırılması
    Then ürün fiyatlarının filtrelenen rakamlar arasında olduğunun test edilmesi

  Scenario: Test707 Boyuta göre filtreleme
    When Random bir beden seçilmesi

    Scenario: Test808 Renge göre filtreleme
    When Random bir renk seçilmesi
      Then ürünlerin içinde filtrelenen rengin olduğunun test edilmesi

      Scenario: Test909 Malzemeye göre filtreleme
        When random bir malzeme seçiniz
        Then ürünlerin içinde filtrelenen malzemenin olduğunu assert edin
