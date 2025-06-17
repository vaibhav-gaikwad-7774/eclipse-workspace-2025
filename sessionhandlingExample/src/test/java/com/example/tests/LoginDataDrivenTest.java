package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataDrivenTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Navigate to Sauce Demo login page
        driver.get("https://www.saucedemo.com/");
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"standard_user", "secret_sauce", true},
            {"invalid_user", "wrong_pass", false}
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean shouldPass) {
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        boolean isDashboardDisplayed = driver.findElements(By.className("title")).size() > 0;

        Assert.assertEquals(isDashboardDisplayed, shouldPass, "Login test failed for user: " + username);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
