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
        TakesScreenshot scr = (TakesScreenshot) driver; //driver'??n screenshot'unu al??yoruz
        File scrFile = scr.getScreenshotAs(OutputType.FILE); //File tipinde bir de??i??kene at??yoruz. ????kt?? tipi olarak FILE
        File hedefFile = new File("src/test/resources/screenshots/" + scrName + ".png"); //Hedef dosyas??n?? olu??turuyoruz.
        FileUtils.copyFile(scrFile, hedefFile); //Ekran g??r??nt??s??n?? hedef dosyaya kopyal??yoruz.
    }
    public void screenShotByRobot() throws AWTException, IOException {
        Robot robot = new Robot(); //Robot nesnesi olu??turuyoruz.
        Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); //Ekran??n tam boyutunu al??yoruz.
        BufferedImage image = robot.createScreenCapture(rect); //BufferedImage g??r??nt?? verilerini i??lemek i??in kullan??l??r.
        //BufferedImage verilerinin sol ??st k????esi 0,0 olarak tan??mlan??r.
        String scrName = "ScreenShot_ " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));
        File destFile= new File("src/test/java/screenShot/" + scrName + ".png");
        ImageIO.write(image, "png", destFile); //Ekran g??r??nt??s??n?? png format??nda dosyaya kaydediyoruz.

    }
    public void screenShotByRobotWithLocal(int x, int y, int widht, int height) throws AWTException, IOException {
        Robot robot = new Robot();// Robot nesnesi olu??turuyoruz.
        Rectangle rectangle = new Rectangle(x, y, widht, height);  //Ekran??n belirledi??imiz ??l????lere g??re al??yoruz
        BufferedImage image = robot.createScreenCapture(rectangle); //BufferedImage g??r??nt?? verilerini i??lemek i??in kullan??l??r.
        String scrname = "screenShot_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));//Ekran g??r??nt??s??n??n ismi
        //bundan sonra hedef dosyay?? belirlememiz laz??m
        File destFile = new File("src/test/java/screenShot/" + scrname + ".png"); //ekran g??r??nt??s??n??n hedefini belirlemek i??in
        ImageIO.write(image, "png", destFile); ////Ekran g??r??nt??s??n?? png format??nda dosyaya kaydediyoruz.

    }

}
