package screenshot;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ScreenshotTest {
	
	@Test
	public void testWithScreenshot() throws Exception {
		
		WebDriver driver = util.AxaDriverFactory.createAxaRemoteFirefoxDriver();
		driver.get("http://gridfusion.net");
		DoScreenshot.takeScreenshotNoReport(driver);
		driver.quit();
	}


	@Test
	public void testWithScreenshotAndReportRemote() throws Exception {

		WebDriver driver = util.AxaDriverFactory.createAxaRemoteFirefoxDriver();
		
		driver.get("http://gridfusion.net");
		DoScreenshot.remoteWebDriverScreenshot(driver);
		driver.quit();
	}
	
}
