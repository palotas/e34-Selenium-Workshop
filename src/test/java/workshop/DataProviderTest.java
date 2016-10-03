package workshop;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@DataProvider(name = "urlprovider")
	public Object[][] createData1() {
		return new Object[][] {
				{"http://localhost:8080"},
				{"http://www.element34.net"},
				{"http://hustef.hu"}
		};
	}

	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
		System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
	}


	@Test(dataProvider="urlprovider")
	public void dataProvideTest(String url) {
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		System.out.println("Page title: " + driver.getTitle());
	}
}

