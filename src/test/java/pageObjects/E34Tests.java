package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by gridfusion on 07/05/16.
 */
public class E34Tests {

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver","/Users/gridfusion/Downloads/geckodriver");
        System.setProperty("webdriver.chrome.driver", "/Users/gridfusion/Downloads/chromedriver");
    }

    @Test
    public void loginTest() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/hustef");

        E34TestPage myPage = new E34TestPage(driver);


        myPage.enterFirstName();
        myPage.enterLastName();
        Thread.sleep(3000);

        myPage.clickButton();

        driver.quit();

    }


}
