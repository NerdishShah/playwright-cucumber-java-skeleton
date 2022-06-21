package com.microsoft.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.pages.LoginPage;
import com.microsoft.playwright.pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions{
    private LoginPage loginPage;
    private HomePage homePage;

    @Before
    public void setup() {
        Browser browser = Playwright.create().chromium().launch();
        Page page = browser.newPage();
        loginPage = new LoginPage(page);
    }

    @Given("I am on login page")
    public void iAmOnLoginPage() {
        loginPage.navigate();
    }

    @When("I login with valid credentials")
    public void iLoginWithValidCredentials() {
       homePage = loginPage.login("standard_user", "secret_sauce");
    }

    @Then("I should be displayed product listing page")
    public void iShouldBeDisplayedProductListingPage() {
        Assertions.assertEquals(homePage.getPageName(), "PRODUCTS");
    }

    @Then("I logout from the application")
    public void iLogoutFromTheApplication() {
        homePage.logout();
    }
}
