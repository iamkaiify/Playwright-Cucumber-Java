package pages;

import com.microsoft.playwright.Page;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginPage {

    private Page page;

    //selectors
    private String loginBtn = "//a[@title='Login op My T-Mobile']";
    private String mobileProfileInput = "#selector-mobile";
    private String userNameInput = "//input[@data-interaction-id='login-username']";
    private String passwordInput = "//input[@data-interaction-id='login-password']";
    private String submitBtn = "//button[@type='submit']";

    public LoginPage() {
        this.page = Driver.page;
    }

    public void login() {
        page.click(loginBtn);
        page.click(mobileProfileInput);
        page.fill(userNameInput, ConfigReader.getProperty("username"));
        page.fill(passwordInput, ConfigReader.getProperty("password"));
        page.click(submitBtn);
    }
}
