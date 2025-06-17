package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorCssTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // Auto-download driver
        WebDriver driver = new ChromeDriver(); // Open browser
        
        // Use file:// protocol and replace backslashes with forward slashes
        driver.get("file:///C:/Users/GFG0329/eclipse-workspace/SeleniumLearning/index.html"); 
        
        
        // Find element by className and do some operation (e.g., print text)
        String infoText = driver.findElement(By.className("information")).getText();
        System.out.println("Information Text: " + infoText);
        
        String Information = driver.findElement(By.name("fname")).getText();
        System.out.println("Information Text: " + infoText);

        driver.quit(); // Close browser
    }
}
