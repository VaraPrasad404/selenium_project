package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "@target/failed_scenarios.txt",
    glue = {"automationExercisesStepDefinitions", "Hooks"},
    plugin = {
        "pretty",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
)

public class FailedTestRunner {

}
