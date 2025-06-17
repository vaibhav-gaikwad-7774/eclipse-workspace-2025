package ActionsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class AboveLocatorExample {
    public static void main(String[] args) {
        // Set path to chromedriver if not set in system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        // Locate the password field
        WebElement passwordField = driver.findElement(By.id("password"));
        // Find the login button above the password field
        WebElement loginButton = driver.findElement(RelativeLocator.with(By.tagName("input")).above(passwordField));
        
        // Click the login button
        loginButton.click();

        // Print success message
        System.out.println("Successfully clicked the login button above the password field.");

        driver.quit();
    }
}
