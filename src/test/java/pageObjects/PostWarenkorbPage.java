package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by gridfusion on 07/05/16.
 */
public class PostWarenkorbPage {

    final String totalLocator = "td.table__td--text-right:nth-child(3)";
    @FindBy(css=totalLocator)
    private WebElement total;



    public PostWarenkorbPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getSum(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(totalLocator)));
        return total.getText();
    }


}
