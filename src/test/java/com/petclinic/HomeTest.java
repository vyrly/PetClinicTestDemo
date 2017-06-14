package com.petclinic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

import static com.petclinic.FindAllLinks.isLinkBroken;
import static org.junit.Assert.assertTrue;

public class HomeTest {
    private WebDriver driver;

    @Before
    public void setUpTest() {
        driver = new ChromeDriver();
        //user = new UserInteractions(driver);
    }

    @After
    public void tearDownTest() {
        driver.quit();
    }

    @Test
    public void chromeTest(){
        HomePage homePage = new HomePage(driver);
        FindOwnersPage findOwnersPage = homePage.goTo();
        assertTrue (findOwnersPage.checkIfFindOwnersPage());
    }

    @Test
    public void allLinks(){
        HomePage homePage = new HomePage(driver);
        java.util.List<WebElement> links = homePage.getAllLinks(driver);

        String title;

        for (WebElement webElement : links) {
            try {
                System.out.println("URL: " + webElement.getAttribute("href")+ " returned " + isLinkBroken(new URL(webElement.getAttribute("href"))));
                System.out.println(webElement.getAttribute("title"));
            }
            catch(Exception exp) {
                System.out.println("At " + webElement.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());
            }
        }
    }
}
