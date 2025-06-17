package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LocatorsTest {

    WebDriver driver;
    public static final String URL = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";

    @BeforeClass
    public void setUp() {
        // If ChromeDriver path is not set in system PATH, set it here:
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testByHtmlAttributes() {
        driver.get(URL);

        WebElement textById = driver.findElement(By.id("my-text-id"));
        Assert.assertEquals(textById.getDomAttribute("Type"), ("text"), "Element is not present");
        Assert.assertEquals(textById.getDomAttribute("myprop"), ("myvalue"), "Element is not present");
              
    }
    
//    @Test
//    public void testByTag() {
//    	driver.get(URL);
//    	
//    	WebElement element = driver.findElement(By.className("form-control"));
//    	Assert.assertEquals(element.get(0).getDomAttribute("name"), ("my-text"));
//    			
//    }
    

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
