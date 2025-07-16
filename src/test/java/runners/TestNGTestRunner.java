package runners;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.ExtentReportManager;

@CucumberOptions(
    features = "src/test/java/automationExercise",
    tags = "@tag1",
    glue = {"automationExercisesStepDefinitions","Hooks"},
    			    plugin = {
    			        "pretty",
    			        "json:target/cucumber.json",      // for future Allure or advanced usage
    			        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"// optional timeline report
    			    }
    			   
    			)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    
    @Override
    @DataProvider(parallel = false) // <---- Enables parallel execution
    public Object[][] scenarios() {
        return super.scenarios();
    }
    @AfterSuite
    public void flushExtentReport() {
        ExtentReportManager.getInstance().flush();
    }
}