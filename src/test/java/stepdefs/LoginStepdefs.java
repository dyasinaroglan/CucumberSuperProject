package stepdefs;

import excelUtilities.ExcelUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import utils.Hook;
import utils.ParentClass;

import java.io.IOException;

import static Pages.LocatorsLogin.*;

public class LoginStepdefs extends ParentClass {

    @Given("siteye gidiniz {string}")
    public void siteyeGidiniz(String url) throws IOException {

        gotoSite(url);
        clickTo(lCookies);
    }

    @And("geçerli {string} ve {string} ile login olunur")
    public void geçerliVeIleLoginOlunur(String userName, String password) {
        clickTo(lLoginButton);
        clickTo(lRegister);
        sendKeysTo(lUserName,userName);
        sendKeysTo(lPassword,password);
        clickTo(lRegister);
        clickTo(lHome);
    }

}
