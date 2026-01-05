package FeatureFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/FeatureFiles/Ninza.feature",glue = "StepDefinitions",
monochrome = true,plugin = {"html:target/cucumber.html"})
public class TestNGRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false) // Optional: For parallel execution
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
