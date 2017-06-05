package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by gridfusion on 07/05/16.
 */
public class PostHomepage {

    @FindBy(css="#omniture\\#homepage_stamps60\\#None > a:nth-child(1) > span:nth-child(1) > span:nth-child(1)")
    private WebElement brief20gramm;


    public PostHomepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openHomePage(WebDriver driver) {
        driver.get("https://www.deutschepost.de/de.html");
    }

    public PostSelectionDonePage selectBrief20Gramm(WebDriver driver) throws InterruptedException {
        brief20gramm.click();
        return new PostSelectionDonePage(driver);
    }

}
