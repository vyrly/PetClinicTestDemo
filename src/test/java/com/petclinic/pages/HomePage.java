package com.petclinic.pages;

import com.petclinic.components.NavigationMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private static final String homePageURL = "http://localhost:8080/petclinic/"; //TODO: Configurable?
    private final NavigationMenu navigationMenu;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        navigationMenu = new NavigationMenu(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage open() {
        driver.get(homePageURL);
        return this;
    }
}
