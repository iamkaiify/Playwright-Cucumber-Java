package com.saucedemo.pages;

import static org.testng.Assert.*;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class GreenKart {
	Page page;
	List<String> checkOutItems;
	List<String> checkOutItemsPriceTotal;
	int checkoutTotal = 0;

	public GreenKart(Page page) {
		this.page = page;
	}

	public void navigateToGreenKart() {
		page.navigate("https://rahulshettyacademy.com/seleniumPractise/#/");
		assertTrue(page.title().equalsIgnoreCase("GreenKart - veg and fruits kart"), "The title is not matched");
		assertTrue(page.url().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/"),
				"The URL is not matched");

	}

	public void addItems() {
		Locator card = page.locator("//div[@class='product']");

		// put Cucumber in to the cart
		card.locator(":scope", new Locator.LocatorOptions().setHasText("Cucumber - 1 Kg")).locator(".increment")
				.dblclick();
		card.locator(":scope", new Locator.LocatorOptions().setHasText("Cucumber - 1 Kg")).locator(".product-action")
				.click();

		// put Betroot in to the cart
		card.locator(":scope", new Locator.LocatorOptions().setHasText("Beetroot - 1 Kg")).locator(".increment")
				.dblclick();
		card.locator(":scope", new Locator.LocatorOptions().setHasText("Beetroot - 1 Kg")).locator(".product-action")
				.click();
	}

	public void proceedToCheckOut() {
		page.locator("//a[@class='cart-icon']").click();

		// all added items
		checkOutItems = page.locator("//p[@class='product-name']").allTextContents();
		System.out.println(checkOutItems);

		// total ammount of added items
		checkOutItemsPriceTotal = page.locator("(//ul[@class='cart-items'])[1]/descendant::p[@class='amount']")
				.allTextContents();

		for (int x = 0; x < checkOutItemsPriceTotal.size(); x++) {
			Integer.parseInt(checkOutItemsPriceTotal.get(x));

		}
		checkoutTotal = checkOutItemsPriceTotal.stream().mapToInt(Integer::valueOf).sum();
		System.out.println("The totalOrderValue-->" + checkoutTotal);

		page.click("//button[text()='PROCEED TO CHECKOUT']");

	}

	public void userPlaceOrder() {
		int totalOrderValue = Integer.parseInt(page.locator("//span[@class='totAmt']").textContent().trim());
		System.out.println("The totalOrderValue-->" + totalOrderValue);
		// Compare The values of both Order total value and Check out total value
		assertEquals(totalOrderValue, checkoutTotal);
		page.click("//button[text()='Place Order']");

		// select Country from dropdown 
		page.locator("select").selectOption("Algeria");
		
		//try to proceed without click checkbox
		page.click("//button[text()='Proceed']");
		String message=page.locator("//span[@class='errorAlert']").textContent().trim();
		assertEquals(message,"Please accept Terms & Conditions - Required");
	
		//process after click the checkbox
		page.click("//input[@type='checkbox']");
		page.click("//button[text()='Proceed']");
	}
}
