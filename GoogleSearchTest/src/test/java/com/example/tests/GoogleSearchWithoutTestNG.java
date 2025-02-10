package com.example.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchWithoutTestNG {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to Google.com
        driver.get("https://www.google.com");

        // Find the search box element by name and enter the search query
        driver.findElement(By.name("q")).sendKeys("Selenium WebDriver");

        // Simulate hitting the Enter key
        driver.findElement(By.name("q")).submit();

        // Pause execution for a few seconds to see the results
        Thread.sleep(3000);

        // Validate the search result page title contains the search query
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);

        // Basic validation
        if (pageTitle.contains("Selenium WebDriver")) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }

        // Close the browser
        driver.quit();
    }
}
