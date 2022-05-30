package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.Hook;

@CucumberOptions(

        features = {"src/test/java/feature/login.feature"},
        glue = {"stepdefs","utils"}
)
public class Runner extends AbstractTestNGCucumberTests {
/*
   {
        Hook.path = "src/test/java";
        Hook.fileName = "runner.xlsx";
    }

 */
}
