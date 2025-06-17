package ActionsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CrossBrowserTestSauceDemo {

    private WebDriver driver;

    @Test(dataProvider = "getBrowserData")
    public void testTitle(String browser) {
        // Initialize WebDriver based on the browser passed from DataProvider
        this.initializeDriver(browser);

        // Open the SauceDemo page
        driver.get("https://www.saucedemo.com/");

        // Validate that the title contains 'Swag Labs'
        Assert.assertTrue(driver.getTitle().contains("Swag Labs"), "Title does not contain expected text");

        // You can add more validations here for different scenarios as per your requirement
    }

    public void initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            // Chrome Options (example: you can add arguments for headless or other configurations)
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); // Maximize browser window
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            // Firefox Options (example: you can add arguments for headless or other configurations)
            driver = new FirefoxDriver();

        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Maximize the window
        driver.manage().window().maximize();
    }

    @DataProvider
    public Object[][] getBrowserData() {
        return new Object[][]{
                {"chrome"},
                {"firefox"}
        };
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser
        }
    }
}
