package runners;

import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {
		        "pretty",
		        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		        "rerun:target/failed_scenarios.txt"
		    },		

		features = "src/test/java/automationExercise",
		glue = {"automationExercisesStepDefinitions", "Hooks"},
		tags = "@Run",
		monochrome = true)

public class AutomateWebsite {

}


