package com.example.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open Google
            driver.get("https://www.google.com");

            // Find the search bar element and input a query
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver tutorial");

            // Submit the search form
            searchBox.submit();

            // Pause for a moment to observe the results
            Thread.sleep(2000);

            // Print the title of the resulting page
            System.out.println("Page title after search: " + driver.getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
