package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.ParentClass;

import java.util.ArrayList;
import java.util.List;

import static Pages.SepetLocators.*;

public class SepetStepdefs extends ParentClass {

    @When("önceden belirlenmiş bir ürüne tıklanması")
    public void öncedenBelirlenmişBirÜrüneTıklanması() {
        clickTo(lfirstProduct);
        sleepTo(1000);
    }

    @And("Ürünün renk ve boyut özelliklerinin belirlenmesi ve sepete eklenmesi")
    public void ürününRenkVeBoyutÖzelliklerininBelirlenmesiVeSepeteEklenmesi() {
        Select builder = new Select(driver.findElement(lfirstSelect1));
        builder.selectByValue("blau");
        sleepTo(1000);
        Select builder2 = new Select(driver.findElement(lfirstSelect2));
        builder2.selectByValue("40");
        sleepTo(4000);
        clickTo(lSepeteEkleButton);
    }

    @And("ürünler sayfasına geri gidip ikinci bir ürün seçilmesi")
    public void ürünlerSayfasınaGeriGidipIkinciBirÜrünSeçilmesi() {
        sleepTo(5000);
        driver.navigate().back();
        clickTo(lsecondProduct);
        sleepTo(1000);
    }

    @And("seçilen ikinci ürünün renk ve boyut özellikleinin belirlenmesi ve sepete eklenmesi")
    public void seçilenIkinciÜrününRenkVeBoyutÖzellikleininBelirlenmesiVeSepeteEklenmesi() {
        Select builder = new Select(driver.findElement(lsecondSelect1));
        builder.selectByValue("braun");
        sleepTo(100);
        Select builder2 = new Select(driver.findElement(lsecondSelect2));
        builder2.selectByValue("m");
        sleepTo(3000);
        clickTo(lSepeteEkleButton);

    }

    @Then("Alışveris sepetinin görüntülenmesi butonuna tıklanması ve ürün fiyatlarının assert edilmesi")
    public void alışverisSepetininGörüntülenmesiButonunaTıklanmasıVeÜrünFiyatlarınınAssertEdilmesi() {
        sleepTo(1000);
        clickTo(lSepetinGörüntülenmesiButonu);
        List<WebElement> priceList = driver.findElements(lPriceList);

        List<String> sList = new ArrayList<>();
        for (WebElement element : priceList) {
            sList.add(element.getText());
        }
        String rPrice = null;
        for (String s : sList) {
            String[] parts = s.split(" ");
            for (int i = 0; i < parts.length; i++) {
                rPrice = parts[i].replaceAll("[^0-9.]", "");
                //ArrayIndexOutOfBoundsException --> dizide bulunmayan bir elamana ulaşılmaya çalışılırsa hata verir.
            }
        }
        String[] AA = rPrice.split(" ");
        System.out.println(AA[0] + "," + AA[1]);

        //Converting a String to a Double Array
        List<Double> dPrice = new ArrayList<Double>();
        for (int i = 0; i < AA.length; i++) {
            dPrice.add(Double.parseDouble(AA[i]));
            System.out.println(dPrice.get(i));
        }

    }
}
