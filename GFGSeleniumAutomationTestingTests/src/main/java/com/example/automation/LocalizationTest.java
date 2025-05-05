package com.example.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalizationTest {
    public static void main(String[] args) {
        // Set up ChromeDriver dynamically using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeOptions and set locale to French (fr-FR)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=fr-FR"); // Setting French as the language

        // Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to the website you want to test
            driver.get("https://www.google.com");

            // Wait for the page title to reflect the language change
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("Google"));

            // Validate the page content based on locale (e.g., French title)
            String expectedTitle = "Google";
            if ("fr-FR".equals(options.getCapability("browserName"))) {
                expectedTitle = "Google";  // French Google homepage title
            }

            // Check if the page title matches the expected title
            if (driver.getTitle().contains(expectedTitle)) {
                System.out.println("Localization is correct for French.");
            } else {
                System.out.println("Localization is incorrect.");
            }

            // Perform a Google search for "LambdaTest"
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("user");
            searchBox.submit();

            // Wait for the search results to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));

            // Check if the search results contain the expected term
            WebElement searchResult = driver.findElement(By.xpath("//h3[contains(text(),'LambdaTest')]"));
            if (searchResult.isDisplayed()) {
                System.out.println("Search result is displayed correctly in French.");
            } else {
                System.out.println("Search result not found.");
            }

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
