package ActionsTest;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Example_LoginTest {
    public static void main(String[] args) {
        // Optional: Set path to chromedriver if not already in system PATH
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Setup Chrome options (start maximized)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to the website
            driver.get("https://www.geeksforgeeks.org/");

            // Add a cookie
            Cookie cookie = new Cookie.Builder("foo", "bar").build();
            driver.manage().addCookie(cookie);
            System.out.println("Cookie added: {'name': 'foo', 'value': 'bar'}");

            // Retrieve the cookie
            Cookie retrievedCookie = driver.manage().getCookieNamed("foo");
            System.out.println("Retrieved cookie: " + retrievedCookie);

            // Verify the cookie
            if (retrievedCookie != null &&
                "foo".equals(retrievedCookie.getName()) &&
                "bar".equals(retrievedCookie.getValue())) {
                System.out.println("Cookie verification passed!");
            } else {
                System.out.println("Cookie verification failed!");
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
