package Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import actions.BaseTest;

public class InteractionsTest extends BaseTest{
	public static final String URL = "https://www.google.com";
	@Test
    public void testClickLink() {
        driver.get(URL);
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("mail"),
                          "URL does not contain 'mail'. Actual URL: " + currentUrl);
    }
}



















//package Interactions;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import actions.BaseTest;
//
//public class InteractionsTest extends BaseTest{
//	public static final String URL  = "https://www.google.com";
	
		
//			@Test
//	public void testClickLink() {
//			driver.get(URL);
//			WebElement gmail1  = driver.findElement(By.className("gb_X"));
//			gmail1.click();
//			
//			String currentUrl = driver.getCurrentUrl();
//			Assert.assertTrue(currentUrl.equals("https://workspace.google.com/intl/en-US/gmail/"));
			
//	 @Test
//	    public void testClickLink1() {
//	        driver.get(URL);
//
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	        // Wait for and click apps icon
//	        WebElement apps = wait.until(ExpectedConditions.elementToBeClickable(By.className("gb_B")));
//	        apps.click();
//
//	        // Wait for and click internal apps link
//	        WebElement internalapps = wait.until(ExpectedConditions.elementToBeClickable(By.className("tX9u1b")));
//	        internalapps.click();
//
//	        // Verify URL changed as expected (update the URL below as per actual expected)
//	        String expectedUrl = "https://news.google.com/home?hl=en-IN&gl=IN&ceid=IN:en"; // replace with actual expected URL
//	        wait.until(ExpectedConditions.urlContains("https://news.google.com/home?hl=en-IN&gl=IN&ceid=IN:en")); // or use urlToBe()
//
//	        String internalAppsUrl = driver.getCurrentUrl();
//	        System.out.println(internalAppsUrl);
//
//	        Assert.assertTrue(internalAppsUrl.contains("expected.internal.apps.url"), "URL does not contain expected substring.");
//	    }
//	}