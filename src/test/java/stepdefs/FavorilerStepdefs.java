package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.est.LimitedSource;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ParentClass;

import java.util.List;

import static Pages.FavorilerLocators.*;

public class FavorilerStepdefs extends ParentClass {
    @Given("All butonuna basıp tüm ürünlerin görüntülenmesi")
    public void allButonunaBasıpTümÜrünlerinGörüntülenmesi() {
        clickTo(lAllButton);
    }

    @When("random tıklanan ürünün favorilere eklenmesi")
    public void randomTıklananÜrününFavorilereEklenmesi() {
        List<WebElement> list = driver.findElements(lAllProducts);
        list.get(randomSayi(list.size())).click();
    }

    @And("favori listesinin görüntülenmesi ve bunun Assert edilmesi")
    public void favoriListesininGörüntülenmesiVeBununAssertEdilmesi() {
        sleepTo(1000);

        sleepTo(2000);
        clickTo(lFavoriButton);
        sleepTo(4000);
        WebElement element = driver.findElement(lÜrünListesiGörüntüle);
        element.click();

        String actualUrün = driver.findElement(lactualÜrün).getText();
        String expectedUrün = driver.findElement(lexpectedÜrün).getText();

        Assert.assertTrue(actualUrün.contains(expectedUrün));

    }

    @Then("Favori listesine eklenen ürünün kaldırılması")
    public void favoriListesineEklenenÜrününKaldırılması() {
        sleepTo(2000);
        clickTo(lKaldırButton);
    }

    @When("menuBarda yer alan Arama butonuna tıklayınız")
    public void menubardaYerAlanAramaButonunaTıklayınız() {
        sleepTo(1000);
        clickTo(lCookies);
        clickTo(lAramaButonu);
    }

    @And("arama butonuna ürün ismi girilir")
    public void aramaButonunaÜrünIsmiGirilir() {
        sleepTo(1000);
        sendKeysTo(lAramaText, "Bracelet" + Keys.ENTER);
    }

    @Then("Arama sayfasının görüntülenmesi")
    public void aramaSayfasınınGörüntülenmesi() {
        List<WebElement> list = driver.findElements(lÜRrünlerListesi);
        //aranan text ile liste içindeki textlerin karşılaştırılması
        for (WebElement i : list) {
            Assert.assertTrue(i.getText().contains("Bracelet"));

        }
    }

    @When("sol altta yer alan arama butonuna gelip ürün arattırınız")
    public void solAlttaYerAlanAramaButonunaGelipÜrünArattırınız() {
        scrollIntoView(driver.findElement(lAramaButonu2));
        sleepTo(1000);
        sendKeysTo(lAramaButonu2,"Bracelet"+Keys.ENTER);
        sleepTo(1000);
    }
}
