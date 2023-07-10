package stepdefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.saucedemo.pages.GreenKart;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;

public class GreenKartStep {
	
	Playwright playwright=Playwright.create();
	BrowserType firefox = playwright.firefox();
	Browser browser = firefox.launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page = browser.newPage();
	GreenKart greenKart=new GreenKart(page);
	/*
	 * BeforeStep and AfterStep is different then Before and After it will  executes before and after of 
	 * every step of the feature file 
	 */
	 
	 

	 
	

	
	@Given("User launched GreenKart application")
	public void user_launched_green_kart_application() {
		 
		greenKart.navigateToGreenKart();
	}

	@Then("User add items into the cart")
	public void user_add_items_into_the_cart() {
		greenKart.addItems();
	}

	@Then("User proceed to checkout")
	public void user_proceed_to_checkout() {
		greenKart.proceedToCheckOut();
	     
	}

	@Then("User place order")
	public void user_place_order() {
		greenKart.userPlaceOrder();
	}


}
