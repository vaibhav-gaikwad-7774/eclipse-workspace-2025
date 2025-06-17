package ActionsTest;

import static org.testng.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CrossBrowserTests {

    private WebDriver driver;

    @Test(dataProvider = "getBrowserData")
    public void testTitle(String browser) {
        this.initializeDriver(browser);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertTrue(driver.getTitle().contains("Selenium WebDriver"), "Title does not contain expected text");
    }

    public void initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            // Create a unique user-data-dir path for each session
            Path userDataDirPath = Paths.get("C:/path/to/unique/edge/data/dir_" + System.currentTimeMillis());
            try {
                Files.createDirectories(userDataDirPath);  // Ensure the directory exists
            } catch (Exception e) {
                System.out.println("Error creating user-data-dir: " + e.getMessage());
            }

            // Set EdgeOptions with the unique user-data-dir
            EdgeOptions options = new EdgeOptions();
            options.addArguments("user-data-dir=" + userDataDirPath.toString());
            driver = new EdgeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().window().maximize();
    }

    @DataProvider
    public Object[][] getBrowserData() {
        return new Object[][]{
                {"chrome"},
                {"edge"},
                {"firefox"}
        };
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
