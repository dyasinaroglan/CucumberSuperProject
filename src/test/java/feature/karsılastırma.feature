Feature: Karşılaştırma

  Background:
    Given siteye gidiniz "https://brandstore.e-shopland.ch/"
    When Tüm ürünler butonuna tıklayınız
    Given All butonuna basıp tüm ürünlerin görüntülenmesi


    Scenario: ürünlerin karşılaştırılması
      Given All butonuna basıp tüm ürünlerden random bir ürün seçilmesi
      And ürün karşılaştırma butonuna tıklanması
      When ürün karşılıştırma sayfasından çıkılması ve bir önceki sayfaya gidilmesi
      And  tekrar random bir ürün seçilmesi
      And ürün karşılaştırma butonuna tıklanması
      Then ürünlerin karşılaştırılması
