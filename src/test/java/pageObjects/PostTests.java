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

    @Test
    public void loginTest() throws InterruptedException, MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("firefox");
        //WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
        WebDriver driver = new RemoteWebDriver(new URL("https://789b1ea7eca7.element34.net/wd/hub"), caps);

        PostHomepage homepage = new PostHomepage(driver);
        PostSelectionDonePage selectionDone = new PostSelectionDonePage(driver);
        PostWarenkorbPage warenkorb = new PostWarenkorbPage(driver);

        homepage.openHomePage(driver);
        homepage.selectBrief20Gramm();
        selectionDone.clickAddToBasket(driver);
        selectionDone.selectShoppingBasket(driver);
        Assert.assertEquals(warenkorb.getSum(driver), "9,95 €");
        driver.quit();

    }


}
