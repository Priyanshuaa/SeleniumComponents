package com.qa.TestNG.com.qa.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertpopupHandle {
	static WebDriver driver;

	public static void main(String args[]) throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
    WebElement signinbtn=driver.findElement(By.xpath("//input[@title='Sign in']"));
    signinbtn.click();
    Thread.sleep(5000);
    Alert alert=driver.switchTo().alert();
    String text=alert.getText();
    System.out.println(text);
    alert.accept();
    //alert.dismiss();
    Thread.sleep(5000);
    driver.quit();
	}

}
