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
public class PostSelectionDonePage {

    final String addToBasketLocator = "div.row:nth-child(4) > div:nth-child(1) > div:nth-child(1) > a:nth-child(6)";
    @FindBy(css=addToBasketLocator)
    private WebElement addToBasket;

    final String shoppingBasketLocator = "#locnav__button-basket";
    @FindBy(css = shoppingBasketLocator)
    private WebElement shoppingBasket;


    public PostSelectionDonePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAddToBasket(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(addToBasketLocator)));
        addToBasket.click();
    }

    public void selectShoppingBasket(WebDriver driver) throws InterruptedException {
        //WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait.until(ExpectedConditions.visibilityOf(shoppingBasket));
        Thread.sleep(5000);
        shoppingBasket.click();
    }

}
