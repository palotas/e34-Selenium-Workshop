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
	public void postTest() throws IOException, InterruptedException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		//caps.setVersion("58");

		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

		// navigate to the URL
		driver.get("https://www.deutschepost.de/de.html");
		//select Briefmarke
		driver.findElement(By.cssSelector("#omniture\\#homepage_stamps60\\#None > a:nth-child(1) > span:nth-child(1) > span:nth-child(1)")).click();
		//Assert.assertEquals(driver.getTitle(), "Briefmarken zu 70 ct - Onlineshop der Deutschen Post");
		//add to shopping basket
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("div.row:nth-child(4) > div:nth-child(1) > div:nth-child(1) > a:nth-child(6)")).click();

		//go to Warenkorb
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#locnav__button-basket")).click();
		Thread.sleep(5000);
		String summe = driver.findElement(By.cssSelector("td.table__td--text-right:nth-child(3)")).getText();
		Assert.assertEquals(summe, "9,95 €");
		Thread.sleep(2000);

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

