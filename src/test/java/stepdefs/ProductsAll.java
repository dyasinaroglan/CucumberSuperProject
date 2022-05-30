package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.ParentClass;

import java.util.ArrayList;
import java.util.List;

import static Pages.ProductsAll_Locators.*;

public class ProductsAll extends ParentClass {
    @Given("Tüm ürünler butonuna tıklayınız")
    public void tümÜrünlerButonunaTıklayınız() {
        clickTo(lProductsAll);
    }

    @When("Tüm ürünlerin fiyat bilgisi olduğunun test edilmesi")
    public void tümÜrünlerinFiyatBilgisiOlduğununTestEdilmesi() {

        for (int i = 0; i < 2; i++) {
            List<WebElement> list = driver.findElements(lgetProductsAllPrice);
            for (WebElement element : list) {
                Assert.assertTrue(element.getAttribute("class").contains("price"));
            }
            WebElement scroll = driver.findElement(lnextPageNumber);
            scrollIntoView(scroll);
            clickTo(lnextPageNumber);
        }
        WebElement scroll = driver.findElement(lbackPageNumber);
        scrollIntoView(scroll);
    }

    @And("Tüm ürünlerin resimlerinin olduğunun test edilmesi")
    public void tümÜrünlerinResimlerininOlduğununTestEdilmesi() {

        for (int i = 0; i < 2; i++) {
            List<WebElement> list = driver.findElements(lgetProductsAllPictures);
            for (WebElement element : list) {
                Assert.assertTrue(!element.getAttribute("src").isEmpty());
            }
            WebElement scroll = driver.findElement(lbackPageNumber);
            scrollIntoView(scroll);
            clickTo(lbackPageNumber);
        }
    }

    @When("kategoriler butonuna tıklanması")
    public void kategorilerButonunaTıklanması() {

        clickTo(lCategories);
    }

    @And("Açılan ekrandan random kategori seçme")
    public void açılanEkrandanRandomKategoriSeçme() {
        WebElement element = driver.findElement(lSelectCategories); //options seçeneklerinin hepsini WebElement olarak aldım
        Select select = new Select(element); //Select class'ının içinde bu elememti yazıp Select class'ına bu optionlardan seçmesini istemiş oldum
        List<WebElement> list1 = select.getOptions(); //select.getOptions yaparak tüm optionsları List'in içine attım

        int options = list1.size(); //list1.size ı kadar int değer oluşturdum
        int option = random(options);  // en fazla bu options un uzuluğu kadar random sayı ürettim

        //String actualText = list1.get(3).getText().replaceAll("[0-9()]","");
        String actualText = list1.get(option).getText(); //option = random üretilen seçenek nereden? list1.get(option).getText
        System.out.println(list1.get(option).getText());
        sleepTo(1000);
        select.selectByIndex(option); //bu üretilen random sayı neyse bune karşılk geleni seçtiriyoruz
        String expectedText = driver.findElement(lTitleCategories).getText(); //buda ürün seçildikten sonra oraya gelen her neyse onun locatoru
        System.out.println(actualText + ", " + expectedText);
        Assert.assertTrue(actualText.contains(expectedText));

    }

    public static int random(int size) {
        return (int) (Math.random() * size);
    }

    @And("ortalama dereceye göre sıralanmış butonuna tıklanır")
    public void ortalamaDereceyeGöreSıralanmışButonunaTıklanır() {
        WebElement element = driver.findElement(lSiralamaSelect);
        Select builder = new Select(element);
        builder.selectByValue("price");
    }


    @Then("ürün fiyatlarının artan olarak sıralanması assert edilir")
    public void ürünFiyatlarınınArtanOlarakSıralanmasıAssertEdilir() {

        List<WebElement> price = driver.findElements(lAllProducts);

        for (int i = 0; i < price.size(); i++) {
            if (i % 2 == 0) {
                String a = ((price.get(i).getText()).replaceAll("[^0-9]", ""));
                int aa = Integer.parseInt(a) / 100;

                System.out.println(aa);
            }

        }

    }
    boolean asCending(List<Integer> data){
        for (int i = 0; i < data.size()-1; i++) {
            if(data.get(i) < data.get(i+1)){
                return true;
            }
        }
        return false;
    }
}
