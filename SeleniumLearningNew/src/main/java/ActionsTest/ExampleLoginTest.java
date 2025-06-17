package ActionsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExampleLoginTest {
    public static void main(String[] args) {
        // Set path to chromedriver if not set in system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://www.saucedemo.com/");

        // Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Click submit button
        driver.findElement(By.id("login-button")).click();

        // Assert page title contains "Welcome"
        if(driver.getTitle().contains("Swag Labs")) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }

        // Close the browser
        driver.quit();
    }
}
