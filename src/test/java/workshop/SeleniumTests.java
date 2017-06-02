package workshop;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.ExpectedExceptions;
import org.testng.annotations.Test;
import reporting.DoScreenshot;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTests {


	@Test(invocationCount = 1, threadPoolSize = 1)
	public void bahnTest() throws IOException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		//caps.setVersion("58");

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

		// navigate to the URL
		driver.get("http://www.bahn.de");
		driver.findElement(By.id("js-auskunft-autocomplete-from")).sendKeys("Frankfurt", Keys.TAB);
		driver.findElement(By.id("js-auskunft-autocomplete-to")).sendKeys("Hamburg", Keys.TAB);
		driver.findElement(By.name("date")).sendKeys("20.06.2017");
		driver.findElement(By.name("time")).sendKeys("09:00");
		driver.findElement(By.xpath("//*[@id=\"js-tab-auskunft\"]/div/form/fieldset[5]/div/input[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"resultsOverview\"]/tbody[2]/tr[3]/td[4]/span/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div[2]/table[1]/tbody[2]/tr/td[4]/div/span/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"BCRCon\"]/div[5]/p[1]/span/button/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("nameRadioGroupLogin3")).click();
		driver.findElement(By.xpath("//*[@id=\"button.weiter\"]/span")).click();
		driver.findElement(By.xpath("//*[@id=\"buchenwunsch-button-weiter-id\"]/span")).click();



		Thread.sleep(3000);

		// close the Browser
		driver.quit();
	}




	@Test(invocationCount = 10, threadPoolSize = 10)
	public void sboxDemo1() throws IOException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		//caps.setVersion("58");


		WebDriver driver = new RemoteWebDriver(new URL("https://789b1ea7eca7.element34.net/wd/hub"), caps);

		// navigate to the URL
		driver.get("http://www.twitter.com");

		for (int i=0; i<=10; i++) {
			driver.getTitle();
			driver.getCurrentUrl();
			Thread.sleep(1000);

		}


		// close the Browser
		driver.quit();
	}

	@Test(invocationCount = 1, threadPoolSize = 10)
	public void sboxDemo2() throws IOException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("firefox");
		caps.setVersion("52");


		WebDriver driver = new RemoteWebDriver(new URL("https://789b1ea7eca7.element34.net/wd/hub"), caps);

		// navigate to the URL
		driver.get("http://www.facebook.com");

		Thread.sleep(2000);

		// close the Browser
		driver.quit();
	}





}

