package com.qa.TestNG.com.qa.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPopUP {
	static WebDriver driver;

	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	    WebElement filebrowsebtn=driver.findElement(By.xpath("//input[@id='fileupload']"));
	    //This option will only work when input type="file" attribute is present for this button in DOM,otherwise it won't work.
	    filebrowsebtn.sendKeys("E:\tabkeypress.png");
	    
	}

}
