package com.geeks.SeleniumTestProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

public class GoogleLocalizationTest {

    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup(); // WebDriverManager automatically handles the driver setup

        // Set up ChromeOptions to add the language argument
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=he-IL");  // Set the language to Hebrew
        
        // Initialize WebDriver with the options
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Wait until the title contains "Google" to ensure page is loaded
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains("Google"));

            // Assert the page title in Hebrew
            String expectedTitle = "גוגל";  // Hebrew for Google
            Assert.assertTrue(driver.getTitle().contains(expectedTitle), "Page title is incorrect for Hebrew locale");

            // Perform a Google search for "LambdaTest"
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("LambdaTest");
            searchBox.submit();

            // Wait until the search result is displayed
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'LambdaTest')]")));

            // Check if the search result is displayed for LambdaTest
            WebElement searchResult = driver.findElement(By.xpath("//h3[contains(text(),'LambdaTest')]"));
            Assert.assertTrue(searchResult.isDisplayed(), "Search result is not displayed for LambdaTest");

        } catch (Exception e) {
            // Handle any exceptions that might occur during test execution
            e.printStackTrace();
            Assert.fail("Test failed due to an exception: " + e.getMessage());
        } finally {
            // Close the browser after the test
            driver.quit();
        }
    }
}
