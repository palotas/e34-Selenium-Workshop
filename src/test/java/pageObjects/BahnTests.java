package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by gridfusion on 07/05/16.
 */
public class BahnTests {

    @DataProvider(name = "platforms", parallel = true)
    public Object[][] getCapabilities() {

        return new Object[][]{
                {DesiredCapabilities.firefox()},
                {DesiredCapabilities.chrome()},
                {DesiredCapabilities.edge()},
                //{DesiredCapabilities.internetExplorer()}
        };
    }


    @Test(dataProvider = "platforms", invocationCount = 20, threadPoolSize = 10)
    public void loginTest(DesiredCapabilities caps) throws InterruptedException, MalformedURLException {

        //WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
        //WebDriver driver = new RemoteWebDriver(new URL("https://789b1ea7eca7.element34.net/wd/hub"), caps);
        WebDriver driver = new RemoteWebDriver(new URL("http://vm-105.element34.net:4444/wd/hub"), caps);

        driver.manage().window().maximize();

        driver.get("http://www.bahn.de");
        driver.findElement(By.id("js-auskunft-autocomplete-from")).sendKeys("Frankfurt", Keys.ARROW_DOWN, Keys.TAB);
        driver.findElement(By.id("js-auskunft-autocomplete-to")).sendKeys("Hamburg", Keys.TAB, Keys.TAB);

        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[@id=\"js-tab-auskunft\"]/div/form/fieldset[5]/div/input[1]")).click();
        Thread.sleep(6000);

        Assert.assertEquals(driver.getTitle(), "DB BAHN - Verbindungen - Ihre Auskunft");
        driver.quit();

    }


}
