import net.element34.Settings;
import net.element34.testng.Browsers;
import net.element34.testng.WebTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static net.element34.testng.MethodInstanceSession.screenshot;
import static net.element34.testng.MethodInstanceSession.webdriver;

/**
 * Created by gridfusion on 07/05/16.
 */
public class DemoTests {


    @BeforeTest
    public void setup() {
        Settings.setHubUrl("http://192.168.34.106:4444");
    }


    @WebTest(video = true, browsers = Browsers.Dev)
    @Test
    public void postTest() throws InterruptedException, MalformedURLException {
        PostHomepage homepage = new PostHomepage(webdriver());
        homepage.openHomePage(webdriver());

        PostSelectionDonePage selectionDone = homepage.selectBrief20Gramm(webdriver());
        selectionDone.clickAddToBasket(webdriver());

        PostWarenkorbPage warenkorb = selectionDone.selectShoppingBasket(webdriver());

        Assert.assertTrue(warenkorb.getSum(webdriver()).contains("9,95"), "Summe is: " + warenkorb.getSum(webdriver()));
        webdriver().quit();

    }



    @WebTest(video = true, browsers = Browsers.Dev)
    @Test(invocationCount = 1, threadPoolSize = 10, enabled = true)
    public void bahnTest() throws InterruptedException, MalformedURLException {
        webdriver().get("http://www.bahn.de");
        webdriver().findElement(By.id("js-auskunft-autocomplete-from")).sendKeys("Frankfurt", Keys.ARROW_DOWN, Keys.TAB);
        webdriver().findElement(By.id("js-auskunft-autocomplete-to")).sendKeys("Hamburg", Keys.TAB, Keys.TAB);
        screenshot("cities entered");

        Thread.sleep(6000);
        webdriver().findElement(By.xpath("//*[@id=\"js-tab-auskunft\"]/div/form/fieldset[5]/div/input[1]")).click();
        Thread.sleep(6000);
        screenshot("after button was clicked");

        Assert.assertEquals(webdriver().getTitle(), "DB BAHN - Verbindungen - Ihre Auskunft");
        webdriver().quit();
    }


    @WebTest(video = true, browsers = Browsers.Chrome)
    @Test(invocationCount = 5, threadPoolSize = 10, enabled = false)
    public void e34StaticTest() throws InterruptedException, MalformedURLException {

        webdriver().get("http://static.e34.lan:8080/www/index2.html");
        Thread.sleep(3000);
        webdriver().quit();
    }

    @WebTest(video = true, browsers = Browsers.Chrome)
    @Test(invocationCount = 5, threadPoolSize = 10, enabled = false)
    public void e34Test() throws InterruptedException, MalformedURLException {

        webdriver().get("http://static.e34.lan:8080/e34/index.html");
        Thread.sleep(3000);
        webdriver().quit();
    }


}
