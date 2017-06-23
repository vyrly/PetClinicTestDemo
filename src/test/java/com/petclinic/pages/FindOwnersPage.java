package com.petclinic.pages;

import com.petclinic.components.NavigationMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindOwnersPage {
    private static final String pageURL = "http://localhost:8080/petclinic/owners/find.html";
    private final NavigationMenu navigationMenu;

    @FindBy(tagName="input")
    WebElement ownerLastNameInput;

    @FindBy(className="help-inline")
    WebElement ownerLastNameHelpInline;

    @FindBy(tagName="button")
    WebElement findOwnerBtn;

    @FindBy(linkText="Add Owner")
    WebElement addOwnerLink;

    private WebDriver driver;

    public FindOwnersPage(WebDriver driver) {
        this.driver = driver;
        navigationMenu = new NavigationMenu(driver);
        PageFactory.initElements(driver, this);
    }

    public FindOwnersPage open() {
        driver.get(pageURL);
        return this;
    }

    public String enterTextToOwnerLastNameInput(String lastName) {
        //ownerLastNameInput.click();
        new Actions(driver).moveToElement(ownerLastNameInput).click().sendKeys(lastName).perform();
        //new Actions(driver).sendKeys(lastName);
        //ownerLastNameInput.sendKeys(lastName);
        return ownerLastNameInput.getText();
    }

    public void clickFindOwnerButton() {
        findOwnerBtn.click();
    }

    public String getOwnerLastNameInput() {
        //This is the input element - need to get the value attribute
        return ownerLastNameInput.getAttribute("value");
    }

    public String getOwnerLastNameHelpInline() {
        return ownerLastNameHelpInline.getText();
    }

    public boolean checkIfFindOwnersPage() {
        return driver.getCurrentUrl().contains("/petclinic/owners/find.html");
    }
}
