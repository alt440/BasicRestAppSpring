package com.theinitiative.restapp;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestappApplicationTest extends BaseSeleniumTests{

	@Test
	public void whenButtonClick_counterIncreases() {
		driver.get("http://localhost:8080/index.html");
		
	}

}
