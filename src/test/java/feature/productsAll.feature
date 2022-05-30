Feature:

  Scenario: Test303 - Tüm Ürünler Menüsü'nün testi
    Given siteye gidiniz "https://brandstore.e-shopland.ch/"
    Given Tüm ürünler butonuna tıklayınız
    When Tüm ürünlerin fiyat bilgisi olduğunun test edilmesi
    And  Tüm ürünlerin resimlerinin olduğunun test edilmesi

  Scenario: Test404 - Kategoriler Butonu
    Given siteye gidiniz "https://brandstore.e-shopland.ch/"
    And Tüm ürünler butonuna tıklayınız
    When kategoriler butonuna tıklanması
    And Açılan ekrandan random kategori seçme

  Scenario: Test505 Sıralama Butonu
    Given siteye gidiniz "https://brandstore.e-shopland.ch/"
    When Tüm ürünler butonuna tıklayınız
    And ortalama dereceye göre sıralanmış butonuna tıklanır
    Then ürün fiyatlarının artan olarak sıralanması assert edilir