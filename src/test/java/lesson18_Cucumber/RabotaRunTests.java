package lesson18_Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/features/rabotaBy.feature"},
        plugin = {"json:target/cucumber.json"},
        glue = {"cucumber/rabotaBy"})

public class RabotaRunTests extends AbstractTestNGCucumberTests {
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
