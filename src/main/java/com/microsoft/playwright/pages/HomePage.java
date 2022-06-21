package com.microsoft.playwright.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    private final Page page;
    private final Locator pageName;
    private final Locator menu;
    private final Locator logout;


    public HomePage(Page page) {
        this.page = page;
        this.pageName = page.locator("text=Products");
        this.menu = page.locator("#react-burger-menu-btn");
        this.logout = page.locator("text=LOGOUT");
    }


    public String getPageName() {
       return this.pageName.elementHandle().innerText();
    }

    public void logout(){
        this.menu.click();
        this.logout.click();
    }

}
