package reporting;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;

public class DoScreenshot {

	final static String path = "/Users/Gridfusion/tmp/screenshots/";

	public static void takeScreenshot(WebDriver driver) throws Exception {
		
	  	RemoteWebDriver newDriver = (RemoteWebDriver)driver;
	  	File source = ((TakesScreenshot)newDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File(path + source.getName()));

    }

}
