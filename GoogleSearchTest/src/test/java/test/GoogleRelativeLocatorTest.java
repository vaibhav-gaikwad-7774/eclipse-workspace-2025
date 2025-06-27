package test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleRelativeLocatorTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set path to ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // Update with your path
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @Test
    public void testAbove() {
        // Locate the search bar
        WebElement searchBar = driver.findElement(By.name("q"));
        // Find the Google logo above the search bar
        WebElement logo = driver.findElement(with(By.tagName("img")).above(searchBar));
        System.out.println("Found Google logo above search bar: " + logo.getAttribute("alt"));
    }

    @Test
    public void testBelow() {
        // Locate the search bar
        WebElement searchBar = driver.findElement(By.name("q"));
        // Find the "Google Search" button below the search bar
        WebElement searchButton = driver.findElement(with(By.name("btnK")).below(searchBar));
        System.out.println("Found 'Google Search' button below search bar: " + searchButton.getAttribute("value"));
    }

    @Test
    public void testToRightOf() {
        // Locate the "Google Search" button
        WebElement searchButton = driver.findElement(By.name("btnK"));
        // Find the "I'm Feeling Lucky" button to the right of the "Google Search" button
        WebElement luckyButton = driver.findElement(with(By.name("btnI")).toRightOf(searchButton));
        System.out.println("Found 'I'm Feeling Lucky' button to the right of 'Google Search': " + luckyButton.getAttribute("value"));
    }

    @Test
    public void testToLeftOf() {
        // Locate the "I'm Feeling Lucky" button
        WebElement luckyButton = driver.findElement(By.name("btnI"));
        // Find the "Google Search" button to the left of the "I'm Feeling Lucky" button
        WebElement searchButton = driver.findElement(with(By.name("btnK")).toLeftOf(luckyButton));
        System.out.println("Found 'Google Search' button to the left of 'I'm Feeling Lucky': " + searchButton.getAttribute("value"));
    }

    @Test
    public void testNear() {
        // Locate the search bar
        WebElement searchBar = driver.findElement(By.name("q"));
        // Find a button near the search bar (e.g., "Google Search" button)
        WebElement nearbyButton = driver.findElement(with(By.tagName("input")).near(searchBar));
        System.out.println("Found button near search bar: " + nearbyButton.getAttribute("value"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}