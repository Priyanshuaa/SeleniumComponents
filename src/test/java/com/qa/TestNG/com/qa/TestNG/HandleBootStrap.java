package com.qa.TestNG.com.qa.TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBootStrap {
	
	static WebDriver driver;
	
	public static void main(String args[]) throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
    driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
    List<WebElement> lst=driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li"));
    int drpsize=lst.size();
    for(int i=0;i<=drpsize;i++)
    {
    	System.out.println(lst.get(i).getText());
    	if(lst.get(i).getText().contains("Angular"))
    	{
    		lst.get(i).click();
    		break;

    	}
    	
    }       
    Thread.sleep(5000);
    driver.quit();
	}
	

}
