package com.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
//Singleton pattern is used to create 
//only one instance of a class i.e you won't be able to create multiple instance within the same execution
//When we develop a class in such a way that it can have only instance at any time, is called Singleton design pattern. It is very useful when you need to use same object of a class across all classes or framework. Singleton class must return the same instance again, 
//if it is instantiated again.
//Declare constructor of class as private so that no one instantiate class outside of it.
//Declare a static reference variable of class. Static is needed to make it available globally.
//Declare a static method with return type as object of class which should check if class is already instantiated once.
	
public static WebDriver driver=null;
public static String browsername="Chrome";

public static void initialization()
{
	if(driver==null)
	{
		if(browsername.equalsIgnoreCase("Mozilla"))
		{
			System.setProperty("webdriver.gecko.driver","Driver/geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

		}
		else if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		} 
	
	}
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://classic.crmpro.com/index.html");

	
}

public void quit()
{
	driver.quit();
	driver=null;
}

public void close()
{
	driver.close();
	driver=null;
}
	

}
