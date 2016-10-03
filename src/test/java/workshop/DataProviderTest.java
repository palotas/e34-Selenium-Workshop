package webdriverBasics;

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

	@DataProvider(name = "urlprovider", parallel=true)
	public Object[][] createData2() {
	 return new Object[][] {
	   {"1", "de", "Cloud Logistik Software für Transport Management"},
	   {"2", "en", "Cloud Logistics Software for Transportation Management"},
	   {"3", "fr", "TRANSPOREON - TMS Leader en Europe - La plateforme de communication logistique entre chargeurs et transporteurs"}
	 };
	}


	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
		System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
	}

	@Test(dataProvider="urlprovider")
	public void dataproviderTest(String testcaseId, String language, String expectedTitle) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		try{
			driver.get("https://www.transporeon.com/" + language);
			System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), expectedTitle);	
		}
		finally{
			Thread.sleep(2000);
			driver.quit();	
		}	
	}
}

