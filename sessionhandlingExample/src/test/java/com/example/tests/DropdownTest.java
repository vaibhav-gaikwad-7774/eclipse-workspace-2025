package com.example.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        driver = new ChromeDriver();

        // Open the dropdown page
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void testDropdownSelection() {
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 2");
        String selectedOption = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOption, "Option 2", "Incorrect option selected");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
