package Pages;

import org.openqa.selenium.By;

public interface FiltrelemeLocators {

    By lFiltrelemeButton = By.cssSelector("button[class='button astra-shop-filter-button']");
    By lLeftButton = By.xpath("(//div[@class='price_slider ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[1]");
    By lRightButton = By.xpath("(//div[@class='price_slider ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[@style='left: 100%;'])");
    By lFiltreleSubmit1 = By.xpath("(//button[@type='submit'])[2]");
    By lPrice = By.cssSelector("div[class='price_label']");
    By lAllProducts = By.cssSelector("main#main ul[class='products columns-3'] div[class='astra-shop-summary-wrap'] span[class='price'] bdi");

    //Test707
    By lSelectBoyut = By.cssSelector("select[class='woocommerce-widget-layered-nav-dropdown dropdown_layered_nav_groesse select2-hidden-accessible']");
    By lOptionList = By.cssSelector("select[class='woocommerce-widget-layered-nav-dropdown dropdown_layered_nav_groesse select2-hidden-accessible'] option");
    By lFiltreKaldirButton = By.cssSelector("main#main div.widget.woocommerce.widget_layered_nav_filters > ul > li > a");
    By lFiltreleSubmit2 = By.xpath("(//button[@type='submit'])[4]");

    By lürünList = By.cssSelector("div[class='astra-shop-thumbnail-wrap']");
    By lürünÖzelliklerı = By.xpath("(//div[@class='woocommerce-tabs wc-tabs-wrapper'])/ul//li[2]");
    By lboyut = By.xpath("(//table[@class='woocommerce-product-attributes shop_attributes'])//tr[3]/td/p");



    //Test808
    By lrenkOptinList = By.cssSelector("select[class='woocommerce-widget-layered-nav-dropdown dropdown_layered_nav_farbe select2-hidden-accessible'] option");
    By lrenkSelect = By.cssSelector("select[class='woocommerce-widget-layered-nav-dropdown dropdown_layered_nav_farbe select2-hidden-accessible']");
    By lFiltreleSubmit3 = By.xpath("(//button[@class='woocommerce-widget-layered-nav-dropdown__submit'])[1]");

    By lAllProducts1 = By.cssSelector("div[class='astra-shop-thumbnail-wrap']");
    By lürünÖzellikleri1 = By.xpath("(//div[@class='woocommerce-tabs wc-tabs-wrapper'])/ul//li[2]");
    By lRenkList = By.xpath("(//table[@class='woocommerce-product-attributes shop_attributes'])//tr[2]/td/p");


    //Test909
    By lSelectMalzeme = By.cssSelector("select[class='woocommerce-widget-layered-nav-dropdown dropdown_layered_nav_material select2-hidden-accessible'] option");
    By lSelect = By.cssSelector("select[class='woocommerce-widget-layered-nav-dropdown dropdown_layered_nav_material select2-hidden-accessible']");
    By lsubmitButton4 = By.xpath("(//button[@class='woocommerce-widget-layered-nav-dropdown__submit'])[3]");
    By lgetProducts = By.cssSelector("div[class='astra-shop-thumbnail-wrap']");
    By lürünÖzellikleri4 = By.xpath("(//table[@class='woocommerce-product-attributes shop_attributes'])//tr[4]//td/p");


}
