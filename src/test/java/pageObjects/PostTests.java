package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gridfusion on 07/05/16.
 */
public class PostTests {

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

    @Test(invocationCount = 1, threadPoolSize = 5)
    public void loginTest() throws InterruptedException, MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("MicrosoftEdge");
        //caps.setBrowserName("firefox");
        //caps.setBrowserName("chrome");
        //caps.setVersion("50");
        //WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
        WebDriver driver = new RemoteWebDriver(new URL("https://789b1ea7eca7.element34.net/wd/hub"), caps);

        PostHomepage homepage = new PostHomepage(driver);
        homepage.openHomePage(driver);

        PostSelectionDonePage selectionDone = homepage.selectBrief20Gramm(driver);
        selectionDone.clickAddToBasket(driver);

        PostWarenkorbPage warenkorb = selectionDone.selectShoppingBasket(driver);

        Assert.assertTrue(warenkorb.getSum(driver).contains("9,95"), "Summe is: " + warenkorb.getSum(driver));
        driver.quit();

    }


}
