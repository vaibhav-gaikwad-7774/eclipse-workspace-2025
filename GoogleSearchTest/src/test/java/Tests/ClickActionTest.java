package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class ClickActionTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable (make sure to replace with your actual path)
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Update this path

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to Saucedemo and login
            driver.get("https://www.saucedemo.com");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Perform click action on "Add to Cart" button
            WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
            Actions actions = new Actions(driver);
            actions.click(addToCartButton).build().perform();
            System.out.println("Clicked 'Add to Cart' button.");

            // Verify cart update
            WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
            System.out.println("Cart items: " + cartBadge.getText());

            Thread.sleep(2000); // Pause to observe
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
