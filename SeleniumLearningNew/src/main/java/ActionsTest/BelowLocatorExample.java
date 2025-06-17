package ActionsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class BelowLocatorExample {

    public static void main(String[] args) {
        // Set path to chromedriver if not set in system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        // Locate the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        // Enter invalid credentials
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        loginButton.click();

        // Find the error message below the login button
        WebElement errorMessage = driver.findElement(RelativeLocator.with(By.tagName("h3")).below(loginButton));
        
        // Print the error message
        System.out.println("Error: " + errorMessage.getText());
        
        // Success message for the below locator
        System.out.println("Below locator executed successfully! Error message found below the login button.");

        driver.quit();
    }
}
