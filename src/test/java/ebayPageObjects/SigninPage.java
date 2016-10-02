package ebayPageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
	
	
	@FindBy(id="userid")
	private WebElement userid;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(id="sgnBt")
	private WebElement signinButton;
	
	public SigninPage(WebDriver driver) {
		driver.get("https://signin.ebay.de/ws/eBayISAPI.dll?SignIn");
	    PageFactory.initElements(driver, this);
	}
		
	public void enterUsername() {
		userid.clear();
		userid.sendKeys(EbayUtils.getUsername());
	}
	
	public void enterPassword() {
		password.sendKeys(EbayUtils.getPassword());
	}
	
	public void clickSigninButton() {
		signinButton.click();
	}
	
	
	public MyEbayPage signIn(WebDriver driver) {
		enterUsername();
		enterPassword();
		clickSigninButton();
		return new MyEbayPage(driver);
	}
	
	
}

