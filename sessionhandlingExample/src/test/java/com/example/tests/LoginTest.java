package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Maximize window and navigate to the site
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testLogin() {
        // Enter username and password
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click login button
        driver.findElement(By.id("login-button")).click();

        // Verify that the page title is "Products"
        String pageTitle = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(pageTitle, "Products", "Dashboard did not load correctly");
    }

    @AfterMethod
    public void tearDown() {
        // Close browser after test
        driver.quit();
    }
}
