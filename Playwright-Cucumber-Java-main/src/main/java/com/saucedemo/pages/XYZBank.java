package com.saucedemo.pages;

import static Framework.Constants.customerFirstName;
import static Framework.Constants.customerFullName;
import static Framework.Constants.customerLastName;
import static Framework.Constants.customerPostCode;
import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class XYZBank {
	Page page;
	List<String> customersName;

	public XYZBank(Page page) {
		this.page = page;
	}

	public static String getStringWithTimeStamp(String value) {
		DateFormat dateFormat = new SimpleDateFormat("_dMMMyy_HH.ms");
		String date = dateFormat.format(new Date());
		String randomString = value + date;
		return randomString;
	}

	public void userNavigatesToXYZBank() {
		page.navigate("https://www.nseindia.com/option-chain");
		//page.navigate("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
		
	}

	public void addNewCustomer() {
		page.click("//button[text()='Bank Manager Login']");
		// Filling the form for create new customer
		page.click("//button[normalize-space()='Add Customer']");
		customerLastName = getStringWithTimeStamp("User");
		customerFullName = customerFirstName + " " + customerLastName;
		System.out.println(customerFullName);
		page.fill("//input[@placeholder='First Name']", customerFirstName);
		page.fill("//input[@placeholder='Last Name']", customerLastName);
		page.fill("//input[@placeholder='Post Code']", customerPostCode);
		page.click("//button[@type='submit']");

	}

	public void openNewAccount() throws InterruptedException {
		page.click("//button[normalize-space()='Open Account']");
		// Select dropdown for creating new account for a new customer
		page.locator("//select[@id='currency']").selectOption("Dollar");
		page.locator("//select[@id='userSelect']").selectOption(new SelectOption().setLabel(customerFullName));
		page.click("//button[normalize-space()='Process']");
	}

	public void verifyDetails() {
		page.click("//button[normalize-space()='Customers']");
		// Assert the Customer details in the table...
		page.locator("//input[@placeholder='Search Customer']").fill(customerFirstName);
		Locator firstNameList = page.locator("//tr[@class='ng-scope']/td[1]");
		Locator lastNameList = page.locator("//tr[@class='ng-scope']/td[2]");
		Locator postCodeList = page.locator("//tr[@class='ng-scope']/td[3]");
		page.waitForSelector("//tr[@class='ng-scope']/td[1]");
		System.out.println("The count is ->" + firstNameList.count());
		Boolean valuePresent = false;
		for (int x = 0; x < firstNameList.count(); x++) {
			if (firstNameList.nth(x).textContent().trim().equalsIgnoreCase(customerFirstName)) {
				assertEquals(firstNameList.nth(x).textContent().trim(), customerFirstName);
				assertEquals(lastNameList.nth(x).textContent().trim(), customerLastName);
				assertEquals(postCodeList.nth(x).textContent().trim(), customerPostCode);
				valuePresent = true;
			}
			assertEquals(valuePresent, true);
		}
		page.click("//button[normalize-space()='Home']");
	}
	
	public void customerLogin() {
		page.waitForSelector("//button[normalize-space()='Customer Login']");
		page.click("//button[normalize-space()='Customer Login']");
		page.locator("//select[@id='userSelect']").selectOption(new SelectOption().setLabel(customerFullName));

	}
}
