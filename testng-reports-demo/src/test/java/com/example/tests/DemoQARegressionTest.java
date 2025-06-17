package com.example.tests;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoQARegressionTest {
    private WebDriver driver;
    private String username = "YOUR_BROWSERSTACK_USERNAME";
    private String accessKey = "YOUR_BROWSERSTACK_ACCESS_KEY";
    private String hubUrl = "https://hub-cloud.browserstack.com/wd/hub";

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "latest");
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("osVersion", "10");
        capabilities.setCapability("sessionName", "DemoQA Regression Test");
        capabilities.setCapability("buildName", "Regression Build 2025");
        driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
    }

    @Test(description = "Verify Text Box submission")
    public void testTextBox() {
        driver.get("https://demoqa.com/text-box");
        driver.findElement(By.id("userName")).sendKeys("John Doe");
        driver.findElement(By.id("userEmail")).sendKeys("john@example.com");
        driver.findElement(By.id("currentAddress")).sendKeys("123 Main St");
        driver.findElement(By.id("permanentAddress")).sendKeys("456 Elm St");
        driver.findElement(By.id("submit")).click();
        assertTrue(driver.findElement(By.id("output")).getText().contains("John Doe"), "Text Box submission failed");
    }

    @Test(description = "Verify Check Box selection")
    public void testCheckBox() {
        driver.get("https://demoqa.com/checkbox");
        driver.findElement(By.xpath("//button[@title='Expand all']")).click();
        driver.findElement(By.xpath("//label[@for='tree-node-home']")).click();
        assertTrue(driver.findElement(By.xpath("//span[@class='rct-checkbox']")).getAttribute("class").contains("checked"), "Check Box selection failed");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}