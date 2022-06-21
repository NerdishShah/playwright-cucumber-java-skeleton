package com.microsoft.playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {

    private final Page page;
    private final Locator username;
    private final Locator password;

    public LoginPage(Page page){
        this.page = page;
        this.username = page.locator("#user-name");
        this.password= page.locator("#password");

    }

    public void navigate(){
        page.navigate("https://www.saucedemo.com/");
        if (!"Swag Labs".equals(page.title())) {
            throw new IllegalStateException("Unable to launch application");
        }
    }

    public HomePage login(String username, String password){
        this.username.fill(username);
        this.password.fill(password);
        this.password.press("Enter");
        return new HomePage(this.page);
    }

}
