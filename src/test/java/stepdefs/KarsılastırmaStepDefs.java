package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ParentClass;

import java.util.List;

import static Pages.KarsılastırmaLocators.*;

public class KarsılastırmaStepDefs extends ParentClass {

    List<WebElement> list;
    int options;
    int option;

    @Given("All butonuna basıp tüm ürünlerden random bir ürün seçilmesi")
    public void allButonunaBasıpTümÜrünlerdenRandomBirÜrünSeçilmesi() {
        list = driver.findElements(lAllProducts);
        options = list.size();
        option = randomSayi(options);
        clickTo(lAllButton);
        sleepTo(1000);
        list.get(option).click();
        sleepTo(1000);
    }

    @And("ürün karşılaştırma butonuna tıklanması")
    public void ürünKarsılastırmaButonunaTıklanması() {
        clickTo(lKarsılastırmaButton);
    }

    @When("ürün karşılıştırma sayfasından çıkılması ve bir önceki sayfaya gidilmesi")
    public void ürünKarşılıştırmaSayfasındanÇıkılmasıVeBirÖncekiSayfayaGidilmesi() {
        sleepTo(3000);
        clickTo(lCloseButton);

    }
    @And("tekrar random bir ürün seçilmesi")
    public void tekrarRandomBirÜrünSeçilmesi() {
        sleepTo(1000);
        list = driver.findElements(lAllProducts);
        options = list.size();
        option = randomSayi(options);
        list.get(option).click();
        sleepTo(2000);
        clickTo(lKarsılastırmaButton);
        sleepTo(2000);

    }

    @Then("ürünlerin karşılaştırılması")
    public void ürünlerinKarşılaştırılması() {
        driver.switchTo().frame(0);
        List<WebElement> frameList = driver.findElements(iFrameProducts);
        for (int i = 0; i < frameList.size(); i++) {
            Assert.assertTrue(frameList.get(0).getText().contains(list.get(option).getText()) && frameList.get(1).getText().contains(list.get(option).getText()));

        }
        driver.switchTo().defaultContent();
    }
}

