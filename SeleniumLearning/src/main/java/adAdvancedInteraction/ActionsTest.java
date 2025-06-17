package adAdvancedInteraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import actions.BaseTest;

public class ActionsTest extends BaseTest{
	String URL = "https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html";
	
	@Test
	public void testMouseClick() throws InterruptedException {
		driver.get(URL);
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		WebElement campassImage = driver.findElement(By.xpath("/html/body/main/div/div[4]/div[1]/img"));
		action.moveToElement(campassImage).perform();
		   Thread.sleep(3000);
		
	}

}
