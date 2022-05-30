package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.est.LimitedSource;
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
        clickTo(lFavoriButton);
        sleepTo(1000);
        clickTo(lÜrünListesiGörüntüle);

        String actualUrün = driver.findElement(lactualÜrün).getText();
        String expectedUrün = driver.findElement(lexpectedÜrün).getText();

        Assert.assertTrue(actualUrün.contains(expectedUrün));

    }

    @Then("Favori listesine eklenen ürünün kaldırılması")
    public void favoriListesineEklenenÜrününKaldırılması() {

    }
}
