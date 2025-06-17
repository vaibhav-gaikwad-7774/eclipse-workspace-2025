package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        // Set up ChromeDriver automatically
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void testLogin() {
        // Navigate to the demo site
        driver.get("https://www.saucedemo.com");

        // Enter username
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        usernameField.sendKeys("standard_user");

        // Enter password
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.sendKeys("secret_sauce");

        // Click login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        loginButton.click();

        // Verify login success
        WebElement inventoryContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));
        assertTrue(inventoryContainer.isDisplayed(), "Login failed: Inventory list not displayed");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}