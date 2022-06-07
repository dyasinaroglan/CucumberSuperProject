package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParentClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public ParentClass(){
       driver = Driver.getDriver();
       driver.manage().window().maximize();
       wait = new WebDriverWait(driver, Duration.ofSeconds(25));
       driver.manage().deleteAllCookies();
    }
    public void gotoSite(String url){
        driver.get(url);
    }
    public void clickTo(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void clickTo(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void sendKeysTo(By locator, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }
    public void sendKeysTo(By locator, String text, boolean clear){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if(clear){
            element.clear();
            element.sendKeys(text);
        }
    }
    public void sendKeysTo(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
    public void sleepTo(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void hover(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).pause(1000).perform();
    }
    public void scrollIntoView(WebElement element){
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public void scrollIntoView(By locator){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(locator));
    }
    public void verifyTextIn(By locator,String str){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Assert.assertTrue(element.getText().toLowerCase(Locale.ROOT).contains(str.toLowerCase(Locale.ROOT)));
    }
    public int randomSayi(int size){
        return (int) (Math.random() * size);

    }
    public void screenShotBySelenium() throws IOException {
        String scrName = "ScreenShot_ " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        TakesScreenshot scr = (TakesScreenshot) driver; //driver'ın screenshot'unu alıyoruz
        File scrFile = scr.getScreenshotAs(OutputType.FILE); //File tipinde bir değişkene atıyoruz. Çıktı tipi olarak FILE
        File hedefFile = new File("src/test/resources/screenshots/" + scrName + ".png"); //Hedef dosyasını oluşturuyoruz.
        FileUtils.copyFile(scrFile, hedefFile); //Ekran görüntüsünü hedef dosyaya kopyalıyoruz.
    }
    public void screenShotByRobot() throws AWTException, IOException {
        Robot robot = new Robot(); //Robot nesnesi oluşturuyoruz.
        Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //Ekranın tam boyutunu alıyoruz.
        BufferedImage image = robot.createScreenCapture(rect); //BufferedImage görüntü verilerini işlemek için kullanılır.
        //BufferedImage verilerinin sol üst köşesi 0,0 olarak tanımlanır.
        String scrName = "ScreenShot_ " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        File destFile= new File("src/test/java/screenShot/" + scrName + ".png");
        ImageIO.write(image, "png", destFile); //Ekran görüntüsünü png formatında dosyaya kaydediyoruz.

    }
    public void screenShotByRobotWithLocal(int x, int y, int widht, int height) throws AWTException, IOException {
        Robot robot = new Robot();// Robot nesnesi oluşturuyoruz.
        Rectangle rectangle = new Rectangle(x, y, widht, height);  //Ekranın belirlediğimiz ölçülere göre alıyoruz
        BufferedImage image = robot.createScreenCapture(rectangle); //BufferedImage görüntü verilerini işlemek için kullanılır.
        String scrname = "screenShot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));//Ekran görüntüsünün ismi
        //bundan sonra hedef dosyayı belirlememiz lazım
        File destFile = new File("src/test/java/screenShot/" + scrname + ".png"); //ekran görüntüsünün hedefini belirlemek için
        ImageIO.write(image, "png", destFile); ////Ekran görüntüsünü png formatında dosyaya kaydediyoruz.

    }

}
