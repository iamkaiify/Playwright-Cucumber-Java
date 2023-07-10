package com.saucedemo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import static org.testng.Assert.*;

public class Airbnb {
	Page page;
	String destination = "Ludhiana, Punjab";
	String month = "November";

	public Airbnb(Page page) {
		this.page = page;
	}

	public void userNavigatesToAirbnb() {

		page.navigate("https://www.airbnb.co.in/");

	}

	public void orderRoom() {
		page.click("//div[text()='Anywhere']");
		// Put values for selection of destination
		page.locator("//input[@id='bigsearch-query-location-input']").fill(destination);
		page.click("//button[@id='tab--tabs--2']");
		page.click("//label[@id='flexible_trip_lengths-one_week']");
		// select the months
		Locator monthCard = page.locator("//div[@class='_ko9bki']/div/div[1]");
		monthCard.locator(":scope", new Locator.LocatorOptions().setHasText(month)).locator("._ko9bki").click();

	}
}
