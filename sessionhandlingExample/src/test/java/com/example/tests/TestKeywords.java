package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;

public class TestKeywords {

    public static void main(String[] args) throws IOException {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Initialize Keywords object with path to properties file
        Keywords keywordObj = new Keywords("C:\\path\\to\\your\\project");

        // Navigate to a website
        driver.get("https://www.saucedemo.com/");

        // Example of clicking a button using the custom keyword object
        keywordObj.click(driver, "login-button", "ID");

        // Close the browser
        driver.quit();
    }
}
