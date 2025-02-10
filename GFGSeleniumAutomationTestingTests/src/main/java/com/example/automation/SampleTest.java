package com.example.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void openGoogle() {
        // Open Google and validate title
        driver.get("https://www.google.com");
        System.out.println("Page title is: " + driver.getTitle());
    }

    @AfterMethod
    public void teardown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
