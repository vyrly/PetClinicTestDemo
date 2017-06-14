package com.petclinic;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;

public class AllLinksOnPage {
    private WebDriver driver;
    private java.util.List<WebElement> links;

    public AllLinksOnPage(WebDriver driver) {
        this.driver = driver;
    }

    private void get(WebDriver driver) {
        links = driver.findElements(By.tagName("a"));
    }

    public void verifyAllLinks() {
        String response;

        get(driver);

        for (WebElement webElement : links) {
            try {
                URL url = new URL(webElement.getAttribute("href"));
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                response = connection.getResponseMessage();
                connection.disconnect();
                System.out.println("URL: " + webElement.getAttribute("href") + " returned " + response);
                Assert.assertEquals("OK", response);
            } catch (Exception exp) {
                System.out.println("At " + webElement.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());
            }
        }
    }
}