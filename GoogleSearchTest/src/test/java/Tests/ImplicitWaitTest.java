package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ImplicitWaitTest {
    public static void main(String[] args) {
        // Set up FirefoxDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            // Set implicit wait to 10 seconds
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            // Navigate to Saucedemo
            driver.get("https://www.saucedemo.com");
            
            // Find login button
            WebElement loginButton = driver.findElement(By.id("login-button"));
            System.out.println("Login button found: " + loginButton.getAttribute("value"));
            
            // Click login button (assumes element is ready within 10 seconds)
            loginButton.click();
        } finally {
            // Close browser
            driver.quit();
        }
    }

    }