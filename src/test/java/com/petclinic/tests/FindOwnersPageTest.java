package com.petclinic.tests;


import com.petclinic.AllLinksOnPage;
import com.petclinic.pages.FindOwnersPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindOwnersPageTest {
    private WebDriver driver;
    private FindOwnersPage findOwnersPage;

    @Before
    public void setUpTest() {
        driver = new ChromeDriver();
    }

    @After
    public void tearDownTest() {
        driver.quit();
    }

    @Test
    public void allLinksOnPageShouldBeActive(){
        findOwnersPage = new FindOwnersPage(driver).open();
        AllLinksOnPage allLinksOnPage = new AllLinksOnPage(driver);
        allLinksOnPage.verifyAllLinks();
    }

    @Test
    public void errorMessageShouldBeDisplayedWithWrongOwnerName(){
        //Given
        findOwnersPage = new FindOwnersPage(driver).open();
        String input = "a";

        //When
        findOwnersPage.enterTextToOwnerLastNameInput(input);
        findOwnersPage.clickFindOwnerButton();

        //Then
        Assert.assertEquals("has not been found", findOwnersPage.getOwnerLastNameHelpInline());
        Assert.assertEquals(input, findOwnersPage.getOwnerLastNameInput());
    }

}
