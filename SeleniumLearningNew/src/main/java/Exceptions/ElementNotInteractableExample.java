package Exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementNotInteractableExample {

	public static void main(String[] args) {
        // Set path to chromedriver if not set in system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        try {
            // Try to click a hidden element
            driver.findElement(By.id("hidden-button")).click();
        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable: " + e.getMessage());
            // Fallback: Log error or make element interactable
        } finally {
            driver.quit();
        }
    }
}