package ActionsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CrossBrowserTest {

    private WebDriver driver;

    @Test(dataProvider = "getBrowserData")
    public void testLoginFunctionality(String browser) {
        // Initialize WebDriver based on the browser
        initializeDriver(browser);

        try {
            // Navigate to SauceDemo login page
            driver.get("https://www.saucedemo.com/");

            // Validate page title
            Assert.assertTrue(driver.getTitle().contains("Swag Labs"), 
                "Page title does not contain 'Swag Labs' on " + browser);

            // Perform login
            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");
            loginButton.click();

            // Wait for page load (implicit wait could be set globally)
            try {
                Thread.sleep(2000); // Simple wait; replace with explicit wait in production
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Validate successful login by checking for inventory page
            WebElement inventoryContainer = driver.findElement(By.className("inventory_list"));
            Assert.assertTrue(inventoryContainer.isDisplayed(), 
                "Login failed: Inventory list not displayed on " + browser);

            // Validate URL after login
            Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), 
                "URL does not indicate successful login on " + browser);

            System.out.println("Test passed on " + browser + ": Login functionality works.");
        } catch (Exception e) {
            System.err.println("Test failed on " + browser + ": " + e.getMessage());
            Assert.fail("Test failed on " + browser + ": " + e.getMessage());
        }
    }

    public void initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            // Optional: Add headless mode for CI/CD
            // options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            // Optional: Add headless mode
            // options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Maximize window (optional, as ChromeOptions can handle this)
        driver.manage().window().maximize();
    }

    @DataProvider
    public Object[][] getBrowserData() {
        return new Object[][] {
            {"chrome"},
            {"firefox"}
        };
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}