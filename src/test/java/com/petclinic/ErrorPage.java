package com.petclinic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by vyrly on 6/3/17.
 */
public class ErrorPage {
    private static By HonmeOwnersLink = By.linkText("Home");
    private static By findOwnersLink = By.linkText("Find owners");
    private static By veterinariansLink = By.linkText("Veterinarians");
    private static By errorLink = By.linkText("ErrorPage");
    private static By helpLink = By.linkText("Help");

    private WebDriver driver;

    public ErrorPage(WebDriver driver) {
        this.driver = driver;
        driver.get("http://localhost:8080/oups.html");
    }

    public FindOwnersPage goTo() {
        driver.findElement(findOwnersLink).click();
        return new FindOwnersPage(driver);
    }
}
