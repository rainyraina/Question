package com.mycompany.app;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Integration UI test for PHP App.
 */
public class AppTest
{
	WebDriver driver; 
	WebDriverWait wait; 
	String url = "http://172.17.0.2";
	String url2 = "http://172.17.0.2/result.php";
	String validEmail = "userm";
	String validPassword = "/<(.*)>/;";
	String invalidEmail = "none@example.com";
	String invalidPassword = "password";

    @Before
    public void setUp() { 
		driver = new HtmlUnitDriver(); 
		wait = new WebDriverWait(driver, 10); 
	} 

	@After
    public void tearDown() { 
		driver.quit(); 
	}	 
	
    @Test
    public void Validation() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Home")); 

		//enter input
		//driver.findElement(By.name("email")).sendKeys(validEmail);
		driver.findElement(By.name("searchItem")).sendKeys(validPassword);
		//click submit
		driver.findElement(By.name("submit")).submit();
	
		//check result 
		//String expectedResult = "Dashboard |"; 
	    	driver.get(url);
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains("Home")); 
		assertTrue(isResultCorrect == true); 
	}

	    @Test
    public void next() 
		throws InterruptedException { 

		//get web page
		driver.get(url);
		//wait until page is loaded or timeout error
		wait.until(ExpectedConditions.titleContains("Home")); 

		//enter input
		//driver.findElement(By.name("email")).sendKeys(validEmail);
		driver.findElement(By.name("searchItem")).sendKeys(validEmail);
		//click submit
		driver.findElement(By.name("submit")).submit();
	
		//check result 
		//String expectedResult = "Dashboard |"; 
		boolean isResultCorrect = wait.until(ExpectedConditions.titleContains("Results")); 
		assertTrue(isResultCorrect == true); 
	}

  
		
		


}
