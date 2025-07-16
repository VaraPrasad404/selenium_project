package Hooks;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.OpenBrowser;
import utils.ScreenshotUtil;
import utils.ExtentReportManager;

public class TestHooks {

    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Before
    public void launchbrowser(Scenario scenario) {
        WebDriver driver = OpenBrowser.setup();

        // Create ExtentTest and associate with thread
        ExtentTest test = ExtentReportManager.getInstance().createTest(scenario.getName());
        extentTest.set(test);

        test.log(Status.INFO, "🚀 Starting Scenario: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        ExtentTest test = extentTest.get();
        WebDriver driver = OpenBrowser.getDriver();

        if (scenario.isFailed() && driver != null) {
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, scenario.getName());
            test.fail("❌ Scenario Failed: " + scenario.getName());
            try {
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                test.warning("Screenshot attachment failed: " + e.getMessage());
            }
        } else {
            test.pass("✅ Scenario Passed: " + scenario.getName());
        }

        OpenBrowser.quitdriver();
    }
}