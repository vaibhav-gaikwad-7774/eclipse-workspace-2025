package ActionsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParallelTestWithMultiThread {
    private WebDriver driver;
    private WebDriverWait wait;
    private By fullNameField = By.id("user_full_name");
    private By emailField = By.id("user_email_login");
    private By passwordField = By.id("user_password");

    public ParallelTestWithMultiThread(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void enterFullName(String name) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(fullNameField));
        element.sendKeys(name);
    }

    public void enterEmail(String email) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        element.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        element.sendKeys(password);
    }

    public boolean isFormPopulated() {
        return !driver.findElement(fullNameField).getAttribute("value").isEmpty() &&
               !driver.findElement(emailField).getAttribute("value").isEmpty() &&
               !driver.findElement(passwordField).getAttribute("value").isEmpty();
    }
}