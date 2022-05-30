Feature: Favori ürün ekleme çıkarma

    Scenario: Favoriler
      Given siteye gidiniz "https://brandstore.e-shopland.ch/"
    When Tüm ürünler butonuna tıklayınız
      Given All butonuna basıp tüm ürünlerin görüntülenmesi
      When random tıklanan ürünün favorilere eklenmesi
      And favori listesinin görüntülenmesi ve bunun Assert edilmesi
      Then Favori listesine eklenen ürünün kaldırılması