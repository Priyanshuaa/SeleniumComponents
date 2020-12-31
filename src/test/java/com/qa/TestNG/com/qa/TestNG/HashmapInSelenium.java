package com.qa.TestNG.com.qa.TestNG;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HashmapInSelenium {
	
	//Category manager user --go to the app--add all the products
    //Customer user --go to the app-- buy a product --place an order
	//Admin user --go to the app-- can see all the orders
	//Seller user --go to the app--see only those orders which are relevant
    //Distributor User - go to the app--can see the respective order
    //Delivery Boy User --go to the app--can see the order and deliver the product
	//customer care user --go to the app-- log a ticket
	
	static WebDriver driver;
	
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		WebElement loginbtn=driver.findElement(By.xpath("//input[@value='Login']"));
		username.clear();
		username.sendKeys(getusername("User"));
		password.clear();
		password.sendKeys(getpassword("User"));
		Thread.sleep(5000);
		loginbtn.click();
	}
	
	public static HashMap<String, String> getcredentialsofHashMap()
	{
	   HashMap<String,String> rolemap=new HashMap<String,String>();
	   rolemap.put("User","Priyanshua:Chetu@123");
	   rolemap.put("Administrator","Chetna1133:Chetu@123");
	   rolemap.put("CategoryAdmin","Chetna1134:Chetu@123");
	   rolemap.put("SellerAdmin","Chetna1135:Chetu@123");
	   rolemap.put("DistributerAdmin","Chetna1136:Chetu@123");
	   rolemap.put("CustomerCareAdmin","Chetna1137:Chetu@123");
	   return rolemap;
	}
	
	public static String getusername(String role)
	{	
		String username=getcredentialsofHashMap().get(role);
		return username.split(":")[0];
	}
	
	public static String getpassword(String role)
	{
		String password=getcredentialsofHashMap().get(role);
		return password.split(":")[1];		
	}
	
	
	
	
	

}
