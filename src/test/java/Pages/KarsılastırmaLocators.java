package Pages;

import org.openqa.selenium.By;

public interface KarsılastırmaLocators {

    By lAllButton = By.cssSelector("main#main ul[class='products columns-3'] div[class='astra-shop-summary-wrap'] span[class='price'] bdi");
    By lAllProducts = By.cssSelector("main#main ul div[class='astra-shop-thumbnail-wrap']");
    By lKarsılastırmaButton = By.cssSelector("a[class='compare']");
    By lCloseButton = By.cssSelector("button#cboxClose");

    By iFrameProducts = By.cssSelector("tr[class='title odd'] > td");


}
