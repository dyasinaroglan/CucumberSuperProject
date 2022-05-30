package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ParentClass;
import static Pages.LocatorsHomePage.*;

import java.util.List;

public class HomePageStepdefs extends ParentClass {

    @When("Ana sayfada yer alan tüm ürün resimlerinin tanımlı olması")
    public void anaSayfadaYerAlanÜrünResimlerininTanımlıOlması() {

        List<WebElement> productList = driver.findElements(lProductsİmg);
        for (WebElement element : productList) {
            Assert.assertTrue(!element.getAttribute("src").isEmpty());
        }
        System.out.println(productList.size());
    }
}
