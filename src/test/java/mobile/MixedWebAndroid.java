package mobile;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.uiautomation.ios.IOSCapabilities;

import screenshot.DoScreenshot;
import util.UserData;

public class MixedWebAndroid {
	
	public final String IP = "localhost";
	
	@Test(enabled=true)
	public void firefoxWebImbus() throws Exception {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("firefox");
		capability.setPlatform(Platform.LINUX);

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://"+ IP + ":6666/wd/hub"), capability);

		
		driver.get("http://www.imbus.de");
		WebElement link = driver.findElement(By.linkText("BERATUNG"));
		link.click();
		
		
		DoScreenshot.remoteWebDriverScreenshot(driver);
		Thread.sleep(2000);
		driver.quit();
	}
	

	
	
	@Test(enabled=true)
	public void chromeWebImbus() throws IOException, InterruptedException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setBrowserName("chrome");
		capability.setPlatform(Platform.LINUX);


		WebDriver driver = new RemoteWebDriver(new URL(
				"http://"+ IP + ":6666/wd/hub"), capability);

		driver.get("http://www.imbus.de");
		WebElement link = driver.findElement(By.linkText("BERATUNG"));
		link.click();
		
		DoScreenshot.remoteWebDriverScreenshot(driver);
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	
	@Test(enabled=true)
	public void androidWebImbus() throws Exception {

		DesiredCapabilities capability = DesiredCapabilities.android();
	    capability.setCapability(SelendroidCapabilities.EMULATOR,false);

		WebDriver driver = new RemoteWebDriver(new URL(
				"http://"+ IP + ":6666/wd/hub"), capability);

		
		driver.get("http://www.imbus.de");
		
		Thread.sleep(5000);
		WebElement link = driver.findElement(By.linkText("BERATUNG"));
		link.click();
		
		
		DoScreenshot.remoteWebDriverScreenshot(driver);
		Thread.sleep(2000);
		driver.quit();
	}
	
	

	
	@Test(enabled=true)
	public void nativeAndroidAppTest() throws Exception {
	  SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.9.0");
	  capa.setEmulator(false);
	  capa.setBrowserName("selendroid");
	  WebDriver driver = new SelendroidDriver(new URL("http://"+ IP + ":6666/wd/hub"),capa);
	  
	  try {
		  driver.findElement(By.id("startUserRegistration")).click();

		  // Enter user name
		  WebElement username = driver.findElement(By.id("inputUsername"));
		  username.sendKeys("johndoe");
	  }
	  finally {
		  driver.quit();		  
	  }
	}	
	
}
