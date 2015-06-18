package htmlElementSamples;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleCheckBoxes {

		
	@Test
	public void checkboxTest() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();
		
		try {
			driver.get("http://gridfusion.net/testpage.html");
			
			WebElement checkBoxForm = driver.findElement(By.id("checkboxform"));
			
			//check how many checkboxes there are
			List<WebElement> checkBoxes = checkBoxForm.findElements(By.tagName("input"));
			Assert.assertEquals(checkBoxes.size(), 3);
			
			//Check if Salami (checkbox 1) is checked. If yes uncheck it
			Thread.sleep(2000);
			WebElement checkBox = checkBoxes.get(0);
			
			if(checkBox.isSelected()) {
				checkBox.click();				
			}
		
			Thread.sleep(2000);
		}
		finally {
			
			driver.quit();
		}
				
	}

}
