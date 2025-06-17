package ActionsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class ToRightOfLocatorExample {

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
        // Locate a product image
        WebElement productImage = driver.findElement(By.cssSelector("img[alt='Sauce Labs Backpack']"));
        // Find the "Add to cart" button to the right
        WebElement addToCartButton = driver.findElement(RelativeLocator.with(By.tagName("button")).toRightOf(productImage));
        addToCartButton.click();

        driver.quit();
    }
}