package com.example.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class GoogleSearchLocalizationTest {

    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Set up ChromeOptions to add the language argument
        ChromeOptions options = new ChromeOptions();
        
        // You can change the locale here, for example, "he-IL" for Hebrew, "ar" for Arabic
        options.addArguments("--lang=he-IL");  // Setting the language to Hebrew
        
        // Initialize WebDriver with the options
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Wait for the title to reflect the locale change
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("Google"));  // Ensure the title contains Google

            // Check that the page title is localized correctly
            String expectedTitle = "גוגל";  // Hebrew for Google
            Assert.assertTrue(driver.getTitle().contains(expectedTitle), "Page title is incorrect for Hebrew locale");

            // Perform a Google search for "LambdaTest"
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("LambdaTest");
            searchBox.submit();

            // Wait for search results to load and verify the results
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'LambdaTest')]")));

            // Check if the search results contain the expected term
            WebElement searchResult = driver.findElement(By.xpath("//h3[contains(text(),'LambdaTest')]"));
            Assert.assertTrue(searchResult.isDisplayed(), "Search result is not displayed for LambdaTest");

        } finally {
            // Close the browser after the test
            driver.quit();
        }
    }
}
