package stepdefinitions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.saucedemo.pages.XYZBank;
  
import io.cucumber.java.en.*;

public class XYZBankStep {
 	Playwright playwright=Playwright.create();
	BrowserType chromium = playwright.chromium();
	Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page = browser.newPage();
	 
	 
	XYZBank xyzBank=new XYZBank(page); 
	
	
	
	@Given("User launch XYZ Banking application")
	public void user_launch_xyz_banking_application() {
		xyzBank.userNavigatesToXYZBank();
	}

	@Then("User Add new customer in Add Customer tab")
	public void user_add_new_customer_in_add_customer_tab() {
		xyzBank.addNewCustomer();
	}

	@Then("User open new account for a new customer in Open Account tab")
	public void user_open_new_account_for_a_new_customer_in_open_account_tab() throws InterruptedException {
		xyzBank.openNewAccount();
	}

	@Then("user verify details of new customer in Cutomers tab")
	public void user_verify_details_of_new_customer_in_cutomers_tab() {
		xyzBank.verifyDetails();
	}
	@When("User login by selecting name from dropdown")
	public void user_login_by_selecting_name_from_dropdown() {
		xyzBank.customerLogin();
	}

	@Then("User Deposits ammount of dollars")
	public void user_deposits_ammount_of_dollars() {
	     
	}

	@Then("User verify deposit ammount in Transaction tab")
	public void user_verify_deposit_ammount_in_transaction_tab() {
	     
	}
	@Then("User Withdrawl ammount of dollars")
	public void user_withdrawl_ammount_of_dollars() {
	     
	}

	@Then("User verify withdrawl ammount in Transaction ammount")
	public void user_verify_withdrawl_ammount_in_transaction_ammount() {
	     
	}


}
