package cucumber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepDefinition"},
        plugin = {"pretty","json:target/jsonReports/cucumber-report.json"},
        monochrome = true,
        dryRun = false,
        tags = ""
)

public class TestRunner {
}