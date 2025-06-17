


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;


public class FirstSeleniumTest {
    private WebDriver driver;

    @BeforeGroups
    public void setUp() {
        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");
        // Initialize ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin() {
        // Navigate to the website
        driver.get("https://www.saucedemo.com");

        // Find the username field and enter the username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Find the password field and enter the password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        // Verify successful login by checking for the inventory container
        WebElement inventoryContainer = driver.findElement(By.className("inventory_list"));
        assertTrue(inventoryContainer.isDisplayed(), "Login failed: Inventory list not displayed");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}