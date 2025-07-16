package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowser {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver setup() {

        String browser = ConfigReader.getProperty("browser");
        String headlessProp = ConfigReader.getProperty("headless");
        String url = ConfigReader.getProperty("mainurl");
        boolean isheadless = headlessProp != null && headlessProp.equalsIgnoreCase("true");

        System.out.println(Thread.currentThread().getName() + " → browser: " + browser + ", url: " + url);

        if (getDriver() == null) {
            if ("chrome".equalsIgnoreCase(browser)) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                
                if(isheadless) {
                	options.addArguments("--headless=new");
                	options.addArguments("--window-size=1920,1080");
                	
                }
                driver.set(new ChromeDriver(options));
                
            } else if ("firefox".equalsIgnoreCase(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
            } else if ("edge".equalsIgnoreCase(browser)) {
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
            } else {
                throw new RuntimeException("Unsupported browser: " + browser);
            }

            getDriver().manage().window().maximize();
            getDriver().get(url);
        }

        return getDriver();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitdriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();  // Very important to clear thread data
        }
    }
}