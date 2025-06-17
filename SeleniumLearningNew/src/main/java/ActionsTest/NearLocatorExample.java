package ActionsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class NearLocatorExample {

	public static void main(String[] args) {
        // Set path to chromedriver if not set in system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        // Locate the username field
        WebElement usernameField = driver.findElement(By.id("user-name"));
        // Find a button near the username field
        WebElement nearbyButton = driver.findElement(RelativeLocator.with(By.tagName("input")).near(usernameField, 100));
        nearbyButton.click();

        driver.quit();
    }
}