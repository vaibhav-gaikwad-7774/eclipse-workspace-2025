package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ParallelGoogleTest {
    private WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogleSearchPage() {
        driver.get("https://www.google.com");
        // Verify page title
        assertEquals(driver.getTitle(), "Google", "Page title does not match on " + driver.getClass().getSimpleName());
        // Verify search input field is present
        boolean isSearchFieldPresent = driver.findElement(By.name("q")).isDisplayed();
        assertTrue(isSearchFieldPresent, "Search input field not found on " + driver.getClass().getSimpleName());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}