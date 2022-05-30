package Pages;

import org.openqa.selenium.By;

public interface ProductsAll_Locators {

    By lProductsAll = By.xpath("(//i[@class='_mi _before dashicons dashicons-star-filled'])[1]");

    By lAltiCiziliFiyatlar = By.xpath ("//del[@aria-hidden='true'])");
    By lgetProductsAllPrice = By.cssSelector("span[class='price']");

    By lnextPageNumber = By.cssSelector("a[class='next page-numbers']");

    By lgetProductsAllPictures = By.cssSelector("img[width='300']");

    By lbackPageNumber = By.cssSelector("a[class='prev page-numbers']");

    By lCategories = By.cssSelector("span[class='select2-selection select2-selection--single']");
    By lSelectCategories = By.cssSelector("select[class='dropdown_product_cat select2-hidden-accessible']");
    By lOptionsCategories = By.xpath("//*[contains(@class,'level')]");

    By lTitleCategories = By.cssSelector("h1[class='woocommerce-products-header__title page-title']");

    By lSiralamaSelect = By.cssSelector("select.orderby");
    By lAllProducts = By.cssSelector("span.price ins span.woocommerce-Price-amount");


}
