package Tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertTest {
    private WebDriver driver;
    private SoftAssert softAssert;

    @Test
    public void testGeeksforGeeksHomepage() {
        // Navigate to GeeksforGeeks
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
    	
        driver.get("https://www.geeksforgeeks.org");

        // Verify page title (intentionally incorrect to demonstrate Soft Assert)
        String actualTitle = driver.getTitle();
        String expectedTitle = "Incorrect Title for Testing";
        softAssert.assertEquals(actualTitle, expectedTitle, "Page title does not match expected value!");

        // Click the "Java" menu item
        WebElement javaLink = driver.findElement(By.xpath("//a[contains(text(), 'Java')]"));
        javaLink.click();
        System.out.println("Clicked 'Java' link successfully.");

        // Verify current URL after clicking
        String currentUrl = driver.getCurrentUrl();
        softAssert.assertTrue(currentUrl.contains("java"), "URL does not contain 'java' after clicking Java link!");

        driver.quit();
        // Call assertAll() to report any failures
        softAssert.assertAll();
    }

    
    
}