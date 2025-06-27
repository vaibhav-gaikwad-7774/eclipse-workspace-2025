package OtherTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ExplicitWaitTest {
    public static void main(String[] args) {
        // Set up FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        try {
            // Navigate to Saucedemo
            driver.get("https://www.saucedemo.com");

            // Wait up to 10 seconds for username field to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement usernameField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("user-name"))
            );

            // Enter username
            usernameField.sendKeys("standard_user");
            System.out.println("Username entered successfully.");
        } finally {
            // Close browser
            driver.quit();
        }
    }
}