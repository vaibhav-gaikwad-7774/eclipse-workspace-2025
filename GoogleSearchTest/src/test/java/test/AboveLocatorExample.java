package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AboveLocatorExample {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        // Wait for password field to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        
        // Find the login button above the password field
        WebElement loginButton = driver.findElement(RelativeLocator.with(By.tagName("input")).above(passwordField));
        
        // Click the login button
        loginButton.click();

        // Print success message
        System.out.println("Successfully clicked the login button above the password field.");

        driver.quit();
    }
}
