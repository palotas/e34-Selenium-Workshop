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

    final String addToBasketLocator = "actionbutton--addtobasket";
    @FindBy(className=addToBasketLocator)
    private WebElement addToBasket;

    final String shoppingBasketLocator = "#locnav__button-basket";
    @FindBy(css = shoppingBasketLocator)
    private WebElement shoppingBasket;


    public PostSelectionDonePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAddToBasket(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.className(addToBasketLocator)));
        addToBasket.click();
    }

    public PostWarenkorbPage selectShoppingBasket(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(shoppingBasketLocator)));
        Thread.sleep(5000);
        shoppingBasket.click();

        return new PostWarenkorbPage(driver);
    }

}
