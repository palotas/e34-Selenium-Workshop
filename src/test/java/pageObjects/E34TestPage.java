package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by gridfusion on 07/05/16.
 */
public class E34TestPage {

    @FindBy(id="firstname")
    private WebElement firstName;

    @FindBy(id="lastname")
    private WebElement lastName;

    @FindBy(name="submitbutton")
    private WebElement button;




    public E34TestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName() {
        firstName.sendKeys("michael");
    }

    public void enterLastName() {
        lastName.sendKeys("palotas");
    }

    public void clickButton() {
        button.click();
    }

    public void login() {
        enterFirstName();
        enterLastName();
        clickButton();
    }


}
