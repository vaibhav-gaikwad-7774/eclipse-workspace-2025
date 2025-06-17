package SeleniumCodes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // Auto-download driver
        WebDriver driver = new ChromeDriver(); // Open browser

        driver.get("https://www.google.com"); // Open URL
        System.out.println("Title: " + driver.getTitle()); // Print page title

        driver.quit(); // Close browser
    }
}
