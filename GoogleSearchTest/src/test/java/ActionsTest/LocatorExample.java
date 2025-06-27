package ActionsTest;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LocatorExample {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Initialize the WebDriver and set up the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAbove() {
        // Navigate to Google
        driver.get("https://www.google.com");

        // Locate the search bar
        WebElement searchBar = driver.findElement(By.name("q"));

        // Debugging: print the location of the search bar
        System.out.println("Search bar location: " + searchBar.getLocation());

        // Find the Google logo above the search bar using Relative Locator
        WebElement logo = driver.findElement(with(By.tagName("img")).above(searchBar));

        // Get the logo's alt attribute and print it
        String logoAlt = logo.getAttribute("alt");
        System.out.println("Found logo above search bar: " + logoAlt);

        // Verify the logo contains "Google"
        assert logoAlt.contains("Google") : "Logo not found above search bar!";
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the test is finished
        if (driver != null) {
            driver.quit();
        }
    }
}
