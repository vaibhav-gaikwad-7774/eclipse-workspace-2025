package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class WebElementCommandsTest {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to Saucedemo
            driver.get("https://www.saucedemo.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // 1. sendKeys: Enter username and password
            WebElement username = driver.findElement(By.id("user-name"));
            username.sendKeys("standard_user");
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("secret_sauce");
            System.out.println("Entered credentials.");

            // 2. isDisplayed: Check if login button is visible
            WebElement loginButton = driver.findElement(By.id("login-button"));
            System.out.println("Is login button displayed? " + loginButton.isDisplayed());

            // 3. isEnabled: Check if login button is enabled
            System.out.println("Is login button enabled? " + loginButton.isEnabled());

            // 4. getLocation: Get login button coordinates
            System.out.println("Login button location: " + loginButton.getLocation());

            // 5. getSize: Get login button size
            System.out.println("Login button size: " + loginButton.getSize());

            // 6. getCssValue: Get login button background color
            System.out.println("Login button background: " + loginButton.getCssValue("background-color"));

            // 7. getAttribute: Get login button value attribute
            System.out.println("Login button value: " + loginButton.getAttribute("value"));

            // 8. getTagName: Get login button tag
            System.out.println("Login button tag: " + loginButton.getTagName());

            // 9. click: Click login button
            loginButton.click();
            System.out.println("Clicked login button.");

            // 10. getText: Get page title after login
            WebElement title = driver.findElement(By.className("title"));
            System.out.println("Page title: " + title.getText());

            // 11. isSelected: Check if filter dropdown is selected
            WebElement filter = driver.findElement(By.className("product_sort_container"));
            System.out.println("Is filter selected? " + filter.isSelected());

            // 12. clear: Clear and re-enter username after failed login
            driver.get("https://www.saucedemo.com"); // Reload page
            username = driver.findElement(By.id("user-name"));
            username.sendKeys("invalid_user");
            username.clear();
            username.sendKeys("standard_user");
            System.out.println("Cleared and re-entered username.");

            // 13. submit: Submit login form
            loginButton = driver.findElement(By.id("login-button"));
            loginButton.submit();
            System.out.println("Submitted login form.");

            // Pause to observe results
            Thread.sleep(5000);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Close browser
            driver.quit();
        }
    }
}