package com.qa.TestNG.com.qa.TestNG;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluintWait {
	
	WebDriver driver;
	//When you try to test the presence of an element that may appear after every 
	//x seconds/minutes (Just an example, this is my guess of where such a thing can be used).,you can use it while defining the AJAX
	//components
	// Waiting 30 seconds for an element to be present on the page, checking
	// for its presence once every 5 seconds.
	   @SuppressWarnings("deprecation")
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	       .withTimeout(30, TimeUnit.SECONDS)
	       .pollingEvery(5, TimeUnit.SECONDS)
	       .ignoring(NoSuchElementException.class);

	   WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
	     public WebElement apply(WebDriver driver) {
	       return driver.findElement(By.id("foo"));
	     }
	   });
}
