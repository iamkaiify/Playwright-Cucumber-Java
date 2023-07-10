package stepdefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.saucedemo.pages.Airbnb;

import io.cucumber.java.en.*;

public class AirbnbStep {
	Playwright playwright=Playwright.create();
	BrowserType chromium = playwright.chromium();
	Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page = browser.newPage();
	Airbnb airbnb=new Airbnb(page);
	
	
	
	@Given("User launched Airbnb application")
	public void user_launched_airbnb_application() {
	     airbnb.userNavigatesToAirbnb();
	}

	@Then("user book the room")
	public void user_book_the_room() {
	     airbnb.orderRoom();
	}
}
