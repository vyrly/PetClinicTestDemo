package com.petclinic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;

public class FindAllLinks {

    public java.util.List<WebElement> getAllLinks(WebDriver driver) {
        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
        return links;
    }

    public static String isLinkBroken(URL url) throws Exception {
        String response;

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try {
            connection.connect();
            response = connection.getResponseMessage();
            connection.disconnect();
            return response;
        }
        catch(Exception exp) {
            return exp.getMessage();
        }
    }
}