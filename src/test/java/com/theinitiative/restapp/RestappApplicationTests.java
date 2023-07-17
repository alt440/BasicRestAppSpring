package com.theinitiative.restapp;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestappApplicationTests extends BaseSeleniumTests{

	@org.junit.Test
	public void whenButtonClick_counterIncreases() {
		driver.get("http://localhost:8080/index.html");
		WebElement elementButton = driver.findElement(By.id("testButton"));
		elementButton.click();
		assertNotNull("The button must not be null", elementButton);
		new WebDriverWait(driver, java.time.Duration.ofMillis(10000))
   			.until(ExpectedConditions.textToBe(By.id("messageOutput"), "You have clicked the button 1 times!"));

		elementButton.click();
		new WebDriverWait(driver, java.time.Duration.ofMillis(10000))
   			.until(ExpectedConditions.textToBe(By.id("messageOutput"), "You have clicked the button 2 times!"));
	}

}
