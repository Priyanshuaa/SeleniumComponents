package com.qa.TestNG.com.qa.TestNG;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopup {
	static WebDriver driver;
	public static void main(String args[]) throws InterruptedException
	{
		//1. alerts -- JavaScript Pop UP-- Alert API (accept, dismiss)
		//2. File Upload pop up -- Browse Button (type = file, sendKeys(path)
		//3. Browser Window Popup - Advertisement pop up (windowHandler API - getWindowHandles() )
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get("http://popuptest.com/goodpopups.html");
		driver.findElement(By.linkText("Good PopUp #2")).click();
		Thread.sleep(2000);
		//Set doesn't store the values in the form of an index,so you have to use Iterator for that.
		//We can't get any alternative solution to get the Window id,you have to use SET Method.
		Set<String> handler=driver.getWindowHandles();
		Iterator<String> it=handler.iterator();
	    String parentwindowid=it.next();
	    System.out.println("Parent window id is"+parentwindowid);
	    String childwindowid=it.next();
	    System.out.println("Child window id is"+childwindowid);
	    driver.switchTo().window(childwindowid);
	    System.out.println("Child Window Title is"+driver.getTitle());
	    driver.close();
	    driver.switchTo().window(parentwindowid);
	    System.out.println("Parent Window Title is"+driver.getTitle());
		driver.findElement(By.linkText("Good PopUp #3")).click();
	    driver.switchTo().window(parentwindowid);
		Thread.sleep(2000);
		Set<String> handlers=driver.getWindowHandles();
		Iterator<String> it1=handler.iterator();
	    String popup3windowid=it1.next();
	    System.out.println("Pop up 3 Window id is"+popup3windowid);
	    driver.switchTo().window(popup3windowid); 
	    driver.switchTo().window(parentwindowid);
        Thread.sleep(5000);
		driver.findElement(By.linkText("Good PopUp #2")).click();
		driver.close();
        Thread.sleep(2000);
        driver.quit();
		}

}
