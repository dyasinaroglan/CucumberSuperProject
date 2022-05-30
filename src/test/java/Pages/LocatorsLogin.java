package Pages;

import org.openqa.selenium.By;

public interface LocatorsLogin {

    By lCookies = By.cssSelector("a[class='woocommerce-store-notice__dismiss-link']");
    By lLoginButton = By.xpath("(//i[@class='_mi _before far fa-user-circle'])[1]");
    By lUserName = By.id("username");
    By lPassword = By.id("password");
    By lRegister = By.xpath("(//button[@type='submit'])[2]");

    By lHome = By.xpath("(//i[@class='_mi _before dashicons dashicons-admin-home'])[1]");
}
