package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
	
	public static String takeScreenshot(WebDriver driver, String scenarioname) {
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String screenshotname = scenarioname.replaceAll(" ", "_") + "_" + timestamp + ".png";
		String screenshotDirPath = System.getProperty("user.dir") + "/screenshots";
		String screenshotpath = screenshotDirPath + "/" + screenshotname;

		// Step 1: Create only the screenshots folder (if it doesn't exist)
		File screenshotDir = new File(screenshotDirPath);
		if (!screenshotDir.exists()) {
		    screenshotDir.mkdirs();
		}

		// Step 2: Save screenshot file
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destfile = new File(screenshotpath);

		try {
		    FileUtils.copyFile(srcfile, destfile);
		    System.out.println("Screenshot saved at: " + screenshotpath);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		return screenshotpath;
		
	}

}
