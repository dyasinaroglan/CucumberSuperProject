package Pages;

import org.openqa.selenium.By;

public interface FavorilerLocators {

    By lAllButton = By.cssSelector("a[class='br_lgv_product_count_set br_lgv_product_count value_all']");
    By lAllProducts = By.cssSelector("div[class='astra-shop-thumbnail-wrap']");
    By lFavoriButton = By.cssSelector("main#main div.summary.entry-summary > div.yith-wcwl-add-to-wishlist.wishlist-fragment.on-first-load > div > a > span");
    By lÜrünListesiGörüntüle = By.cssSelector("main#main div.yith-wcwl-add-to-wishlist.exists.wishlist-fragment.on-first-load > div > a");
    By lactualÜrün = By.xpath("(//h1[@class='product_title entry-title']/font[@style='vertical-align: inherit;'])");
    By lexpectedÜrün = By.xpath("(//table[@data-id='151'])//tbody/tr/td[3]//font[@style='vertical-align: inherit;']");

    By lKaldırButton = By.cssSelector("table[data-id='151'] > tbody >tr > td > div >a");


    //Arama butonu
    By lAramaButonu = By.xpath("(//div[@class='ast-search-icon'])[1]/a");
    By lAramaText = By.cssSelector("input[class='search-field']");
    By lCookies = By.cssSelector("a[class='woocommerce-store-notice__dismiss-link']");
    By lÜRrünlerListesi = By.cssSelector("h2[class='entry-title']");

    By lAramaButonu2 = By.cssSelector("input[id='wp-block-search__input-1']");
}
