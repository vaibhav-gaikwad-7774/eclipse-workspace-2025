package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

public class SessionHandlingTest {

    @Test
    public void testSessionHandling() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Launch URL
        driver.get("https://www.geeksforgeeks.org/");

        // Get session ID
        SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session ID for GeeksforGeeks: " + sessionId);

        // Close the browser
        driver.quit();
    }

    @Test
    public void testSessionHandlingGoogle() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Launch URL
        driver.get("https://www.google.com/");

        // Get session ID
        SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session ID for Google: " + sessionId);

        // Close the browser
        driver.quit();
    }

    @Test
    public void testSessionHandlingTutorialsPoint() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Launch URL
        driver.get("https://www.gmail.com/");

        // Get session ID
        SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
        System.out.println("Session ID for Gmail: " + sessionId);

        // Close the browser
        driver.quit();
    }
}
