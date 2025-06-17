package ActionsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {
        // Set up WebDriver based on browser parameter
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void testValidLogin() {
        // Perform login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        // Verify successful login
        assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login failed on " + driver.getClass().getSimpleName());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}