package test; // Ensure this package matches your project structure

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchByNameTest { // Renamed the class for clarity
    public static void main(String[] args) {
        // Step 1: Set up the Chrome WebDriver
        // WebDriverManager automatically downloads and configures the correct ChromeDriver executable.
        WebDriverManager.chromedriver().setup();

        // Step 2: Initialize a new ChromeDriver instance
        // This command opens a new Chrome browser window.
        WebDriver driver = new ChromeDriver();

        try {
            // Step 3: Open Google.com
            System.out.println("Navigating to Google.com...");
            driver.get("https://www.google.com");
            System.out.println("Successfully navigated to: " + driver.getCurrentUrl());

            // Step 4: Locate the search box using By.name("q")
            // The 'q' is the common 'name' attribute for Google's search input field.
            System.out.println("Locating search box using By.name(\"q\")...");
            WebElement searchBox = driver.findElement(By.name("q"));
            System.out.println("Search box located.");

            // Step 5: Enter the search query "Selenium" into the search box
            System.out.println("Typing 'Selenium' into the search box...");
            searchBox.sendKeys("Selenium");
            System.out.println("Text entered.");

            // Step 6: Submit the search query
            // Calling submit() on a text field within a form simulates pressing 'Enter'.
            System.out.println("Submitting search query...");
            searchBox.submit();
            System.out.println("Search submitted.");

            // Step 7: Print the title of the search results page
            // This verifies that we've landed on the search results page.
            // You might add an Assert here in a formal test.
            String pageTitle = driver.getTitle();
            System.out.println("Current Page Title: " + pageTitle);

        } catch (Exception e) {
            System.err.println("An error occurred during the test: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Step 8: Close the browser
            // driver.quit() closes all browser windows opened by the WebDriver instance.
            System.out.println("Closing the browser...");
            if (driver != null) {
                driver.quit();
            }
            System.out.println("Browser closed. Test finished.");
        }
    }
}