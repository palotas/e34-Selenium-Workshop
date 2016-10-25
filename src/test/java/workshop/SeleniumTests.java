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


	@BeforeTest
	public void setup() {
		String OS = System.getProperty("os.name");

		switch (OS) {
			case "Linux":
				System.setProperty("webdriver.gecko.driver","/home/e34/Downloads/geckodriver");
				System.setProperty("webdriver.chrome.driver", "/home/e34/Downloads/chromedriver");
				break;

			case "Mac OS X":
				System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
				System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
				break;

			default:
				System.out.println(System.getProperty("os.name") + " is not supported ");
				break;
		}
	}


	@Test
	public void shouldOpenE34Page() throws IOException {

		WebDriver driver = new ChromeDriver();

		// navigate to the URL
		driver.get("http://www.element34.net");

		// close the Browser
		driver.quit();
	}


	@Test
	public void shouldPrintPagetitle() throws InterruptedException, IOException {

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
	public void shouldAssertPageTitle() throws InterruptedException, IOException {

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
	public void shouldCountNavEntires() throws InterruptedException, IOException {

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
	public void shouldScroll() throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		driver.get("http://localhost:8080");

		jse.executeScript("window.scrollBy(0,1000)", "");

		Thread.sleep(5000);
		driver.quit();
	}


	@Test
	public void shouldOpenRemoteWebdriver() throws InterruptedException, IOException {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("firefox");
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

		driver.get("http://localhost:8080");

		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void shouldNavigate() throws InterruptedException {

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



	@Test
	public void implicitWaitHeroku() throws InterruptedException, FileNotFoundException, IOException {


		WebDriver driver = new ChromeDriver();

		try {
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

			driver.findElement(By.cssSelector("#start > button")).click();
			Assert.assertEquals(driver.findElement(By.cssSelector("#finish")).getText(), "Hello World!");
		}

		finally {
			driver.quit();
		}
	}




	@Test
	public void explicitWait() throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {
			driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");

			driver.findElement(By.cssSelector("#start > button")).click();
			//wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish"))));
			Assert.assertEquals(driver.findElement(By.cssSelector("#finish")).getText(), "Hello World!");
		}
		finally {
			driver.quit();
		}
	}

	@Test
	public void radioButtonsCheckboxes() throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		try {

			driver.get("http://localhost:8080/hustef");
			//check if there are 2 radio buttons on the page
			Assert.assertEquals(driver.findElements(By.cssSelector("input[type='radio']")).size(), 2);

			//select female radio button and check if it checked
			WebElement femaleRadiobutton = driver.findElement(By.id("female"));
			femaleRadiobutton.click();
			Assert.assertTrue(femaleRadiobutton.isSelected());

		}
		finally {
			driver.quit();
		}
	}



	@Test
	public void screenshotTest() {
		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8080");
		try {
			DoScreenshot.takeScreenshot(driver);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}


}

