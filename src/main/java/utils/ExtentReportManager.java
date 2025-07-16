package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            // Automatically picks up extent.properties
            extent = new ExtentReports();
            String extentPropPath = System.getProperty("user.dir") + "/src/test/resources/extent.properties";
            ExtentSparkReporter spark = new ExtentSparkReporter(extentPropPath);

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Tester", "Kakarot");
        }
        return extent;
    }
}