package com.example.automation;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HoldKeyExample {
    public static void main(String[] args) {
        // Set up ChromeDriver dynamically using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to a webpage with selectable elements (jQuery UI Selectable demo page)
            driver.get("https://jqueryui.com/selectable/");

            // Switch to the frame containing the selectable elements
            driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

            // Locate multiple elements (Assume they have a common class name 'ui-selectee')
            List<WebElement> elements = driver.findElements(By.className("ui-selectee"));

            // Initialize Actions class for key-hold and click actions
            Actions actions = new Actions(driver);

            // Hold down the SHIFT key and click on multiple elements to select them
            actions.keyDown(Keys.SHIFT)
                    .click(elements.get(0)) // Select first element
                    .click(elements.get(1)) // Select second element
                    .click(elements.get(2)) // Select third element
                    .keyUp(Keys.SHIFT)      // Release the SHIFT key
                    .perform();

            // Optional: pause to visually confirm the selection
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
