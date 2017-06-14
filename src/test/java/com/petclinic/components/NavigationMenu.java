package com.petclinic.components;

import com.petclinic.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationMenu {
    @FindBy(linkText="Home")
    WebElement homeLink;

    @FindBy(linkText="Find owners")
    WebElement findOwnersLink;

    @FindBy(linkText="Veterinarians")
    WebElement veterinariansLink;

    @FindBy(linkText="ErrorPage")
    WebElement errorLink;

    @FindBy(linkText="Help")
    WebElement helpLink;

    private WebDriver driver;

    public NavigationMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage goToHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

    public FindOwnersPage goToFindOwnersPage() {
        findOwnersLink.click();
        return new FindOwnersPage(driver);
    }

    public VeterinariansPage goToVeterinariansPage() {
        veterinariansLink.click();
        return new VeterinariansPage(driver);
    }

    public ErrorPage goToErrorPage() {
        errorLink.click();
        return new ErrorPage(driver);
    }

    public HelpPage goToHelpPage() {
        helpLink.click();
        return new HelpPage(driver);
    }
}
