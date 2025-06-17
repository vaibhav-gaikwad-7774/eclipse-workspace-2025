package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Navigate to file upload page
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    @Test
    public void testFileUpload() {
        // Path to the file to upload
        String filePath = "C:\\Users\\GFG0329\\eclipse-workspace\\sessionhandlingExample\\Untitled 1";

        // Upload file
        driver.findElement(By.id("file-upload")).sendKeys(filePath);

        // Click the submit button
        driver.findElement(By.id("file-submit")).click();

        // Verify the success message
        String successMessage = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(successMessage, "File Uploaded!", "File upload failed");
    }

    @AfterMethod
    public void tearDown() {
        // Close browser after test
        driver.quit();
    }
}
