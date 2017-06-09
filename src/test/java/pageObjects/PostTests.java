package pageObjects;

import net.element34.Settings;
import net.element34.testng.Browsers;
import net.element34.testng.WebTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static net.element34.testng.MethodInstanceSession.webdriver;

/**
 * Created by gridfusion on 07/05/16.
 */
public class PostTests {


    @BeforeTest
    public void setup() {
        Settings.setHubUrl("http://vm-107.element34.net:4444");
    }

    @WebTest(video = true, browsers = Browsers.Dev)
    @Test(invocationCount = 1, threadPoolSize = 10)
    public void postTest() throws InterruptedException, MalformedURLException {



        PostHomepage homepage = new PostHomepage(webdriver());
        homepage.openHomePage(webdriver());

        PostSelectionDonePage selectionDone = homepage.selectBrief20Gramm(webdriver());
        selectionDone.clickAddToBasket(webdriver());

        PostWarenkorbPage warenkorb = selectionDone.selectShoppingBasket(webdriver());

        Assert.assertTrue(warenkorb.getSum(webdriver()).contains("9,95"), "Summe is: " + warenkorb.getSum(webdriver()));
        webdriver().quit();

    }


}
