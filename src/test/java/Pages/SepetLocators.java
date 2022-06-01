package Pages;

import org.openqa.selenium.By;

public interface SepetLocators {

    By lfirstProduct = By.xpath("(//div[@class='astra-shop-thumbnail-wrap'])[5]");
    By lfirstSelect1 = By.cssSelector("select#pa_farbe");
    By lfirstSelect2 = By.id("pa_groesse");
    By lSepeteEkleButton = By.cssSelector("button[class='single_add_to_cart_button button alt']");

    By lsecondProduct = By.xpath("(//div[@class='astra-shop-thumbnail-wrap'])[6]");
    By lsecondSelect1 = By.id("pa_farbe");
    By lsecondSelect2 = By.id("pa_groesse");

    By lSepetinGörüntülenmesiButonu = By.cssSelector("a[class='added_to_cart wc-forward']");

    By lPriceList = By.cssSelector("main#main tr td[class='product-price']");
}
