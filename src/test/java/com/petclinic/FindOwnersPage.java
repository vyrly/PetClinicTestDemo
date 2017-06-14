package com.petclinic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by vyrly on 6/3/17.
 */
public class FindOwnersPage {
    private static By ownerLastNameInput = By.id("lastName");
    private static By findOwnerBtn = By.cssSelector("input[type=\"submit\"]");
    private static By addOwnerLink = By.linkText("Add Owner");

    private WebDriver driver;

    public FindOwnersPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://localhost:8080/petclinic/owners/find.html");
    }

    public boolean checkIfFindOwnersPage() {
        return driver.getCurrentUrl().contains("/petclinic/owners/find.html");
    }
}
