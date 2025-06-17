package ActionsTest;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CookieManagementTest {
    public static void main(String[] args) {
        // Optional: Set path to chromedriver if not in system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Setup Chrome options (start maximized)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to the website
            driver.get("https://www.geeksforgeeks.org/");

            // Get all cookies initially
            Set<Cookie> initialCookies = driver.manage().getCookies();
            System.out.println("Initial cookies: " + initialCookies);

            // Add a cookie
            Cookie cookie = new Cookie.Builder("foo", "bar").build();
            driver.manage().addCookie(cookie);

            // Get cookies after adding
            Set<Cookie> afterAddCookies = driver.manage().getCookies();
            System.out.println("After adding 'foo': " + afterAddCookies);

            // Delete the cookie named "foo"
            driver.manage().deleteCookieNamed("foo");

            // Get cookies after deletion
            Set<Cookie> afterDeleteCookies = driver.manage().getCookies();
            System.out.println("After deleting 'foo': " + afterDeleteCookies);

            // Verify deletion
            Cookie retrievedCookie = driver.manage().getCookieNamed("foo");
            if (retrievedCookie == null) {
                System.out.println("Cookie 'foo' successfully deleted!");
            } else {
                System.out.println("Cookie 'foo' still exists!");
            }
        } finally {
            driver.quit();
        }
    }
}
