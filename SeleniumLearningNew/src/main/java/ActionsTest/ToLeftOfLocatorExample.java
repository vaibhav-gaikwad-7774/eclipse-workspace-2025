package ActionsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ToLeftOfLocatorExample {

	public static void main(String[] args) {
        // Set path to chromedriver if not set in system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        // Log in
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        // Locate the "Add to cart" button
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        // Find the product name to the left
        WebElement productName = driver.findElement(RelativeLocator.with(By.className("inventory_item_name")).toLeftOf(addToCartButton));
        System.out.println("Product: " + productName.getText());

        driver.quit();
    }
}