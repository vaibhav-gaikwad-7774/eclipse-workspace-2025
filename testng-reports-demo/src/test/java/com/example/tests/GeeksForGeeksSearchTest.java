package com.example.tests; // Keep your package name as it is or adjust if needed

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; // Or FirefoxDriver, EdgeDriver
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class GeeksForGeeksSearchTest {

    private WebDriver driver; // Declare WebDriver at class level

    // This method runs before each test method
    @BeforeMethod
    public void setup() {
        // Automatically set up the Chrome browser driver
        WebDriverManager.chromedriver().setup(); // Use .firefoxdriver().setup() for Firefox, etc.
        driver = new ChromeDriver(); // Initialize ChromeDriver
        driver.manage().window().maximize(); // Maximize the browser window
        // Set an implicit wait for elements to appear (useful for dynamic pages)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // This is our actual test method
    @Test
    public void searchForJavaTutorialsOnGfG() {
        // 1. Navigate to GeeksforGeeks
        driver.get("https://www.geeksforgeeks.org/");

        // 2. Find the search icon/button to open the search bar (if present)
        // GFG often has a search icon/magnifying glass that needs to be clicked first.
        // Let's try to locate it. This locator might need adjustment based on GFG's current UI.
        try {
            WebElement searchIcon = driver.findElement(By.cssSelector("span.search-icon")); // Common CSS selector for search icon
            searchIcon.click();
            System.out.println("Clicked search icon.");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Search icon not found or not needed. Proceeding directly to search box.");
            // If the search bar is always visible, this block might be skipped or the element might have a different locator.
        }


        // 3. Find the search input field
        // GFG's search input field often has a specific ID or class
        WebElement searchBox = driver.findElement(By.id("gsc-i-id1")); // Common ID for GFG search input inside the popup/bar

        // 4. Type "Java Tutorial" into the search box
        searchBox.sendKeys("Java Tutorial");

        // 5. Submit the search (simulate pressing Enter)
        // Often, hitting Enter on the search box submits the query.
        searchBox.submit();

        // Add a small wait to ensure the search results page loads
        // Implicit wait will handle element finding, but a small Thread.sleep can help with page transitions
        try {
            Thread.sleep(2000); // Wait for 2 seconds for the page to fully load
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 6. Verify the page title after search
        // The title of GFG search results page often includes the search query.
        String expectedTitlePartial = "Java Tutorial - GeeksforGeeks"; // Adjust based on actual GFG title
        String actualTitle = driver.getTitle();

        System.out.println("Expected Title (partial match): " + expectedTitlePartial);
        System.out.println("Actual Title: " + actualTitle);

        // Assert that the actual title contains the expected partial title
        Assert.assertTrue(actualTitle.contains(expectedTitlePartial),
                          "Page title does not contain '" + expectedTitlePartial + "' after search! Actual: " + actualTitle);
    }

    // This method runs after each test method
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit(); // Close all browser windows and end the WebDriver session
        }
    }
}