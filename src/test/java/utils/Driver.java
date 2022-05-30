package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browsers){

        if(drivers.get() == null){
            switch (browsers){
                case FIREFOX :
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    drivers.set(new ChromeDriver());
            }
        }
        return drivers.get();
    }
    public static void quitDriver(){
        if(drivers.get() != null){
            drivers.get().quit();
            drivers.set(null);
        }
    }
}
