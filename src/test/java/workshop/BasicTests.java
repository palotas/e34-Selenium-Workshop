package workshop;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;

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
	public void pageTitleTest() throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8080");
		String pageTitle = driver.getTitle();
		System.out.println("Page Title: " + pageTitle);

		try {
			Assert.assertEquals(pageTitle, "Apache Tomcat/8.0.37");
		}
		finally {
			Thread.sleep(2000);
			driver.quit();
		}
	}


	@Test
	public void findElementTest() throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8080");


		try {
			driver.findElement(By.id("nav-config")).click();
			Assert.assertEquals(driver.getTitle(), "Apache Tomcat 8 Configuration Reference (8.0.37) - Overview");
		}
		finally {
			Thread.sleep(2000);
			driver.quit();
		}
	}

	@Test
	public void countNavEntries() throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080");

		try {
			WebElement navigation = driver.findElement(By.id("navigation"));
			List<WebElement> navEntries = navigation.findElements(By.tagName("a"));
			Assert.assertEquals(navEntries.size(), 7);
		}
		finally {
			Thread.sleep(2000);
			driver.quit();
		}
	}

	@Test
	public void scroll() throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("http://localhost:8080");
		jse.executeScript("window.scrollBy(0,1000)", "");

		Thread.sleep(5000);
		driver.quit();
	}


	@Test
	public void remoteWebDriver() throws InterruptedException, IOException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

		driver.get("http://localhost:8080");

		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void navigationTest() throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8080");
		Thread.sleep(3000);

		driver.get("http://localhost:8080/docs/");
		Thread.sleep(3000);

		driver.navigate().back();
		Thread.sleep(3000);

		driver.navigate().forward();
		Thread.sleep(3000);

		driver.navigate().refresh();
		Thread.sleep(3000);
		driver.quit();
	}

}

