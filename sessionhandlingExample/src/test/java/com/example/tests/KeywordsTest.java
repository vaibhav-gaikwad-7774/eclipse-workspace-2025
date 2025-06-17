package com.example.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeywordsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        driver = new ChromeDriver();
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce", true},
            {"invalid_user", "wrong_pass", false}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean shouldPass) throws IOException {
        // Initialize Keywords object with path to properties file
        Keywords keywordObj = new Keywords("C:\\path\\to\\your\\project");

        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");

        // Using the custom 'click' method from Keywords class
        keywordObj.click(driver, "login-button", "ID");

        // Perform login using provided credentials
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        // Verify the page title or check if the dashboard loads
        boolean isDashboardDisplayed = driver.findElements(By.className("title")).size() > 0;
        Assert.assertEquals(isDashboardDisplayed, shouldPass, "Login test failed for " + username);
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after the test
        driver.quit();
    }
}
