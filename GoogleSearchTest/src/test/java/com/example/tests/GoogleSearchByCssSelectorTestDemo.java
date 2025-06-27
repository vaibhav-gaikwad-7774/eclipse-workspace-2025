package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchByCssSelectorTestDemo {
    public static void main(String[] args) {
        // Use a StringBuilder to collect all output messages
        StringBuilder outputMessages = new StringBuilder();

        // Step 1: Set the path to Chromedriver manually
        // Replace this with the path where you downloaded chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe"); // Update this path

        outputMessages.append("Setting up Chrome WebDriver...\n");

        // Step 2: Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        outputMessages.append("ChromeDriver initialized. Browser opened.\n");

        try {
            // Step 3: Navigate to Google.com
            outputMessages.append("Navigating to Google.com...\n");
            driver.get("https://www.google.com");
            outputMessages.append("Landed on: ").append(driver.getCurrentUrl()).append("\n");

            // Step 4: Locate search box using CSS Selector
            outputMessages.append("Finding search box with CSS Selector 'input[name=\"q\"]'...\n");
            WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));
            outputMessages.append("Search box found.\n");

            // Step 5: Enter search query
            outputMessages.append("Entering 'Selenium WebDriver' into search box...\n");
            searchBox.sendKeys("Selenium WebDriver");
            outputMessages.append("Search query entered.\n");

            // Step 6: Submit search
            outputMessages.append("Submitting search...\n");
            searchBox.submit();
            outputMessages.append("Search submitted.\n");

            // Step 7: Print page title
            String pageTitle = driver.getTitle();
            outputMessages.append("Results Page Title: ").append(pageTitle).append("\n");

        } catch (Exception e) {
            outputMessages.append("!!! Test failed with error: ").append(e.getMessage()).append("\n");
            // For debugging, you might still want to print stack trace immediately or log to a file
            e.printStackTrace();
        } finally {
            // Step 8: Close browser
            outputMessages.append("Shutting down browser...\n");
            if (driver != null) {
                driver.quit();
                outputMessages.append("Browser closed.\n");
            }
            outputMessages.append("Test complete.\n");

            // Print all collected messages at the very end
            System.out.println("\n--- TEST EXECUTION SUMMARY ---\n" + outputMessages.toString());
        }
    }
}
