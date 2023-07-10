package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashboardPage;
import pages.LoginPage;

public class RenewDataBundleSd {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("I am on the t-mobile my dashboard page")
    public void i_am_on_the_t_mobile_my_dashboard_page() {
        loginPage.login();
    }

    @When("my data bundle is under {int} mb")
    public void my_data_bundle_is_under_mb(int dataLimit) {
        dashboardPage.renewMBs(dataLimit);
    }

    @When("I want to renew it")
    public void i_want_to_renew_it() {
    }

    @Then("I am able to renew the data bundle")
    public void i_am_able_to_renew_the_data_bundle() {
    }
}
