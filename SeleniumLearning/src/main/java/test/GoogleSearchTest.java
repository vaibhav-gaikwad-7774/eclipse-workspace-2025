package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
	public static void main(String[] args) {
        // Setup Chrome Driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open Google
        driver.get("https://www.google.com");

        // Locate search box, enter query and submit
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        // Print the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
