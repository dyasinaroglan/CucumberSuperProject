Feature: Sepet Testi

  Scenario: Ürünlerin sepete doğru bilgilerle eklenemsi
    Given siteye gidiniz "https://brandstore.e-shopland.ch/"
    And Tüm ürünler butonuna tıklayınız
    And All butonuna basıp tüm ürünlerin görüntülenmesi
    When önceden belirlenmiş bir ürüne tıklanması
    And Ürünün renk ve boyut özelliklerinin belirlenmesi ve sepete eklenmesi
    And ürünler sayfasına geri gidip ikinci bir ürün seçilmesi
    And seçilen ikinci ürünün renk ve boyut özellikleinin belirlenmesi ve sepete eklenmesi
    Then Alışveris sepetinin görüntülenmesi butonuna tıklanması ve ürün fiyatlarının assert edilmesi


