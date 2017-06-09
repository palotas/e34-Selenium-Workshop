package pageObjects;

import net.element34.Settings;
import net.element34.testng.Browsers;
import net.element34.testng.WebTest;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import static net.element34.testng.MethodInstanceSession.screenshot;
import static net.element34.testng.MethodInstanceSession.webdriver;

/**
 * Created by gridfusion on 09.06.17.
 */
public class ReportingTest {
    @BeforeTest
    public void setup() {
        Settings.setHubUrl("http://vm-107.element34.net:4444");
    }

        @Test
        @WebTest(video = true, browsers = Browsers.Chrome)
        public void newtest() {
            webdriver().get("http://www.spiegel.de");
            System.out.println(webdriver().getTitle());
            screenshot("Homepage");
            webdriver().quit();
        }
    @Test
    @WebTest(video = true, browsers = Browsers.Chrome)
    public void newtest2() throws InterruptedException {
        webdriver().get("http://www.spiegel.de");
        System.out.println(webdriver().getTitle());
        Assert.assertTrue(true);
        Thread.sleep(2000);
        Assert.assertTrue(false);
        webdriver().quit();
    }

    }



