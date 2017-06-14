package com.petclinic.tests;

import com.petclinic.AllLinksOnPage;
import com.petclinic.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.junit.Assert.assertTrue;

public class HomeTest {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setUpTest() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver).open();
    }

    @After
    public void tearDownTest() {
        driver.quit();
    }

    @Test
    public void allLinksOnPageShouldBeActive(){
        AllLinksOnPage allLinksOnPage = new AllLinksOnPage(driver);
        allLinksOnPage.verifyAllLinks();
    }
}
