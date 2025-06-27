package Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends Tests.BaseTest {
    @Test
    public void testValidLogin() {
        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");

        // Locate and interact with login elements
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Optionally, verify successful login by checking if an element is present
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Login Successful. Current URL: " + currentUrl);
    }
}