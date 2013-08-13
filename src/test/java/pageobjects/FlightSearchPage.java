package pageobjects;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FlightSearchPage {
	
	private final WebDriver driver;
	
	
	@FindBy(id= "roundtrip-label")
	private WebElement roundtrip;

	@FindBy(id= "onewaytrip-label")
	private WebElement onewaytrip;
	
	@FindBy(id= "multi-label")
	private WebElement multicitytrip;
	
	@FindBy(id= "origin")
	private WebElement origin;

	@FindBy(id= "destination")
	private WebElement destination;
	
	@FindBy(id= "depart_date")
	private WebElement departureDate;
	
	@FindBy(id= "return_date")
	private WebElement returnDate;

	@FindBy(id= "fdimgbutton")
	private WebElement findButton;
	
	//constructor
	public FlightSearchPage(WebDriver d){
		this.driver = d;
		
		//if you comment this line out, you will get a nullpointer exception
		PageFactory.initElements(driver, this);
		
		Assert.assertEquals("KAYAK - Cheap Flights - Deals on Airline Tickets - Airfare - Compare Hundreds of Travel Sites", driver.getTitle());

	}
	
	//actions on the base page
	public void selectRoundtrip() {
		roundtrip.click();
	}

	public void selectOnewayTrip() {
		onewaytrip.click();
	}
	
	public void selectMulticityTrip() {
		multicitytrip.click();
	}
	
	public void enterOrigin() {
		origin.clear();
		origin.sendKeys("ZRH");
	}

	public void enterOriginDataProvider(String s) {
		origin.clear();
		origin.sendKeys(s);
	}
	
	public void enterDestination() {
		destination.clear();
		destination.sendKeys("JFK");
	}	
	
	public void enterDepartureDate() {
		departureDate.clear();
		departureDate.sendKeys("08/28/2013");
	}

	public void enterReturnDate() {
		returnDate.clear();
		returnDate.sendKeys("08/31/2013");
	}
	
	/*
	 * returns a FlightsResultPage as by pressing the submit button 
	 * we navigate to a new page
	 */
	
	public FlightsResultPage pressFindButton() {
		findButton.click();
		
		return new FlightsResultPage(driver);
	}
	
}

