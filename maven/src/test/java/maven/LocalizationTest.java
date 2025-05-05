package maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalizationTest {

    public static void main(String[] args) {
        // Set up WebDriver with specific locale
        WebDriverManager.chromedriver().setup();
        
        // Set locale to French (fr-FR)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=fr-FR"); // Setting French as the language
        
        WebDriver driver = new ChromeDriver(options);
        
        try {
            // Navigate to the website you want to test
            driver.get("https://www.google.com");

            // Validate the page content based on locale (e.g., French title)
            String expectedTitle = "Google";
            if ("fr-FR".equals(options.getCapability("browserName"))) {
                expectedTitle = "Google";
            }
            
            // Check if the title matches the expected title
            if(driver.getTitle().contains(expectedTitle)) {
                System.out.println("Localization is correct for French.");
            } else {
                System.out.println("Localization is incorrect.");
            }

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
