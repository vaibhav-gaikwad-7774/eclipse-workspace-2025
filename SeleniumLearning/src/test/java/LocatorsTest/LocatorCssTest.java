package LocatorsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorCssTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup(); 
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/GFG0329/eclipse-workspace/SeleniumLearning/index.html");
    }

    @Test
    public void testInformationText() {
        String infoText = driver.findElement(By.className("information")).getText();
        System.out.println("Information Text: " + infoText);
    }

    @Test
    public void testNameFieldText() {
        // getText() on input usually returns empty; getAttribute("value") is better
        String nameValue = driver.findElement(By.name("fname")).getAttribute("value");
        System.out.println("Name Field Value: " + nameValue);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
