Feature: Favori ürün ekleme çıkarma

  Background:
    Given siteye gidiniz "https://brandstore.e-shopland.ch/"
    When Tüm ürünler butonuna tıklayınız
    Given All butonuna basıp tüm ürünlerin görüntülenmesi

    Scenario: Favoriler
      When random tıklanan ürünün favorilere eklenmesi
      And favori listesinin görüntülenmesi ve bunun Assert edilmesi
      Then Favori listesine eklenen ürünün kaldırılması


      Scenario: Arama butonları1
        When menuBarda yer alan Arama butonuna tıklayınız
        And arama butonuna ürün ismi girilir
        Then Arama sayfasının görüntülenmesi


        Scenario: Arama butonları2
        When sol altta yer alan arama butonuna gelip ürün arattırınız
          Then Arama sayfasının görüntülenmesi

