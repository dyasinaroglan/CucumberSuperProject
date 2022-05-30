package Pages;

import org.openqa.selenium.By;

public interface FavorilerLocators {

    By lAllButton = By.cssSelector("a[class='br_lgv_product_count_set br_lgv_product_count value_all']");
    By lAllProducts = By.cssSelector("div[class='astra-shop-thumbnail-wrap']");
    By lFavoriButton = By.xpath("(//a[@class='add_to_wishlist single_add_to_wishlist'])[1]");
    By lÜrünListesiGörüntüle = By.xpath("(//a[@rel='nofollow'])[1]");

    By lactualÜrün = By.xpath("(//h1[@class='product_title entry-title']/font[@style='vertical-align: inherit;'])");
    By lexpectedÜrün = By.xpath("(//table[@data-id='151'])//tbody/tr/td[3]//font[@style='vertical-align: inherit;']");
}
