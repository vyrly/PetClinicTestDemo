package com.petclinic.pages;

import com.petclinic.components.NavigationMenu;
import org.openqa.selenium.WebDriver;

public class HelpPage {
    private final NavigationMenu navigationMenu;

    private WebDriver driver;

    public HelpPage(WebDriver driver) {
        this.driver = driver;
        navigationMenu = new NavigationMenu(driver);
    }
}
