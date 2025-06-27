package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AboveLocatorExample1 {
    public static void main(String[] args) {

        // Set Chrome options to enable incognito mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");  // Start Chrome in Incognito mode
        
        // Initialize ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);
        
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        // Wait for the "I'm Feeling Lucky" button to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time
        WebElement feelingLuckyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='btnI']")));
        
        // Find the "Google Search" button above the "I'm Feeling Lucky" button
        WebElement searchButton = driver.findElement(RelativeLocator.with(By.name("btnK")).above(feelingLuckyButton));
        
        // Click the "Google Search" button
        searchButton.click();

        // Print success message
        System.out.println("Successfully clicked the 'Google Search' button above 'I'm Feeling Lucky' button.");

        driver.quit();
    }
}
