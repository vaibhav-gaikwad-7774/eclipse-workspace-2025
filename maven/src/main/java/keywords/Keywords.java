package keywords;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Keywords {
    private WebDriver driver;
    private Properties prop;
    private WebDriverWait wait;

    public Keywords(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.prop = loadProperties();
    }

    private Properties loadProperties() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("resources/objectRepository.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public void openUrl(String url) {
        driver.get(url);
        System.out.println("Opened URL: " + url);
    }

    public void enterText(String objectName, String text) {
        By locator = getLocator(objectName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
        System.out.println("Entered text: " + text + " in " + objectName);
    }

    public void click(String objectName) {
        By locator = getLocator(objectName);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        System.out.println("Clicked on " + objectName);
    }

    public boolean verifyElementPresent(String objectName) {
        By locator = getLocator(objectName);
        boolean isPresent = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        System.out.println("Element " + objectName + " is present: " + isPresent);
        return isPresent;
    }

    private By getLocator(String objectName) {
        String locatorValue = prop.getProperty(objectName);
        String[] parts = locatorValue.split(":", 2);
        String type = parts[0].toLowerCase();
        String value = parts[1];

        switch (type) {
            case "id": return By.id(value);
            case "name": return By.name(value);
            case "xpath": return By.xpath(value);
            case "css": return By.cssSelector(value);
            default: throw new IllegalArgumentException("Invalid locator type: " + type);
        }
    }
}