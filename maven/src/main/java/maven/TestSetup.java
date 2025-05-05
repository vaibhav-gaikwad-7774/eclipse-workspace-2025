package maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSetup {

    public static void setupDriver() {
        WebDriverManager.chromedriver().setup(); // This automatically sets up ChromeDriver
        WebDriver driver = new ChromeDriver(); // Initialize the ChromeDriver
    }
}
