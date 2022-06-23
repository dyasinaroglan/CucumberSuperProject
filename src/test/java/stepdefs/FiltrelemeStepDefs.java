package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.ParentClass;

import java.util.ArrayList;
import java.util.List;

import static Pages.FiltrelemeLocators.*;

public class FiltrelemeStepDefs extends ParentClass {

    @And("ürünler filtresi butonuna tıklanır")
    public void ürünlerFiltresiButonunaTıklanır() {
        clickTo(lFiltrelemeButton);
    }

    @And("sağ ve sol butonlarının kaydırılması")
    public void sağVeSolButonlarınınKaydırılması() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lLeftButton));
        Actions builder = new Actions(driver);
        WebElement left = driver.findElement(lLeftButton);
        Action sagaKaydir = builder.dragAndDropBy(left,80,0).build();
        sagaKaydir.perform();
        sleepTo(1000);
        WebElement right = driver.findElement(lRightButton);
        sleepTo(1000);
        Action solaKaydir = builder.dragAndDropBy(right,-60,0).build();
        solaKaydir.perform();
        sleepTo(2000);
    }

    @Then("ürün fiyatlarının filtrelenen rakamlar arasında olduğunun test edilmesi")
    public void ürünFiyatlarınınFiltrelenenRakamlarArasındaOlduğununTestEdilmesi() {

        String priceText = driver.findElement(lPrice).getText();
            String price = priceText.replaceAll("[^0-9—]", "");
        System.out.println(priceText);

        String[] price1 = price.split("—"); //price1[0] = min, price1[1] = max iki tane değerimiz oldu
        System.out.println("price1[0] = " + price1[0]);
        System.out.println("price1[1] = " + price1[1]);
        clickTo(lFiltreleSubmit1);

        List<WebElement> list = driver.findElements(lAllProducts); //ürünlerin fiyatlarının listesini almış oldum

        List<String> priceListS = new ArrayList<>();
        List<Double> priceListD = new ArrayList<>();

        for (WebElement element : list) {
             priceListS.add(element.getText().replaceAll("[^0-9.]", ""));
        }
        for (String i : priceListS) {
            priceListD.add(Double.parseDouble(i));
        }
        for (Double aDouble : priceListD) {
            Assert.assertTrue(Double.parseDouble(price1[0]) <= priceListD.get(0) && Double.parseDouble(price1[1]) >= priceListD.get(priceListD.size()-1));
        }

    }

    @When("Random bir beden seçilmesi")
    public void randomBirBedenSeçilmesi() {

        List<WebElement> list = driver.findElements(lOptionList);
        int options = list.size();
        int option = random(options);

        wait.until(ExpectedConditions.visibilityOfElementLocated(lSelectBoyut));
        WebElement element = driver.findElement(lSelectBoyut);
        Select select = new Select(element);
        select.selectByIndex(option);
        sleepTo(1000);
        clickTo(lFiltreleSubmit2);
        sleepTo(1000);

            List<WebElement> ürünList = driver.findElements(lürünList);
            ürünList.get(random(ürünList.size())).click();
            WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(lürünÖzelliklerı));
            scrollIntoView(element2);
            sleepTo(1000);
            clickTo(lürünÖzelliklerı);
            String boyutList = driver.findElement(lboyut).getText();

            try {
                Assert.assertTrue(boyutList.contains(list.get(option).getText()));
            } catch (StaleElementReferenceException e) {

            }
        }

    public static int random(int size){
        return (int) (Math.random()*size);
    }
    int options ;
    int option ;
    List<WebElement> list;

    @When("Random bir renk seçilmesi")
    public void randomBirRenkSeçilmesi() {
        list = driver.findElements(lrenkOptinList);

        options = list.size();
        option = random(options);

        Select builder = new Select(driver.findElement(lrenkSelect));
        builder.selectByIndex(option);
        clickTo(lFiltreleSubmit3);
        List<WebElement> ürünList = driver.findElements(lAllProducts1);
        ürünList.get(random(ürünList.size())).click();

        clickTo(lürünÖzellikleri1);

    }

    @Then("ürünlerin içinde filtrelenen rengin olduğunun test edilmesi")
    public void ürünlerinIçindeFiltrelenenRenginOlduğununTestEdilmesi() {

        String renkList = driver.findElement(lRenkList).getText();

        try {
            Assert.assertTrue(renkList.contains(list.get(option).getText()));
        }catch (StaleElementReferenceException e){

        }
    }

    @When("random bir malzeme seçiniz")
    public void randomBirMalzemeSeçiniz() {
        list = driver.findElements(lSelectMalzeme);
        options = list.size();
        option = random(options);
        Select select = new Select(driver.findElement(lSelect));
        select.selectByIndex(option);
        clickTo(lsubmitButton4);

        List<WebElement> ürünList = driver.findElements(lgetProducts);
        ürünList.get(random(ürünList.size())).click();
        clickTo(lürünÖzelliklerı);

    }

    @Then("ürünlerin içinde filtrelenen malzemenin olduğunu assert edin")
    public void ürünlerinIçindeFiltrelenenMalzemeninOlduğunuAssertEdin() {
        String malzemeList = driver.findElement(lürünÖzellikleri4).getText();

        try {
            Assert.assertTrue(malzemeList.contains(list.get(option).getText()));
        }catch (StaleElementReferenceException e){

        }

    }
}
