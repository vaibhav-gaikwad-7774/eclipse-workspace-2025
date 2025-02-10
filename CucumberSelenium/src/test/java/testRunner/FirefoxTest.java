package testRunner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxTest {
    public static void main(String[] args) {
        // Setup GeckoDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();

        // Create an instance of FirefoxDriver
        WebDriver driver = new FirefoxDriver();

        // Open a website
        driver.get("https://www.example.com");

        // Close the browser
        driver.quit();
    }
}
