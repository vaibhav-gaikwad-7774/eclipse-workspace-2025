package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import actions.BaseTest;

public class InteractionsTest extends BaseTest{
	public static final String URL = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";

	 @Test
	    public void testClickButton() {
	        driver.get(URL);

	        WebElement submitButton = driver.findElement(By.xpath("//button[normalize-space()='Submit']"));
	        submitButton.click();

	        WebElement confirmationHeader = driver.findElement(By.cssSelector(".display-6"));
	        String text = confirmationHeader.getText();
	        Assert.assertEquals("Form submitted", text);
	    }

}
