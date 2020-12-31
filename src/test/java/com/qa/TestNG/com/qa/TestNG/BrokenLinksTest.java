package com.qa.TestNG.com.qa.TestNG;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrokenLinksTest {
WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
	}
	
	@BeforeMethod
	public void getURL()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
	}
	
	@Test
	public void login() throws InterruptedException, IOException
	{
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		WebElement loginbtn=driver.findElement(By.xpath("//input[@value='Login']"));
		username.clear();
		username.sendKeys("naveenautomation");
		password.clear();
		password.sendKeys("test@123");
		Thread.sleep(5000);
		loginbtn.click();
	    driver.switchTo().frame("mainpanel");
	    //Links are associated with a tag
	    //Image are associated with img tag.
	    //Get the list of all links and images.
	    List<WebElement> lst=driver.findElements(By.tagName("a"));
	    lst.addAll(driver.findElements(By.tagName("img")));
	    int linksisze=lst.size();
	    System.out.println(linksisze);
	    
	    
	    //Get the list of all active links and Images.
	    List<WebElement> lst1=new ArrayList<WebElement>();
	    for(int i=0;i<linksisze;i++)
	    {
		    System.out.println(lst.get(i).getAttribute("href"));
	    	if(lst.get(i).getAttribute("href") !=null && (! lst.get(i).getAttribute("href").contains("javascript")))
	    	{ 
	    		lst1.add(lst.get(i));
	    	}	    	
	    }       
	    //get the size of the Active links.
	    System.out.println(lst1.size());
	    
	    //Check the href URl,with HTTP connection API
	    //some of the links are represented by Java Script,so you will have to ignore the links.
	    for(int j=0;j<lst1.size();j++)
	    {
	    	HttpURLConnection connection=(HttpURLConnection) new URL(lst1.get(j).getAttribute("href")).openConnection();
	    	connection.connect();
	    	connection.getResponseMessage();//It will return the status of the response codes,i.e OK
	    	connection.disconnect();
		    System.out.println(lst1.get(j).getAttribute("href")+ "------>" + connection.getResponseMessage());
	    }
	}
}
