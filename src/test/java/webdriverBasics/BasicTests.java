package webdriverBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BasicTests {


	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
		System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
	}


	@Test
	public void firstTest() throws IOException {

		WebDriver driver = new ChromeDriver();

		// navigate to the URL
		driver.get("http://www.element34.net");

		// close the Browser
		driver.quit();
	}


	@Test
	public void pageTitleTest() throws InterruptedException, FileNotFoundException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.element34.net");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);
		
		Thread.sleep(2000);
		driver.quit();
	}
	

}

