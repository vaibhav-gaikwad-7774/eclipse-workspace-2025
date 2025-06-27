package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;

public class FluentWaitTest {
    public static void main(String[] args) {
        // Set up FirefoxDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            // Navigate to Saucedemo
            driver.get("https://www.saucedemo.com");
            
            // Enter invalid credentials and click login
            driver.findElement(By.id("user-name")).sendKeys("invalid_user");
            driver.findElement(By.id("password")).sendKeys("wrong_password");
            driver.findElement(By.id("login-button")).click();
            
            // Fluent wait for error message
            Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) // Max wait time
                .pollingEvery(Duration.ofSeconds(1)) // Check every 1 second
                .ignoring(NoSuchElementException.class); // Ignore this exception
            
            // Use a different name for the parameter in the lambda expression
            WebElement errorMessage = wait.until(
                wd -> wd.findElement(By.cssSelector("h3[data-test='error']"))
            );
            
            System.out.println("Error message: " + errorMessage.getText());
        } finally {
            // Close browser
            driver.quit();
        }
    }
}
