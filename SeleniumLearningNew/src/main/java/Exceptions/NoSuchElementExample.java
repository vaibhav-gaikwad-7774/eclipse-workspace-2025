package Exceptions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoSuchElementExample {

	public static void main(String[] args) {
        // Set path to chromedriver if not set in system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait for the element to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}