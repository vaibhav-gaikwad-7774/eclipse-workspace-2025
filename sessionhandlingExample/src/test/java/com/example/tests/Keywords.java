package com.example.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Keywords {
    private String path;

    public Keywords(String path) {
        this.path = path;
    }

    public void click(WebDriver driver, String ObjectName, String typeLocator) throws IOException {
        driver.findElement(this.getObject(ObjectName, typeLocator)).click();
    }

    By getObject(String ObjectName, String typeLocator) throws IOException {
        File file = new File(path + "\\Externals\\ObjectRepository.properties");
        Properties prop = new Properties();

        try (FileInputStream fileInput = new FileInputStream(file)) {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

        if (typeLocator.equalsIgnoreCase("XPATH")) {
            return By.xpath(prop.getProperty(ObjectName));
        } else if (typeLocator.equalsIgnoreCase("ID")) {
            return By.id(prop.getProperty(ObjectName));
        } else if (typeLocator.equalsIgnoreCase("NAME")) {
            return By.name(prop.getProperty(ObjectName));
        } else {
            throw new IllegalArgumentException("Invalid locator type: " + typeLocator);
        }
    }
}
