package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchByCssSelectorTest {
    public static void main(String[] args) {
        // Step 1: Set up Chrome WebDriver
        WebDriverManager.chromedriver().setup();

        // Step 2: Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Step 3: Navigate to Google.com
            System.out.println("Navigating to Google.com...");
            driver.get("https://www.google.com");
            System.out.println("Navigated to: " + driver.getCurrentUrl());

            // Step 4: Locate search box using CSS Selector
            System.out.println("Locating search box using CSS Selector input[name='q']...");
            WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));
            System.out.println("Search box located.");

            // Step 5: Enter search query
            System.out.println("Typing 'Selenium WebDriver' into search box...");
            searchBox.sendKeys("Selenium WebDriver");
            System.out.println("Text entered.");

            // Step 6: Submit search
            System.out.println("Submitting search query...");
            searchBox.submit();
            System.out.println("Search submitted.");

            // Step 7: Print page title
            String pageTitle = driver.getTitle();
            System.out.println("Search Results Page Title: " + pageTitle);

        } catch (Exception e) {
            System.err.println("Error during test: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Step 8: Close browser
            System.out.println("Closing browser...");
            if (driver != null) {
                driver.quit();
            }
            System.out.println("Browser closed. Test finished.");
        }
    }
}