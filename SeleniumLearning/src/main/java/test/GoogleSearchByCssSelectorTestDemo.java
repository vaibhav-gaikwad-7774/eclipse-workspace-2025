//package test;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class GoogleSearchByCssSelectorTestDemo {
//    public static void main(String[] args) {
//        // Step 1: Set up Chrome WebDriver
//        WebDriverManager.chromedriver().setup();
//
//        // Step 2: Initialize ChromeDriver
//        WebDriver driver = new ChromeDriver();
//
//        try {
//            // Step 3: Navigate to Google.com
//            System.out.println("Opening Google.com...");
//            driver.get("https://www.google.com");
//            System.out.println("Landed on: " + driver.getCurrentUrl());
//
//            // Step 4: Locate search box using CSS Selector
//            System.out.println("Finding search box with CSS Selector input[name='q']...");
//            WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));
//            System.out.println("Search box found.");
//
//            // Step 5: Enter search query
//            System.out.println("Entering 'Selenium WebDriver' into search box...");
//            searchBox.sendKeys("Selenium WebDriver");
//            System.out.println("Search query entered.");
//
//            // Step 6: Submit search
//            System.out.println("Submitting search...");
//            searchBox.submit();
//            System.out.println("Search submitted.");
//
//            // Step 7: Print page title
//            String pageTitle = driver.getTitle();
//            System.out.println("Results Page Title: " + pageTitle);
//
//        } catch (Exception e) {
//            System.err.println("Test failed with error: " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            // Step 8: Close browser
//            System.out.println("Shutting down browser...");
//            if (driver != null) {
//                driver.quit();
//            }
//            System.out.println("Browser closed. Test complete.");
//        }
//    }
//}



package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchByCssSelectorTestDemo {
    public static void main(String[] args) {
        // Use a StringBuilder to collect all output messages
        StringBuilder outputMessages = new StringBuilder();

        // Step 1: Set up Chrome WebDriver
        WebDriverManager.chromedriver().setup();
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