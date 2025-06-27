package Crossbrowser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class CrossBrowserTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.google.com");
    }

    @Test
    public void testGoogleSearch() {
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        searchBar.sendKeys("Selenium parallel testing");
        searchBar.submit();

        wait.until(ExpectedConditions.titleContains("Selenium parallel testing"));
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("Selenium parallel testing"), 
                   "Search results page title does not contain 'Selenium parallel testing' on " + driver.getClass().getSimpleName());
        System.out.println("Test passed on " + driver.getClass().getSimpleName() + ": " + pageTitle);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}